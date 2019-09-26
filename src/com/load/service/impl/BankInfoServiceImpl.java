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
public class BankInfoServiceImpl{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	BankInfoMapper mapper;
	
	/**
	 * 根据查询参数得到数据列表
	 * @param model
	 * @param page
	 * @param pageSize
	 * @param login
	 * @return
	 */
	public List getList(BankInfo model
			,Integer page,Integer pageSize,LoginModel login) {
		BankInfoExample se = new BankInfoExample();
		BankInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		se.setOrderByClause("id desc");
		List<BankInfo> dataList = mapper.selectByExample(se);
		List<BankInfo> list = (List<BankInfo>)PageUtils.getCurrentPageList(dataList, page, pageSize);//将所得数据进行分页
		return castList(list,login,model);
	}
	/**
	 * 根据model值拼sql查询语句
	 * @param sc
	 * @param model
	 */
	private void queryContent(BankInfoExample.Criteria sc,BankInfo model){
			if(model.getId()!=null){
 			sc.andIdEqualTo(model.getId());
		}

	}
	/**
	 * 转变整个list的类
	 * @param list
	 * @return
	 */
	private List<Map<String,Object>> castList(List<BankInfo> list,LoginModel login,BankInfo queryModel){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		for(BankInfo model:list){
			rs.add(castModel(model,login,queryModel));//将得到的数据转成查询列表所需要显示的内容
		}	
		return rs;
	}
	/**
	 * 转成查询结果所需要的所有字段
	 * @param model
	 * @return
	 */
	private Map<String,Object> castModel(BankInfo model,LoginModel login, BankInfo queryModel){
		Map<String,Object> rs = new HashMap<String,Object>();
				rs.put("id",model.getId());
		rs.put("name",model.getName());
		rs.put("passWord",model.getPassWord());
		rs.put("createTime",model.getCreateTime());
		rs.put("updateTime",model.getUpdateTime());
		rs.put("isDelete",model.getIsDelete());

		return rs;
	}
	/**
	 * 添加数据
	 * @param model
	 */
	public Map<String,Object> add(BankInfo model) {
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
	public Map<String,Object> update(BankInfo model) {
	 Map<String,Object> rs = new HashMap<String,Object>();
		mapper.updateByPrimaryKeySelective(model);
		    rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
	}
	/**
	 * 根据查询条件获取数据数目
	 */
	public int countByCritera(BankInfoExample se){
		return mapper.countByExample(se);
	}
	/**
	 * 根据id得到数据
	 */
	public BankInfo getById(Integer id,LoginModel login) {
		BankInfo model = mapper.selectByPrimaryKey(id);
		
		return model;
	}
	/**
	 * 根据id得到数据详情，需要解释的字段做出响应解释
	 */
	public Map<String,Object> detail(Integer id,LoginModel login,BankInfo queryModel) {
		BankInfo model = mapper.selectByPrimaryKey(id);
		
		return castModel(model,login,queryModel);
	}
	
	/**
	 * 传需要的数据下拉列表给前台使用
	 * @param modelMap
	 * @param login
	 * @param queryModel
	 * @param isEdit
	 */
	public void setModelMapVal(ModelMap modelMap,LoginModel login,BankInfo queryModel
	,Integer isEdit){
	  
	}
	/**
	 * 列表查询使用，查出该查询条件下的数据总数
	 */
	public int count(BankInfo model,LoginModel login) {
		BankInfoExample se = new BankInfoExample();
		BankInfoExample.Criteria sc = se.createCriteria();
		sc.andIsDeleteEqualTo(0);
		queryContent(sc,model);//根据查询条件拼查询语句
		return mapper.countByExample(se);
	}
	/**
	 * 删除数据
	 */
	public int delete(Integer id,LoginModel login) {
		BankInfo model = new BankInfo();
		model.setIsDelete(1);
		model.setId(id);
		return mapper.updateByPrimaryKeySelective(model);
	}
	
	
	
}
