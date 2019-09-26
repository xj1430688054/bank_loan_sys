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
	<span style="margin-left:20px;margin-top:20px;">
<span style="width:200px;margin-left:50px;">学生学号</span>
 <select name="stuId" id="stuId" style="height:30px;width:250px;">
<option value="">全部</option>
<c:forEach items="${stuIdList}" var="item2"> 
  <option value="${item2.id}">${item2.name}</option>
</c:forEach>
 </select>
<span style="width:200px;margin-left:50px;">真实姓名</span>
<input type="text" class="input-text" style="width:250px;" placeholder="请输入真实姓名" id="realName" name="realName">
</span>
<div style="margin-top:20px;"></div>
<span style="margin-left:20px;margin-top:20px;">
<span style="width:200px;margin-left:50px;">身份证号</span>
<input type="text" class="input-text" style="width:250px;" placeholder="请输入身份证号" id="idNumber" name="idNumber">
<span style="width:200px;margin-left:50px;">联系电话</span>
<input type="text" class="input-text" style="width:250px;" placeholder="请输入联系电话" id="celPhone" name="celPhone">
</span>

	  <span id="queryBtnDiv">
    					<button type="button" onclick="search();" style="margin-left:30px" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>

       </span>
	</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	 <span class="l" id="globalBtns">
	   	
	  </span> 
	 </div>
		<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
		  <tr class="text-c">
 			 			<th>学生学号</th>
 			<th>真实姓名</th>
 			<th>身份证号</th>
 			<th>联系电话</th>
 			<th>欲贷金额（元）</th>
 			<th>贷款原因</th>
 			<th>还款日期</th>
 			<th>还款金额</th>
 			<th>剩余金额</th>
 			<th>学校审核状态</th>
 			<th>学校审核备注</th>
 			<th>银行审核状态</th>
 			<th>银行审核备注</th>
 			<th>所属学校</th>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/selectSearch/jquery.searchableSelect.css?d=12939" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/selectSearch/jquery.searchableSelect.js?d=129393"></script>

<script type="text/javascript">
 $(function(){
	 
	 $('#stuId').searchableSelect();

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
					url : "${pageContext.request.contextPath}/school/loadApplyInfo/toList.do",
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
											var  stuId = rows[i].stuIdStr;
					html += '<td>' + setNullToEmpty(stuId) + '</td>';
					var  realName = rows[i].realName;
					html += '<td>' + setNullToEmpty(realName) + '</td>';
					var  idNumber = rows[i].idNumber;
					html += '<td>' + setNullToEmpty(idNumber) + '</td>';
					var  celPhone = rows[i].celPhone;
					html += '<td>' + setNullToEmpty(celPhone) + '</td>';
					var  moneyAmount = rows[i].moneyAmount;
					html += '<td>' + setNullToEmpty(moneyAmount) + '</td>';
					var  reason = rows[i].reason;
					html += '<td>' + setNullToEmpty(reason) + '</td>';
					var  redate = rows[i].redate;
					html += '<td>' + setNullToEmpty(redate) + '</td>';
					var  reamount = rows[i].reamount;
					html += '<td>' + setNullToEmpty(reamount) + '</td>';
					var  restAmount = rows[i].restAmount;
					html += '<td>' + setNullToEmpty(restAmount) + '</td>';
					var  schoolCheckStatus = rows[i].schoolCheckStatusStr;
					html += '<td>' + setNullToEmpty(schoolCheckStatus) + '</td>';
					var  schoolCheckRemark = rows[i].schoolCheckRemark;
					html += '<td>' + setNullToEmpty(schoolCheckRemark) + '</td>';
					var  bankCheckStatus = rows[i].bankCheckStatusStr;
					html += '<td>' + setNullToEmpty(bankCheckStatus) + '</td>';
					var  bankCheckRemark = rows[i].bankCheckRemark;
					html += '<td>' + setNullToEmpty(bankCheckRemark) + '</td>';
					var  scoolId = rows[i].scoolIdStr;
					html += '<td>' + setNullToEmpty(scoolId) + '</td>';
					var  createTime = rows[i].createTime;
					html += '<td>' + setNullToEmpty(createTime) + '</td>';

								html += '<td class="td-manage">';
		if(rows[i].schoolCheckStatus!='2' && rows[i].schoolCheckStatus!='3' && rows[i].bankCheckStatus!='2' && rows[i].bankCheckStatus!='3'){
								html +='<a href="javascript:;" act="update" model="审核"   onclick="actionClick(this)"   redirect-url="bankInfo" data-id="'+rows[i].id+'" is-comfirm="0" comfirm-tip="确认要审核该数据吗？"  class="btn btn-primary radius">审核</a>';

		}
					html +='<a href="javascript:;" act="detail" model="查看详情"   onclick="actionClick(this)"   redirect-url="bankInfo" data-id="'+rows[i].id+'" is-comfirm="0" comfirm-tip="确认要查看详情该数据吗？"  class="btn btn-success radius">查看详情</a>';
					html +='</td>'+ '</tr>';

						}
						if (rows.length == 0) {
							html += '<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
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
			var url = "${pageContext.request.contextPath}/school/loadApplyInfo/"+act+".do?"+param;
				window.location.href=url;
		 }

	}
</script>
</body>
</html>
