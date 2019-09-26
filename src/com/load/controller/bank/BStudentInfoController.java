package com.load.controller.bank;
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
@RequestMapping("/bank/studentInfo")
public class BStudentInfoController implements BaseModel{
 	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	StudentInfoServiceImpl service;
	@Autowired
	StudentInfoMapper mapper;
	
	/**
	 * 返回学生列表查询页面
	 */
	 @RequestMapping(value="")  
	 public String index(ModelMap modelMap,StudentInfo data,HttpServletRequest request){
	 LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		 modelMap.addAttribute("pageSize", pageSize);
		 modelMap.addAttribute("modelName","学生");
	 	modelMap.addAttribute("login",user);
		    modelMap.addAttribute("data",JSONObject.fromObject(data,CommonUtils.getJsonConfig()));
		service.setModelMapVal(modelMap,user,data,0);
			return "bank/studentInfo/list";		
		}
	 /**
	 * 根据查询条件分页查询学生数据，然后返回给前台渲染
	 */
	 @RequestMapping(value="toList")  
	 @ResponseBody
	 public Object toList(StudentInfo model,Integer page,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		
		int total = service.count(model,user);
		int totalPage = total/pageSize;
		rs.put("data", service.getList(model, page, pageSize,user));
		rs.put("count", total);
		rs.put("totalPage", (totalPage+1));
		return rs;
	}
	 
	  
	
	
	
	
	  @RequestMapping("delete")
	@ResponseBody
	public Object delete(Integer id,String act,ModelMap modelMap,HttpServletRequest request) {
 		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
 		StudentInfo preModel = mapper.selectByPrimaryKey(id);
  	Map<String,Object> rs = new HashMap<String,Object>();
		int count = service.delete(id,user );
		if(count>0){
			rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
		}else{
			rs.put("code", 0);
			rs.put("msg", "系统异常");
			return rs;
		}
	}

	 
	 
	 
	 
	 
}
