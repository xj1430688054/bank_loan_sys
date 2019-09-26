<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>注册</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/login2/img/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login2/layui/css/layui.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login2/css/register.css">
	</head>
	<body style="background-image: url(${pageContext.request.contextPath}/static/login2/img/login-bg2.jpg);">
		<div class="layui-main user">
			<div class="layui-clear main">
				<div class="layui-logo">
					<p style="color:red">${msg}</p>
				</div>
				<fieldset class="layui-elem-field layui-field-title">
					<legend class="text-white">注册</legend>
				</fieldset>
				<div class="layui-form layui-form-pane">
					<form class="layui-form"  action="${pageContext.request.contextPath}/commonapi/regist/student_info/toRegist.do.do" method="post">
						<div class="layui-form-item">
							<input class="layui-input" id="username" name="name" placeholder="请输入登录名" type="text" autofocus="autofocus" autocomplete="off">
						</div>
						<div class="layui-form-item">
							<input class="layui-input" id="password1" name="password1" placeholder="请输入密码" type="password"   autocomplete="off">
						</div>
						<div class="layui-form-item">
							<input class="layui-input" placeholder="请再次输入密码" type="password" id="password2" name="password2"   autocomplete="off">
						</div>
						<div class="layui-form-item form_code">
							<input id="imgCode" name="imgCode" class="layui-input" placeholder="请输入图片验证码" type="text" maxlength="6" >
							<div class="code"><img id="codeImg1"  name="codeImg" width="120" height="38"></div>
						</div>
									 <div class="layui-form-item form_code">
 <label   class="layui-form-label">所属学校</label>
 <div class="layui-input-block">
		<select class="select" name="schoolId">
		<c:forEach items="${schoolIdList}" var="opt">
			<option value="${opt.id}">${opt.name}</option>
		</c:forEach>
	</div>
</div>

						<div class="layui-form-item" style="float: left;margin-left: -10px;">
							<input lay-filter="agreen-checkbox" title="我同意" type="checkbox" lay-skin="primary" checked>
							<a href="#" target="_blank">《注册协议》</a>
						</div>
						<div class="layui-form-item">
							<button id="reg" type="submit" class="login_btn layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="register">立即注册</button>
						</div>
						<div>
							<small class="text-white">已经有账户了？</small>
							<a href="${pageContext.request.contextPath}/commonapi/login.do">点此登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/login2/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/login2/layui/layui.all.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/login2/js/register.js?t=22"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/pca/provincesData.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/pca/jquery.provincesCity.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/fileupload/fileupload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/wangEditor-3.0.3/release/wangEditor.min.js"></script>
	<script>
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
