package com.load.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.load.utils.common.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.load.dao.*;
import com.load.model.*;
import com.load.service.*;
import com.load.util.ExcelUtil;
import com.load.util.PageUtils;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.load.pojo.common.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.load.service.impl.common.*;
@Service
public class RemoneyInfoServiceImpl{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	RemoneyInfoMapper mapper;
		@Autowired
	LoadApplyInfoMapper	loadApplyInfoMapper;
	@Autowired
	StudentInfoMapper	studentInfoMapper;

	/**
	 * 根据查询参数得到数据列表
	 * @param model
	 * @param page
	 * @param pageSize
	 * @param login
	 * @return
	 */
	public List getList(RemoneyInfo model
			,Integer page,Integer pageSize,LoginModel login) {
		RemoneyInfoExample se = new RemoneyInfoExample();
		RemoneyInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		se.setOrderByClause("id desc");
		List<RemoneyInfo> dataList = mapper.selectByExample(se);
		List<RemoneyInfo> list = (List<RemoneyInfo>)PageUtils.getCurrentPageList(dataList, page, pageSize);//将所得数据进行分页
		return castList(list,login,model);
	}
	/**
	 * 根据model值拼sql查询语句
	 * @param sc
	 * @param model
	 */
	private void queryContent(RemoneyInfoExample.Criteria sc,RemoneyInfo model){
			if(model.getId()!=null){
 			sc.andIdEqualTo(model.getId());
		}
		if(model.getApplyId()!=null){
 			sc.andApplyIdEqualTo(model.getApplyId());
		}

	}
	/**
	 * 转变整个list的类
	 * @param list
	 * @return
	 */
	private List<Map<String,Object>> castList(List<RemoneyInfo> list,LoginModel login,RemoneyInfo queryModel){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		for(RemoneyInfo model:list){
			rs.add(castModel(model,login,queryModel));//将得到的数据转成查询列表所需要显示的内容
		}	
		return rs;
	}
	/**
	 * 转成查询结果所需要的所有字段
	 * @param model
	 * @return
	 */
	private Map<String,Object> castModel(RemoneyInfo model,LoginModel login, RemoneyInfo queryModel){
		Map<String,Object> rs = new HashMap<String,Object>();
				rs.put("id",model.getId());
		rs.put("amount",model.getAmount());
		rs.put("applyId",model.getApplyId());
		List<Map<String,Object>> applyIdList = getLoadApplyInfoListForApplyId(login,0,null,null);
		if( model.getApplyId()!=null){//界面显示显示名称
			String str = model.getApplyId()+"";
			String [] strSplit = str.split(",");
			String rsStr="";
			for(String s:strSplit){
				for(Map<String,Object> map:applyIdList){
					if(map.get("id").toString().equals(s)){
						rsStr+=map.get("name").toString()+",";
					}
				}
			}
		if(rsStr.endsWith(",")){
			rsStr = rsStr.substring(0,rsStr.length()-1);
		}
		rs.put("applyIdStr",rsStr);
		}
		rs.put("userId",model.getUserId());
		List<Map<String,Object>> userIdList = getStudentInfoListForUserId(login,0,null,null);
		if( model.getUserId()!=null){//界面显示显示名称
			String str = model.getUserId()+"";
			String [] strSplit = str.split(",");
			String rsStr="";
			for(String s:strSplit){
				for(Map<String,Object> map:userIdList){
					if(map.get("id").toString().equals(s)){
						rsStr+=map.get("name").toString()+",";
					}
				}
			}
		if(rsStr.endsWith(",")){
			rsStr = rsStr.substring(0,rsStr.length()-1);
		}
		rs.put("userIdStr",rsStr);
		}
		rs.put("createTime",model.getCreateTime());
		rs.put("updateTime",model.getUpdateTime());
		rs.put("isDelete",model.getIsDelete());

		return rs;
	}
	/**
	 * 添加数据
	 * @param model
	 */
	public Map<String,Object> add(RemoneyInfo model) {
	 Map<String,Object> rs = new HashMap<String,Object>();
	 mapper.insertSelective(model);
		rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
	}
	/**
	 * 修改数据
	 * @param model
	 */
	public Map<String,Object> update(RemoneyInfo model) {
	 Map<String,Object> rs = new HashMap<String,Object>();
		mapper.updateByPrimaryKeySelective(model);
		    rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
	}
	/**
	 * 根据查询条件获取数据数目
	 */
	public int countByCritera(RemoneyInfoExample se){
		return mapper.countByExample(se);
	}
	/**
	 * 根据id得到数据
	 */
	public RemoneyInfo getById(Integer id,LoginModel login) {
		RemoneyInfo model = mapper.selectByPrimaryKey(id);
		
		return model;
	}
	/**
	 * 根据id得到数据详情，需要解释的字段做出响应解释
	 */
	public Map<String,Object> detail(Integer id,LoginModel login,RemoneyInfo queryModel) {
		RemoneyInfo model = mapper.selectByPrimaryKey(id);
		
		return castModel(model,login,queryModel);
	}
	
	/**
	 * 传需要的数据下拉列表给前台使用
	 * @param modelMap
	 * @param login
	 * @param queryModel
	 * @param isEdit
	 */
	public void setModelMapVal(ModelMap modelMap,LoginModel login,RemoneyInfo queryModel
	,Integer isEdit){
	  			LoadApplyInfoExample loadApplyInfoExample2 = new LoadApplyInfoExample();
			LoadApplyInfoExample.Criteria loadApplyInfoCriteria2 = loadApplyInfoExample2.createCriteria();
			loadApplyInfoCriteria2.andIsDeleteEqualTo(0);
 	modelMap.addAttribute("applyIdList",getLoadApplyInfoListForApplyId(login,isEdit,loadApplyInfoExample2,loadApplyInfoCriteria2));//得到申请数据下拉列表，并传给前台
			StudentInfoExample studentInfoExample3 = new StudentInfoExample();
			StudentInfoExample.Criteria studentInfoCriteria3 = studentInfoExample3.createCriteria();
			studentInfoCriteria3.andIsDeleteEqualTo(0);
 	modelMap.addAttribute("userIdList",getStudentInfoListForUserId(login,isEdit,studentInfoExample3,studentInfoCriteria3));//得到学生数据下拉列表，并传给前台

	}
	/**
	 * 列表查询使用，查出该查询条件下的数据总数
	 */
	public int count(RemoneyInfo model,LoginModel login) {
		RemoneyInfoExample se = new RemoneyInfoExample();
		RemoneyInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		return mapper.countByExample(se);
	}
	/**
	 * 删除数据
	 */
	public int delete(Integer id,LoginModel login) {
		RemoneyInfo model = new RemoneyInfo();
		model.setIsDelete(1);
		model.setId(id);
		return mapper.updateByPrimaryKeySelective(model);
	}
	/**
**获取LoadApplyInfo数据下拉列表
*/
public List<Map<String,Object>> getLoadApplyInfoListForApplyId(LoginModel login,Integer isEdit,LoadApplyInfoExample se,LoadApplyInfoExample.Criteria sc){
	List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
 	if(se==null||sc==null){
	 	se = new LoadApplyInfoExample();
	 	sc = se.createCriteria();
 	}
	List<LoadApplyInfo> list = loadApplyInfoMapper.selectByExample(se);
		for(LoadApplyInfo model:list){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",model.getId());
			map.put("name",model.getReason());
			rs.add(map);
		}
	return rs;
	}
/**
**获取StudentInfo数据下拉列表
*/
public List<Map<String,Object>> getStudentInfoListForUserId(LoginModel login,Integer isEdit,StudentInfoExample se,StudentInfoExample.Criteria sc){
	List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
 	if(se==null||sc==null){
	 	se = new StudentInfoExample();
	 	sc = se.createCriteria();
 	}
	List<StudentInfo> list = studentInfoMapper.selectByExample(se);
		for(StudentInfo model:list){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",model.getId());
			map.put("name",model.getName());
			rs.add(map);
		}
	return rs;
	}

	
	
}
