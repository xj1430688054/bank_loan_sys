package com.load.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.load.dao.*;
import com.load.model.*;
import com.load.pojo.common.*;
import com.load.util.CommonVal;
import com.load.service.impl.*;
import com.load.utils.common.RandomCodeUtils;
import java.util.Date;
import java.text.SimpleDateFormat;
@Controller
@RequestMapping("/commonapi/regist")
public class RegistController  implements BaseModel{
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		@Autowired
	StudentInfoServiceImpl studentInfoService;
	@Autowired
	StudentInfoMapper studentInfoMapper;

	@RequestMapping(value = "student_info")
public String student_info(ModelMap modelMap, String msg) {
		modelMap.addAttribute("msg", msg);
		studentInfoService.setModelMapVal(modelMap,new LoginModel(),new StudentInfo(),0);
		return "student_info_regist";
 }
 @RequestMapping("student_info/toRegist")
 public String student_infoToRegist(Integer schoolId, String name,String password1,String password2,String imgCode,ModelMap modelMap,
HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(); 
		if (!imgCode.toLowerCase().equals(request.getSession().getAttribute(CommonVal.code).toString().toLowerCase())){ 
			modelMap.addAttribute("msg", "验证码错误");
			return "redirect:/commonapi/regist/student_info.do"; 
		}
		if(name==null||name.trim().equals("")){
			modelMap.addAttribute("msg","账号名不能为空！");
			return "redirect:/commonapi/regist/student_info.do"; 
		}
		if(password1==null||password1.trim().equals("")){
			modelMap.addAttribute("msg","密码不能为空！");
			return "redirect:/commonapi/regist/student_info.do"; 
		}
		if(password1.equals(password2)==false){
			modelMap.addAttribute("msg","两次密码不一致，请重试！");
			return "redirect:/commonapi/regist/student_info.do"; 
		}
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		StudentInfoExample.Criteria studentInfoCtiteria = studentInfoExample.createCriteria();
		studentInfoCtiteria.andNameEqualTo(name);
		int count = studentInfoMapper.countByExample(studentInfoExample);
		if(count>0){
			modelMap.addAttribute("msg","该用户名已存在，请使用其他用户名！");
			return "redirect:/commonapi/regist/student_info.do"; 
		}
		StudentInfo model = new StudentInfo();
		model.setSchoolId(schoolId);
		model.setName(name);
		model.setPassWord(password1);
	model.setIsBlack(2);
	model.setCreateTime(sdf1.format(new Date()));//默认赋值日期格式
	model.setUpdateTime(sdf1.format(new Date()));//默认赋值日期格式
	model.setIsDelete(0);
		studentInfoService.add(model);
		modelMap.addAttribute("msg","注册成功，请用该账号密码登录！");
		return "redirect:/commonapi/login.do";
	}

}
