package com.load.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.load.pojo.common.LoginModel;
import com.load.util.CommonVal;
public class LoginInterceptor  implements HandlerInterceptor,BaseModel{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginModel admin = (LoginModel) request.getSession().getAttribute(sessionName);
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        if (admin == null) {
        	if(requestUri.contains("toLogin")){//正在请求登录
        		return true;
        	}
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect(contextPath+"/commonapi/login.do");	
            return false;
        }else{
        		if(admin.getLoginType()==1){
	if(requestUri.contains("bank")==false &&requestUri.contains("commonapi")==false){
response.sendRedirect(contextPath+"/commonapi/login.do");
return true;
}
}
	if(admin.getLoginType()==2){
	if(requestUri.contains("school")==false &&requestUri.contains("commonapi")==false){
response.sendRedirect(contextPath+"/commonapi/login.do");
return true;
}
}
	if(admin.getLoginType()==3){
	if(requestUri.contains("student")==false &&requestUri.contains("commonapi")==false){
response.sendRedirect(contextPath+"/commonapi/login.do");
return true;
}
}

        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
