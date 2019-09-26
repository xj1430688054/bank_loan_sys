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

@Controller
@RequestMapping("/commonapi/login")
public class LoginController implements BaseModel {
	@Autowired
	BankInfoMapper bankInfoMapper;
	@Autowired
	SchoolInfoMapper schoolInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;

	@RequestMapping(value = "")
	public String login1(ModelMap modelMap, String msg) {
		modelMap.addAttribute("msg", msg);
		return "login";
	}

	@RequestMapping(value = "logout")
	public String adminlogout(HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(
				sessionName);
		request.getSession().removeAttribute(sessionName);
		return "redirect:/commonapi/login.do";
	}

	@RequestMapping("toLogin")
	public String login(LoginModel user, String imgCode, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (!imgCode.toLowerCase().equals(
				request.getSession().getAttribute(CommonVal.code).toString()
						.toLowerCase())) {
			modelMap.addAttribute("msg", "验证码错误");
			return "redirect:/commonapi/login.do";
		}
		if (user.getLoginType() == null) {
			modelMap.addAttribute("msg", "请选择登录角色");
			return "redirect:/commonapi/login.do";
		}
		LoginModel login = null;
		if (user.getLoginType() == 1) {
			BankInfoExample ue = new BankInfoExample();// 验证银行管理员账号密码
			BankInfoExample.Criteria uc = ue.createCriteria();
			uc.andIsDeleteEqualTo(0);//
			uc.andNameEqualTo(user.getName());
			uc.andPassWordEqualTo(user.getPassword());
			List<BankInfo> list = bankInfoMapper.selectByExample(ue);
			if (list.size() > 0) {
				login = new LoginModel();
				login.setId(list.get(0).getId());
				login.setLoginType(1);
				login.setName(list.get(0).getName());
				login.setPassword(list.get(0).getPassWord());
			}
		}
		if (user.getLoginType() == 2) {
			SchoolInfoExample ue = new SchoolInfoExample();// 验证学校管理员账号密码
			SchoolInfoExample.Criteria uc = ue.createCriteria();
			uc.andIsDeleteEqualTo(0);//
			uc.andNameEqualTo(user.getName());
			uc.andPassWordEqualTo(user.getPassword());
			List<SchoolInfo> list = schoolInfoMapper.selectByExample(ue);
			if (list.size() > 0) {
				login = new LoginModel();
				login.setId(list.get(0).getId());
				login.setLoginType(2);
				login.setName(list.get(0).getName());
				login.setPassword(list.get(0).getPassWord());
			}
		}
		if (user.getLoginType() == 3) {
			StudentInfoExample ue = new StudentInfoExample();// 验证学生账号密码
			StudentInfoExample.Criteria uc = ue.createCriteria();
			uc.andIsDeleteEqualTo(0);//
			uc.andNameEqualTo(user.getName());
			uc.andPassWordEqualTo(user.getPassword());
		
			List<StudentInfo> list = studentInfoMapper.selectByExample(ue);
			if (list.size() > 0) {
				if(list.get(0).getIsBlack()==1){
					modelMap.addAttribute("msg", "您因还贷过期已被拉入黑名单，请联系银行管理员进行处理");
					return "redirect:/commonapi/login.do";
				}
				
				login = new LoginModel();
				login.setId(list.get(0).getId());
				login.setLoginType(3);
				login.setName(list.get(0).getName());
				login.setPassword(list.get(0).getPassWord());
			}
		}

		if (login != null) {
			request.getSession().setAttribute(sessionName, login);// 设置登录session，保持会话
			modelMap.put("msg", "登录成功");
			modelMap.addAttribute("user", login);
			if (login.getLoginType() == 1) {
				return "redirect:/bank/index.do";
			}
			if (login.getLoginType() == 2) {
				return "redirect:/school/index.do";
			}
			if (login.getLoginType() == 3) {
				return "redirect:/student/index.do";
			}

		} else {
			modelMap.addAttribute("msg", "用户名或密码错误");
			return "redirect:/commonapi/login.do";
		}
		return "redirect:/commonapi/login.do";
	}
}
