package com.load.controller.school;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.load.pojo.common.LoginModel;
import com.load.controller.BaseModel;
import com.load.util.CommonVal;
import  com.load.model.*;
import com.load.dao.*;
@Controller
@RequestMapping("/school/index")
public class SIndexController  implements BaseModel{
			@Autowired
		SchoolInfoMapper schoolInfoMapper;

	 @RequestMapping(value="")  
		public String index(ModelMap modelMap,HttpServletRequest request
				){
		 LoginModel login = (LoginModel) request.getSession().getAttribute(sessionName);
		 		SchoolInfo user = schoolInfoMapper.selectByPrimaryKey(login.getId());
		 modelMap.addAttribute("user", user);
		 
		 modelMap.addAttribute("roleName", "学校管理员");
		 modelMap.addAttribute("login", login);
		 return "school/index";		
		}
}
