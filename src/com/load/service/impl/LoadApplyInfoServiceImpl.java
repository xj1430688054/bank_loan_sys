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
public class LoadApplyInfoServiceImpl{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	LoadApplyInfoMapper mapper;
		@Autowired
	StudentInfoMapper	studentInfoMapper;
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
	public List getList(LoadApplyInfo model
			,Integer page,Integer pageSize,LoginModel login) {
		LoadApplyInfoExample se = new LoadApplyInfoExample();
		LoadApplyInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		se.setOrderByClause("id desc");
		List<LoadApplyInfo> dataList = mapper.selectByExample(se);
		List<LoadApplyInfo> list = (List<LoadApplyInfo>)PageUtils.getCurrentPageList(dataList, page, pageSize);//将所得数据进行分页
		return castList(list,login,model);
	}
	/**
	 * 根据model值拼sql查询语句
	 * @param sc
	 * @param model
	 */
	private void queryContent(LoadApplyInfoExample.Criteria sc,LoadApplyInfo model){
			if(model.getId()!=null){
 			sc.andIdEqualTo(model.getId());
		}
		if(model.getStuId()!=null){
 			sc.andStuIdEqualTo(model.getStuId());
		}
		if(model.getRealName()!=null&&model.getRealName().equals("")==false){
 			sc.andRealNameLike("%"+model.getRealName()+"%");
		}
		if(model.getIdNumber()!=null&&model.getIdNumber().equals("")==false){
 			sc.andIdNumberLike("%"+model.getIdNumber()+"%");
		}
		if(model.getCelPhone()!=null&&model.getCelPhone().equals("")==false){
 			sc.andCelPhoneLike("%"+model.getCelPhone()+"%");
		}
		if(model.getSchoolCheckStatus()!=null){
 			sc.andSchoolCheckStatusEqualTo(model.getSchoolCheckStatus());
		}
		if(model.getScoolId()!=null){
 			sc.andScoolIdEqualTo(model.getScoolId());
		}

	}
	/**
	 * 转变整个list的类
	 * @param list
	 * @return
	 */
	private List<Map<String,Object>> castList(List<LoadApplyInfo> list,LoginModel login,LoadApplyInfo queryModel){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		for(LoadApplyInfo model:list){
			rs.add(castModel(model,login,queryModel));//将得到的数据转成查询列表所需要显示的内容
		}	
		return rs;
	}
	/**
	 * 转成查询结果所需要的所有字段
	 * @param model
	 * @return
	 */
	private Map<String,Object> castModel(LoadApplyInfo model,LoginModel login, LoadApplyInfo queryModel){
		Map<String,Object> rs = new HashMap<String,Object>();
				rs.put("id",model.getId());
		rs.put("stuId",model.getStuId());
		List<Map<String,Object>> stuIdList = getStudentInfoListForStuId(login,0,null,null);
		if( model.getStuId()!=null){//界面显示显示名称
			String str = model.getStuId()+"";
			String [] strSplit = str.split(",");
			String rsStr="";
			for(String s:strSplit){
				for(Map<String,Object> map:stuIdList){
					if(map.get("id").toString().equals(s)){
						rsStr+=map.get("name").toString()+",";
					}
				}
			}
		if(rsStr.endsWith(",")){
			rsStr = rsStr.substring(0,rsStr.length()-1);
		}
		rs.put("stuIdStr",rsStr);
		}
		rs.put("realName",model.getRealName());
		rs.put("idNumber",model.getIdNumber());
		rs.put("idnumberImg1",model.getIdnumberImg1());
		rs.put("idnumberImg2",model.getIdnumberImg2());
		rs.put("celPhone",model.getCelPhone());
		rs.put("email",model.getEmail());
		rs.put("pca",model.getPca());
		rs.put("address",model.getAddress());
		rs.put("moneyAmount",model.getMoneyAmount());
		rs.put("reason",model.getReason());
		rs.put("proveFile",model.getProveFile());
		rs.put("redate",model.getRedate());
		rs.put("reamount",model.getReamount());
		rs.put("restAmount",model.getRestAmount());
		rs.put("schoolCheckStatus",model.getSchoolCheckStatus());

 		rs.put("schoolCheckStatusStr",DataListUtils.getCheckStatusNameById( 
			model.getSchoolCheckStatus()+"",login.getLoginType()));//解释该字段的意义
		rs.put("schoolCheckRemark",model.getSchoolCheckRemark());
		rs.put("bankCheckStatus",model.getBankCheckStatus());

 		rs.put("bankCheckStatusStr",DataListUtils.getCheckStatusNameById( 
			model.getBankCheckStatus()+"",login.getLoginType()));//解释该字段的意义
		rs.put("bankCheckRemark",model.getBankCheckRemark());
		rs.put("scoolId",model.getScoolId());
		List<Map<String,Object>> scoolIdList = getSchoolInfoListForScoolId(login,0,null,null);
		if( model.getScoolId()!=null){//界面显示显示名称
			String str = model.getScoolId()+"";
			String [] strSplit = str.split(",");
			String rsStr="";
			for(String s:strSplit){
				for(Map<String,Object> map:scoolIdList){
					if(map.get("id").toString().equals(s)){
						rsStr+=map.get("name").toString()+",";
					}
				}
			}
		if(rsStr.endsWith(",")){
			rsStr = rsStr.substring(0,rsStr.length()-1);
		}
		rs.put("scoolIdStr",rsStr);
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
	public Map<String,Object> add(LoadApplyInfo model) {
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
	public Map<String,Object> update(LoadApplyInfo model) {
	 Map<String,Object> rs = new HashMap<String,Object>();
		mapper.updateByPrimaryKeySelective(model);
		    rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
	}
	/**
	 * 根据查询条件获取数据数目
	 */
	public int countByCritera(LoadApplyInfoExample se){
		return mapper.countByExample(se);
	}
	/**
	 * 根据id得到数据
	 */
	public LoadApplyInfo getById(Integer id,LoginModel login) {
		LoadApplyInfo model = mapper.selectByPrimaryKey(id);
		
		return model;
	}
	/**
	 * 根据id得到数据详情，需要解释的字段做出响应解释
	 */
	public Map<String,Object> detail(Integer id,LoginModel login,LoadApplyInfo queryModel) {
		LoadApplyInfo model = mapper.selectByPrimaryKey(id);
		
		return castModel(model,login,queryModel);
	}
	
	/**
	 * 传需要的数据下拉列表给前台使用
	 * @param modelMap
	 * @param login
	 * @param queryModel
	 * @param isEdit
	 */
	public void setModelMapVal(ModelMap modelMap,LoginModel login,LoadApplyInfo queryModel
	,Integer isEdit){
	  			StudentInfoExample studentInfoExample2 = new StudentInfoExample();
			StudentInfoExample.Criteria studentInfoCriteria2 = studentInfoExample2.createCriteria();
			studentInfoCriteria2.andIsDeleteEqualTo(0);
 	modelMap.addAttribute("stuIdList",getStudentInfoListForStuId(login,isEdit,studentInfoExample2,studentInfoCriteria2));//得到学生学号数据下拉列表，并传给前台
 		List<Map<String,Object>> schoolCheckStatusList =DataListUtils.getCheckStatusList(login.getLoginType());//得到学校审核状态数据下拉列表，并传给前台
  		modelMap.addAttribute("schoolCheckStatusList",schoolCheckStatusList);
 		List<Map<String,Object>> bankCheckStatusList =DataListUtils.getCheckStatusList(login.getLoginType());//得到银行审核状态数据下拉列表，并传给前台
  		modelMap.addAttribute("bankCheckStatusList",bankCheckStatusList);
			SchoolInfoExample schoolInfoExample5 = new SchoolInfoExample();
			SchoolInfoExample.Criteria schoolInfoCriteria5 = schoolInfoExample5.createCriteria();
			schoolInfoCriteria5.andIsDeleteEqualTo(0);
 	modelMap.addAttribute("scoolIdList",getSchoolInfoListForScoolId(login,isEdit,schoolInfoExample5,schoolInfoCriteria5));//得到所属学校数据下拉列表，并传给前台

	}
	/**
	 * 列表查询使用，查出该查询条件下的数据总数
	 */
	public int count(LoadApplyInfo model,LoginModel login) {
		LoadApplyInfoExample se = new LoadApplyInfoExample();
		LoadApplyInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		return mapper.countByExample(se);
	}
	/**
	 * 删除数据
	 */
	public int delete(Integer id,LoginModel login) {
		LoadApplyInfo model = new LoadApplyInfo();
		model.setIsDelete(1);
		model.setId(id);
		return mapper.updateByPrimaryKeySelective(model);
	}
	/**
**获取StudentInfo数据下拉列表
*/
public List<Map<String,Object>> getStudentInfoListForStuId(LoginModel login,Integer isEdit,StudentInfoExample se,StudentInfoExample.Criteria sc){
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
/**
**获取SchoolInfo数据下拉列表
*/
public List<Map<String,Object>> getSchoolInfoListForScoolId(LoginModel login,Integer isEdit,SchoolInfoExample se,SchoolInfoExample.Criteria sc){
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
