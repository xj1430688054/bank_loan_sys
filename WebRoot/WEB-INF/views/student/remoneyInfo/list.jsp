<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<c:set var="uri" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var page=1;
var pageSize = '${pageSize}';
</script>
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

<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>${tableZhName}</title>
</head>
<body>
<div id="imgMaxModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius">
			<div class="modal-header">
				<h3 class="modal-title"></h3>
				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
			</div>
			<div class="modal-body" id="imgMaxContent">
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>
</div>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> ${tableZhName}<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c" id="queryFormDiv">
	<form id="queryForm">
	
	  <span id="queryBtnDiv">
    		
       </span>
	</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	 <span class="l" id="globalBtns">
	   				<a href="javascript:;" act="add" model="我要还款"  isComfirm="0" comfirmTip="确认要我要还款该数据吗？"  onclick="actionClick(this)" redirectUrl="bank_info"  class="btn btn-success radius">我要还款</a>

	  </span> 
	 </div>
		<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
		  <tr class="text-c">
 			 			<th>还款金额</th>
 			<th>学生</th>
 			<th>创建时间</th>

       		<th>操作</th>
		   </tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
	<div>
	  <span id="batchUpdateDiv">
	     
	  </span>
		<span style="margin-left:50px;margin-top:30px;"><font size="4">总共<font id="totalNum">0</font>条数据，共<font id="totalPage">0</font>页，当前第<font id="currentPage">1</font>页</font></span>
		<a href="javascript:;" style="margin-left:50px;" onclick="prePage()" class="btn btn-primary radius">上一页</a>
		<a href="javascript:;"  style="margin-left:50px;" onclick="nextPage()" class="btn btn-primary radius">下一页</a>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-form.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 

<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/utils/listutils.js?v=62536"></script>

<script type="text/javascript">
 $(function(){
	 
	 
	 ajaxList();
	 
 });
 function search(){
   page=1;
   ajaxList();
 }
	function ajaxList() {
		inPcaVal();
		var obj = getFormJson('queryForm');
		obj.page = page;
		var queryModel=JSON.parse('${data}');
		obj = Object.assign(queryModel,obj);
		$.ajax({
					type : 'get',
					url : "${pageContext.request.contextPath}/student/remoneyInfo/toList.do",
					data : obj,
					success : function(result) {
						var rows = result.data;//得到数据列
						var total = result.count;//得到数据总数
						$("#totalNum").html(total);//总数
						$("#totalPage").html(result.totalPage);//总页数
						$("#currentPage").html(page);//当前页码
						var html = '';
						for (var i = 0; i < rows.length; i++) {
							html += '<tr>' ;
											var  amount = rows[i].amount;
					html += '<td>' + setNullToEmpty(amount) + '</td>';
					var  userId = rows[i].userIdStr;
					html += '<td>' + setNullToEmpty(userId) + '</td>';
					var  createTime = rows[i].createTime;
					html += '<td>' + setNullToEmpty(createTime) + '</td>';

								html += '<td class="td-manage">';
					html +='</td>'+ '</tr>';

						}
						if (rows.length == 0) {
							html += '<tr><td></td><td></td><td>无数据</td><td></td></tr>';
						}
						$("#tbody").html(html);
						 
					}
				});
	}
	function actionClick(e){
		var comfirmTip=$(e).attr("comfirm-tip");
		var isComfirm=$(e).attr("is-comfirm");
		if (isComfirm == "1") {
			// 操作之前要弹出提示
			var r = confirm(comfirmTip);
			if (r == true) {
				comfirmAction(e);
			}
		} else {
			comfirmAction(e);
		}
	}
	
	function comfirmAction(e){
		var act = $(e).attr("act");
		var model = $(e).attr("model");
		var id = $(e).attr("data-id");
		var param={};
		var redirectUrl = $(e).attr("redirect-url");
		if (checkIsEmpty(model) == false) {//
			param.model = model;
		}
		if (checkIsEmpty(redirectUrl) == false) {
			param.redirectUrl = redirectUrl;
		}
		if (checkIsEmpty(act) == false) {
			param.act = act;
		}
		if (checkIsEmpty(id) == false) {
			param.id = id;
		}
		var queryModel=JSON.parse('${data}');
		param = Object.assign(queryModel,param);
		param= "1=1"+urlEncode(param);
		if(act=='add'||act=='update'||act=='detail'){
			var url = "${pageContext.request.contextPath}/student/remoneyInfo/"+act+".do?"+param;
				window.location.href=url;
		 }

	}
</script>
</body>
</html>
