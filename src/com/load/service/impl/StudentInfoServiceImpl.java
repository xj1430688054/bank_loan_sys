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
public class StudentInfoServiceImpl{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	StudentInfoMapper mapper;
		@Autowired
	SchoolInfoMapper	schoolInfoMapper;

	/**
	 * 根据查询参数得到数据列表
	 * @param model
	 * @param page
	 * @param pageSize
	 * @param login
	 * @return
	 */
	public List getList(StudentInfo model
			,Integer page,Integer pageSize,LoginModel login) {
		StudentInfoExample se = new StudentInfoExample();
		StudentInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		se.setOrderByClause("id desc");
		List<StudentInfo> dataList = mapper.selectByExample(se);
		List<StudentInfo> list = (List<StudentInfo>)PageUtils.getCurrentPageList(dataList, page, pageSize);//将所得数据进行分页
		return castList(list,login,model);
	}
	/**
	 * 根据model值拼sql查询语句
	 * @param sc
	 * @param model
	 */
	private void queryContent(StudentInfoExample.Criteria sc,StudentInfo model){
			if(model.getId()!=null){
 			sc.andIdEqualTo(model.getId());
		}
		if(model.getSchoolId()!=null){
 			sc.andSchoolIdEqualTo(model.getSchoolId());
		}
		if(model.getIsBlack()!=null){
 			sc.andIsBlackEqualTo(model.getIsBlack());
		}

	}
	/**
	 * 转变整个list的类
	 * @param list
	 * @return
	 */
	private List<Map<String,Object>> castList(List<StudentInfo> list,LoginModel login,StudentInfo queryModel){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		for(StudentInfo model:list){
			rs.add(castModel(model,login,queryModel));//将得到的数据转成查询列表所需要显示的内容
		}	
		return rs;
	}
	/**
	 * 转成查询结果所需要的所有字段
	 * @param model
	 * @return
	 */
	private Map<String,Object> castModel(StudentInfo model,LoginModel login, StudentInfo queryModel){
		Map<String,Object> rs = new HashMap<String,Object>();
				rs.put("id",model.getId());
		rs.put("name",model.getName());
		rs.put("passWord",model.getPassWord());
		rs.put("schoolId",model.getSchoolId());
		List<Map<String,Object>> schoolIdList = getSchoolInfoListForSchoolId(login,0,null,null);
		if( model.getSchoolId()!=null){//界面显示显示名称
			String str = model.getSchoolId()+"";
			String [] strSplit = str.split(",");
			String rsStr="";
			for(String s:strSplit){
				for(Map<String,Object> map:schoolIdList){
					if(map.get("id").toString().equals(s)){
						rsStr+=map.get("name").toString()+",";
					}
				}
			}
		if(rsStr.endsWith(",")){
			rsStr = rsStr.substring(0,rsStr.length()-1);
		}
		rs.put("schoolIdStr",rsStr);
		}
		rs.put("isBlack",model.getIsBlack());

 		rs.put("isBlackStr",DataListUtils.getIsBlackNameById( 
			model.getIsBlack()+"",login.getLoginType()));//解释该字段的意义
		rs.put("createTime",model.getCreateTime());
		rs.put("updateTime",model.getUpdateTime());
		rs.put("isDelete",model.getIsDelete());

		return rs;
	}
	/**
	 * 添加数据
	 * @param model
	 */
	public Map<String,Object> add(StudentInfo model) {
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
	public Map<String,Object> update(StudentInfo model) {
	 Map<String,Object> rs = new HashMap<String,Object>();
		mapper.updateByPrimaryKeySelective(model);
		    rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
	}
	/**
	 * 根据查询条件获取数据数目
	 */
	public int countByCritera(StudentInfoExample se){
		return mapper.countByExample(se);
	}
	/**
	 * 根据id得到数据
	 */
	public StudentInfo getById(Integer id,LoginModel login) {
		StudentInfo model = mapper.selectByPrimaryKey(id);
		
		return model;
	}
	/**
	 * 根据id得到数据详情，需要解释的字段做出响应解释
	 */
	public Map<String,Object> detail(Integer id,LoginModel login,StudentInfo queryModel) {
		StudentInfo model = mapper.selectByPrimaryKey(id);
		
		return castModel(model,login,queryModel);
	}
	
	/**
	 * 传需要的数据下拉列表给前台使用
	 * @param modelMap
	 * @param login
	 * @param queryModel
	 * @param isEdit
	 */
	public void setModelMapVal(ModelMap modelMap,LoginModel login,StudentInfo queryModel
	,Integer isEdit){
	  			SchoolInfoExample schoolInfoExample2 = new SchoolInfoExample();
			SchoolInfoExample.Criteria schoolInfoCriteria2 = schoolInfoExample2.createCriteria();
			schoolInfoCriteria2.andIsDeleteEqualTo(0);
 	modelMap.addAttribute("schoolIdList",getSchoolInfoListForSchoolId(login,isEdit,schoolInfoExample2,schoolInfoCriteria2));//得到所属学校数据下拉列表，并传给前台
 		List<Map<String,Object>> isBlackList =DataListUtils.getIsBlackList(login.getLoginType());//得到是否黑名单数据下拉列表，并传给前台
  		modelMap.addAttribute("isBlackList",isBlackList);

	}
	/**
	 * 列表查询使用，查出该查询条件下的数据总数
	 */
	public int count(StudentInfo model,LoginModel login) {
		StudentInfoExample se = new StudentInfoExample();
		StudentInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		return mapper.countByExample(se);
	}
	/**
	 * 删除数据
	 */
	public int delete(Integer id,LoginModel login) {
		StudentInfo model = new StudentInfo();
		model.setIsDelete(1);
		model.setId(id);
		return mapper.updateByPrimaryKeySelective(model);
	}
	/**
**获取SchoolInfo数据下拉列表
*/
public List<Map<String,Object>> getSchoolInfoListForSchoolId(LoginModel login,Integer isEdit,SchoolInfoExample se,SchoolInfoExample.Criteria sc){
	List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
 	if(se==null||sc==null){
	 	se = new SchoolInfoExample();
	 	sc = se.createCriteria();
 	}
	List<SchoolInfo> list = schoolInfoMapper.selectByExample(se);
		for(SchoolInfo model:list){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",model.getId());
			map.put("name",model.getName());
			rs.add(map);
		}
	return rs;
	}

	
	
}
