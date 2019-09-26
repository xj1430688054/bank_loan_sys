<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>详情页</title>
</head>
<body>
<div style="margin-top:50px;margin-left:50px;"><a href="javascript:void(0)" onclick="javascript:history.back(-1);"  class="btn btn-success radius">《《返回</a></div>
<div class="page-container">
	<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">详情页</th>
			</tr>
		</thead>
		<tbody>
		     <tr>
<th width="30%">学生学号</th>
<th width="30%">${detail.stuIdStr}</th>
</tr>
<tr>
<th width="30%">真实姓名</th>
<th width="30%">${detail.realName}</th>
</tr>
<tr>
<th width="30%">身份证号</th>
<th width="30%">${detail.idNumber}</th>
</tr>
<tr>
<th width="30%">身份证正面</th>
<th width="30%"><img src="${detail.idnumberImg1}" style="width:90%" /></th>
</tr>
<tr>
<th width="30%">身份证反面</th>
<th width="30%"><img src="${detail.idnumberImg2}" style="width:90%" /></th>
</tr>
<tr>
<th width="30%">联系电话</th>
<th width="30%">${detail.celPhone}</th>
</tr>
<tr>
<th width="30%">邮箱</th>
<th width="30%">${detail.email}</th>
</tr>
<tr>
<th width="30%">现所在区域</th>
<th width="30%">${detail.pca}</th>
</tr>
<tr>
<th width="30%">现居地址</th>
<th width="30%">${detail.address}</th>
</tr>
<tr>
<th width="30%">欲贷金额（元）</th>
<th width="30%">${detail.moneyAmount}</th>
</tr>
<tr>
<th width="30%">贷款原因</th>
<th width="30%">${detail.reason}</th>
</tr>
<tr>
<th width="30%">相关证明</th>
<th width="30%"><a href="${detail.proveFile}">点击下载</a></th>
</tr>
<tr>
<th width="30%">还款日期</th>
<th width="30%">${detail.redate}</th>
</tr>
<tr>
<th width="30%">还款金额</th>
<th width="30%">${detail.reamount}</th>
</tr>
<tr>
<th width="30%">剩余金额</th>
<th width="30%">${detail.restAmount}</th>
</tr>
<tr>
<th width="30%">学校审核状态</th>
<th width="30%">${detail.schoolCheckStatusStr}</th>
</tr>
<tr>
<th width="30%">学校审核备注</th>
<th width="30%">${detail.schoolCheckRemark}</th>
</tr>
<tr>
<th width="30%">银行审核状态</th>
<th width="30%">${detail.bankCheckStatusStr}</th>
</tr>
<tr>
<th width="30%">银行审核备注</th>
<th width="30%">${detail.bankCheckRemark}</th>
</tr>
<tr>
<th width="30%">所属学校</th>
<th width="30%">${detail.scoolIdStr}</th>
</tr>
<tr>
<th width="30%">创建时间</th>
<th width="30%">${detail.createTime}</th>
</tr>
<tr>
<th width="30%">更新时间</th>
<th width="30%">${detail.updateTime}</th>
</tr>

		</tbody>
	</table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script> 

<script type="text/javascript">
 
 </script>
</body>
</html>
