package com.load.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.load.dao.*;
import com.load.model.*;
import com.load.pojo.common.*;
import com.load.util.CommonVal;
@Controller
@RequestMapping("/commonapi/alterPassword")
public class AlterPasswordController implements BaseModel {
		@Autowired
		BankInfoMapper bankInfoMapper;
		@Autowired
		SchoolInfoMapper schoolInfoMapper;
		@Autowired
		StudentInfoMapper studentInfoMapper;

	@RequestMapping("")
	public Object alterPassword( ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		 LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		 if(user==null){
			 return"redirect:/commonapi/login.do";	
		 }
		return "alter_password";
	}
	@RequestMapping("submit")
	@ResponseBody
	public Object submit( ModelMap modelMap,String password1,String password2,
			String password3,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		 LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		 if(password1==null||password2==null||password3==null){
			 rs.put("rs", 0);
			 rs.put("msg", "系统异常");
			 return rs;
		 }
		 if(password2.equals(password3)==false){
			 rs.put("rs", 0);
			 rs.put("msg", "两次密码输入不一致");
			 return rs;
		 }
		 	if(user.getLoginType()==1){
	    BankInfo l  =bankInfoMapper.selectByPrimaryKey(user.getId()); 
	    if(l.getPassWord().equals(password1)==false){//检查该账号原有密码   
	    		rs.put("code",0);  
	    		rs.put("msg","旧密码输入错误");  
	    		return rs;  
	    } 
	    l.setPassWord(password2);//设置为新密码 
	    bankInfoMapper.updateByPrimaryKeySelective(l); 
	} 
	if(user.getLoginType()==2){
	    SchoolInfo l  =schoolInfoMapper.selectByPrimaryKey(user.getId()); 
	    if(l.getPassWord().equals(password1)==false){//检查该账号原有密码   
	    		rs.put("code",0);  
	    		rs.put("msg","旧密码输入错误");  
	    		return rs;  
	    } 
	    l.setPassWord(password2);//设置为新密码 
	    schoolInfoMapper.updateByPrimaryKeySelective(l); 
	} 
	if(user.getLoginType()==3){
	    StudentInfo l  =studentInfoMapper.selectByPrimaryKey(user.getId()); 
	    if(l.getPassWord().equals(password1)==false){//检查该账号原有密码   
	    		rs.put("code",0);  
	    		rs.put("msg","旧密码输入错误");  
	    		return rs;  
	    } 
	    l.setPassWord(password2);//设置为新密码 
	    studentInfoMapper.updateByPrimaryKeySelective(l); 
	} 

		 rs.put("rs", 1);
		 rs.put("msg", "密码修改成功，会在下次登录生效");
		 return rs;
	}
}
