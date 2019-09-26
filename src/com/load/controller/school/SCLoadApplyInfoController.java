package com.load.controller.school;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.load.service.impl.common.DataListUtils;
import com.load.controller.BaseModel;
import com.load.dao.*;
import com.load.model.*;
import com.load.service.impl.*;
import com.load.util.*;
import java.text.SimpleDateFormat;
import com.load.pojo.common.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.load.utils.common.RandomCodeUtils;
import java.util.ArrayList;
import com.load.utils.common.CommonUtils;
@Controller
@RequestMapping("/school/loadApplyInfo")
public class SCLoadApplyInfoController implements BaseModel{
 	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	LoadApplyInfoServiceImpl service;
	@Autowired
	LoadApplyInfoMapper mapper;
	
	/**
	 * 返回贷款申请列表查询页面
	 */
	 @RequestMapping(value="")  
	 public String index(ModelMap modelMap,LoadApplyInfo data,HttpServletRequest request){
	 LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		 modelMap.addAttribute("pageSize", pageSize);
		 modelMap.addAttribute("modelName","贷款申请");
	 	modelMap.addAttribute("login",user);
		    modelMap.addAttribute("data",JSONObject.fromObject(data,CommonUtils.getJsonConfig()));
		service.setModelMapVal(modelMap,user,data,0);
			return "school/loadApplyInfo/list";		
		}
	 /**
	 * 根据查询条件分页查询贷款申请数据，然后返回给前台渲染
	 */
	 @RequestMapping(value="toList")  
	 @ResponseBody
	 public Object toList(LoadApplyInfo model,Integer page,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		model.setScoolId(user.getId());

		int total = service.count(model,user);
		int totalPage = total/pageSize;
		rs.put("data", service.getList(model, page, pageSize,user));
		rs.put("count", total);
		rs.put("totalPage", (totalPage+1));
		return rs;
	}
	 
	  
	
	 @RequestMapping("update")
	public String update(ModelMap modelMap,HttpServletRequest request
	,String act,String model,LoadApplyInfo data) {
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);	
  		modelMap.addAttribute("data", service.getById(data.getId(),user));//将该数据原先的值传给前台进行初始化
  		modelMap.addAttribute("queryData",JSONObject.fromObject(data,CommonUtils.getJsonConfig()));//将默认查询条件传给前台进行默认赋值
 		modelMap.addAttribute("act", act);//act用来说明时添加操作还是修改操作
 		modelMap.addAttribute("model", model);//按钮名
 		service.setModelMapVal(modelMap,user,data,1);//1表示编辑状态，下拉数据提供有权限的数据列表供用户编辑
 		return  "school/loadApplyInfo/addOrUpdate";	
 	}	

		 @RequestMapping("detail")
	public String update(ModelMap modelMap,HttpServletRequest request
		,String model,LoadApplyInfo queryModel) {
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);	
	 	modelMap.addAttribute("detail", service.detail(queryModel.getId(),user,queryModel));
		service.setModelMapVal(modelMap,user,queryModel,0);
		return "school/loadApplyInfo/detail";	
 		}

	 @RequestMapping("save")
 	@ResponseBody
	public Object save(@RequestBody LoadApplyInfo model,String act,String actName,ModelMap modelMap,HttpServletRequest request){
 	Map<String,Object> rs = new HashMap<String,Object>();//返回保存信息提示
 	LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
 	
	if(act.equals("update")){//act=update表示修改操作
			model.setUpdateTime(sdf1.format(new Date()));
			LoadApplyInfo preModel = mapper.selectByPrimaryKey(model.getId());
			rs =service.update(model);
	}
		//完成修改和添加操作
		return rs;
	}

	 
	 
	 
	 
	 
	 
}
