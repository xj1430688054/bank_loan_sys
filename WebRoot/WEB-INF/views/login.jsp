<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>登录</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/login2/img/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login2/layui/css/layui.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login2/css/login.css">
	</head>
	<body>
		<div class="layui-carousel video_mask" id="login_carousel">
			<div carousel-item>
				<div class="carousel_div1"></div>
				<div class="carousel_div2"></div>
				<div class="carousel_div3"></div>
			</div>
			<div class="login layui-anim layui-anim-up">
				<div class="layui-logo">
					<p style="color:red">${msg}</p>
				</div>
				<fieldset class="layui-elem-field layui-field-title">
					<legend class="text-white">银行助学贷款管理系统</legend>
				</fieldset>
				<form class="layui-form"  action="${pageContext.request.contextPath}/commonapi/login/toLogin.do" method="post">
					<div class="layui-form-item">
						<input type="text" id="username"  name="name"   maxlength="20" placeholder="请输入登录名" autocomplete="off" autofocus="autofocus" class="layui-input">
					</div>
					<div class="layui-form-item">
						<input type="password" id="password" name="password"  maxlength="20" placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-item form_code">
						<input type="text" name="imgCode"  maxlength="6" placeholder="请输入验证码" autocomplete="off" class="layui-input">
						<div class="code"><img name="codeImg" id="codeImg1" width="118" height="38"></div>
					</div>
					  <div class="layui-form-item form_code"><div><input type="radio" name="loginType" value="1" title="银行管理员"> 
<input type="radio" name="loginType" value="2" title="学校管理员"> 
<input type="radio" name="loginType" value="3" title="学生"> 
</div></div>
					<button class="login_btn layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="login">登录</button>
					 <strong class="text-white"> <a href="${pageContext.request.contextPath}/commonapi/regist/student_info.do" style="color: cornflowerblue;">注册学生&raquo;</a></strong>

				</form>
				<hr class="layui-bg-gray">
				<div class="layui-footer text-white">
					<!-- 底部固定区域 -->
					&copy;2014-2020 银行助学贷款管理系统
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/login2/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/login2/layui/layui.all.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/login2/js/login.js"></script>
	</body>
	<script type="text/javascript">
$(document).ready(function(e) {
	changeCode();
	$("#codeImg1").bind("click",changeCode);
});
function genTimestamp(){
	var time = new Date();
	return time.getTime();
}
function changeCode(){
	$("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/commonapi/code.do?t="+genTimestamp());
}
</script>
</html>
