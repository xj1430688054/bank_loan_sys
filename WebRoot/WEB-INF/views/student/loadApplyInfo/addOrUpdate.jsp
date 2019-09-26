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
<c:set var="uri" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var uri='${uri}';
</script>
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>${btn.windowTitle}</title>
</head>
<body>
<div><a href="javascript:void(0)" onclick="javascript:history.back(-1);" style="margin-left:50px;margin-top:50px;" class="btn btn-success radius">《《返回</a></div>
<div id="imgModal"></div>
<form id="addFrom">
<div class="page-container">
		 <c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="realNameParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">真实姓名
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text" value="${data.realName}" placeholder="请输入真实姓名" id="realName" name="realName">
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="idNumberParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">身份证号
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text" value="${data.idNumber}" placeholder="请输入身份证号" id="idNumber" name="idNumber">
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl" id="idnumberImg1ParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">身份证正面
</label>
<div class="formControls col-xs-8 col-sm-9">
<a href="javascript:void(0);" onclick="$('#idnumberImg1File').click()">
<img  src="${pageContext.request.contextPath}/static/fileupload/加 (1).png" height="50px;">
<font style="font-size:10px;color:gray">请上传身份证正面（数量不超过：1）</font>
</a>
<div id="idnumberImg1Content" data-id="idnumberImg1" upload-type="1" class="imgContentDiv">
 <c:if test="${data.idnumberImg1!=null and data.idnumberImg1!=''}">
  <c:set value="${fn:split(data.idnumberImg1, ';') }" var="tmpStr" />
 <c:forEach items="${tmpStr}" var="s">
 <div>
 <a href="javascript:void(0)" data-type="img" onclick="deleteImg(this)" style="position:relative;left:59%;top:20px;">
 <img width="40px;" src="${pageContext.request.contextPath}/static/fileupload/关 闭.png">
</a>
<div>
<img width="60%" class="imgClass" src="${s}">
</div>
</div>
</c:forEach>
</c:if>
</div>
</div>
<input type="hidden" id="idnumberImg1" name="idnumberImg1" value="${data.idnumberImg1}">
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl" id="idnumberImg2ParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">身份证反面
</label>
<div class="formControls col-xs-8 col-sm-9">
<a href="javascript:void(0);" onclick="$('#idnumberImg2File').click()">
<img  src="${pageContext.request.contextPath}/static/fileupload/加 (1).png" height="50px;">
<font style="font-size:10px;color:gray">请上传身份证反面（数量不超过：1）</font>
</a>
<div id="idnumberImg2Content" data-id="idnumberImg2" upload-type="1" class="imgContentDiv">
 <c:if test="${data.idnumberImg2!=null and data.idnumberImg2!=''}">
  <c:set value="${fn:split(data.idnumberImg2, ';') }" var="tmpStr" />
 <c:forEach items="${tmpStr}" var="s">
 <div>
 <a href="javascript:void(0)" data-type="img" onclick="deleteImg(this)" style="position:relative;left:59%;top:20px;">
 <img width="40px;" src="${pageContext.request.contextPath}/static/fileupload/关 闭.png">
</a>
<div>
<img width="60%" class="imgClass" src="${s}">
</div>
</div>
</c:forEach>
</c:if>
</div>
</div>
<input type="hidden" id="idnumberImg2" name="idnumberImg2" value="${data.idnumberImg2}">
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="celPhoneParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">联系电话
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text" value="${data.celPhone}" placeholder="请输入联系电话" id="celPhone" name="celPhone">
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="emailParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">邮箱
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text" value="${data.email}" placeholder="请输入邮箱" id="email" name="email">
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl" id="pcaParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">现所在区域
</label>
<div class="formControls col-xs-8 col-sm-9">
<div data-id="pca" class="pcaDiv" val="${data.pca}"></div>
</div>
</div>
<input type="hidden" name="pca" value="">
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="addressParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">现居地址
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text" value="${data.address}" placeholder="请输入现居地址" id="address" name="address">
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="moneyAmountParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">欲贷金额（元）
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text" value="${data.moneyAmount}" placeholder="请输入欲贷金额（元）（请填入整数）" id="moneyAmount" name="moneyAmount">
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl"  id="reasonParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">贷款原因
</label>
<div class="formControls col-xs-8 col-sm-9">
<textarea  cols="" rows="" class="textarea"placeholder="请输入贷款原因"dragonfly="true" nullmsg=""id="reason" name="reason">${data.reason}</textarea>
</div>
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl" id="proveFileParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">相关证明
</label>
<div class="formControls col-xs-8 col-sm-9">
<a href="javascript:void(0);" onclick="$('#proveFileFile').click()">
<img  src="${pageContext.request.contextPath}/static/fileupload/加 (1).png" height="50px;">
<font style="font-size:10px;color:gray">请上传相关证明（数量不超过：1）</font>
</a>
<div id="proveFileContent" data-id="proveFile" upload-type="4" class="imgContentDiv">
 <c:if test="${data.proveFile!=null and data.proveFile!=''}">
  <c:set value="${fn:split(data.proveFile, ';') }" var="tmpStr" />
 <c:forEach items="${tmpStr}" var="s">
 <div>
 <a href="javascript:void(0)" data-type="img" onclick="deleteImg(this)" style="position:relative;left:59%;top:20px;">
 <img width="40px;" src="${pageContext.request.contextPath}/static/fileupload/关 闭.png">
</a>
<div>
<a href="${s}">点击下载</a>
</div>
</div>
</c:forEach>
</c:if>
</div>
</div>
<input type="hidden" id="proveFile" name="proveFile" value="${data.proveFile}">
</div>
</c:if>
<c:if test="${model=='申请贷款' or model=='修改贷款信息'}">
 <div class="row cl" id="redateParentDiv" style="margin-top:20px;margin-left:20px;" > 	<label class="form-label col-xs-4 col-sm-2">还款日期
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text Wdate" value="${data.redate}"   onFocus="WdatePicker({startDate: '%y-%M-%d' })" placeholder="请输入还款日期" id="redate" name="redate">
</div>
</div>
</c:if>

</div>
</form>
<hr>
<form id="idnumberImg1Form"  action="${pageContext.request.contextPath}/commonapi/imgUpload/thumb.do"  method="post" enctype="multipart/form-data">
<div style="display:none">
 <input imgNum="1" upload-type="1"  type="file" formId="idnumberImg1Form" contentId="idnumberImg1Content"  onchange="xmTanUploadImg(this)"  name="images" id="idnumberImg1File" >
 </div> 
 </form>
<form id="idnumberImg2Form"  action="${pageContext.request.contextPath}/commonapi/imgUpload/thumb.do"  method="post" enctype="multipart/form-data">
<div style="display:none">
 <input imgNum="1" upload-type="1"  type="file" formId="idnumberImg2Form" contentId="idnumberImg2Content"  onchange="xmTanUploadImg(this)"  name="images" id="idnumberImg2File" >
 </div> 
 </form>
<form id="proveFileForm"  action="${pageContext.request.contextPath}/commonapi/imgUpload/thumb.do"  method="post" enctype="multipart/form-data">
<div style="display:none">
 <input imgNum="1" upload-type="4"  type="file" formId="proveFileForm" contentId="proveFileContent"  onchange="xmTanUploadImg(this)"  name="images" id="proveFileFile" >
 </div> 
 </form>

<div class="page-container">
		<div class="row cl" style="margin-top:20px;">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="submitData();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
			</div>
		</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/fileupload/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/My97DatePicker/4.8/WdatePicker.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/pca/provincesData.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/pca/jquery.provincesCity.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/fileupload/fileupload.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/utils/listutils.js?v=26573"></script>

<script type="text/javascript">

$(function(){
	initDom();//初始化组件
	
})
function initDom(){

  //省市区组件初始化
var pcaDiv = $(".pcaDiv");
for(var i=0;i<pcaDiv.length;i++){
		var dataId = $(pcaDiv[i]).attr("data-id");
		var val = $(pcaDiv[i]).attr("val");
		$(pcaDiv[i]).ProvinceCity(dataId+"Province",dataId+"City1",dataId+"City2");
		if(checkIsEmpty(val)==false){
			var tmp = val.split(" ");
			if(tmp.length>=1){
				$("#"+dataId+"Province").val(tmp[0].trim());
				$("#"+dataId+"Province").change();
			}
			if(tmp.length>=2){
				$("#"+dataId+"City1").val(tmp[1].trim());
				$("#"+dataId+"City1").change();
			}
			if(tmp.length>=3){
				$("#"+dataId+"City2").val(tmp[2].trim());
			}
		}
	}

	


}

function submitData(){
	var param ={};

	var pcaDiv = $(".pcaDiv");
	//省市区值搜集
	for(var i=0;i<pcaDiv.length;i++){
		var dataId = $(pcaDiv[i]).attr("data-id");
		var val="";
		var provinceName= $("#"+dataId+"Province").val();
		var cityName1= $("#"+dataId+"City1").val();
		var cityName2= $("#"+dataId+"City2").val();
		if(provinceName!=''&&provinceName!='请选择'){
			val+=provinceName;
			if(cityName1!=''&&cityName1!='请选择'){
				val+=" "+cityName1;
				if(cityName2!=''&&cityName2!='请选择'){
					val+=" "+cityName2;
				}
			}
		}
		if(val!=''){
			param[dataId]=val;
		}
	}

var realName = $("#realName").val();
param.realName=(realName==undefined?'':realName);
var idNumber = $("#idNumber").val();
param.idNumber=(idNumber==undefined?'':idNumber);
var idnumberImg1 =getImgUrlStr("#idnumberImg1Content")
param.idnumberImg1=(idnumberImg1==undefined?'':idnumberImg1);
var idnumberImg2 =getImgUrlStr("#idnumberImg2Content")
param.idnumberImg2=(idnumberImg2==undefined?'':idnumberImg2);
var celPhone = $("#celPhone").val();
param.celPhone=(celPhone==undefined?'':celPhone);
var email = $("#email").val();
param.email=(email==undefined?'':email);
var address = $("#address").val();
param.address=(address==undefined?'':address);
var moneyAmount = $("#moneyAmount").val();
param.moneyAmount=(moneyAmount==undefined?'':moneyAmount);
var reason = $("#reason").val();
param.reason=(reason==undefined?'':reason);
var proveFile =getImgUrlStr("#proveFileContent")
param.proveFile=(proveFile==undefined?'':proveFile);
var redate = $("#redate").val();
param.redate=(redate==undefined?'':redate);

	//提交请求
	var id = '${data.id}';
	var act = '${act}';
	var actName = '${model}';
	var hrefParam="1=1";
	if(checkIsEmpty(id)==false){
		param.id=id;
	}
	if(checkIsEmpty(act)==false){
		hrefParam+="&act="+act;
	}
	if(checkIsEmpty(actName)==false){
		hrefParam+="&actName="+actName;
	}
	if(act=='add'){
		var queryModel=JSON.parse('${queryData}');
		param = Object.assign(queryModel,param);
	}
	if(param.moneyAmount!=''){
if(isIntNum(param.moneyAmount)==false){
alert("欲贷金额（元）必须填入整数");
return;
}
}

	$.ajax({
	    type: 'post',
	    contentType : "application/json" ,
	    dataType : "json",
	    url: '${pageContext.request.contextPath}/student/loadApplyInfo/save.do?'+hrefParam,
	    data:JSON.stringify(param),
	    success: function(result) {
	    	if(result.code == 0){
	    		alert(result.msg);
			}else{
				alert(result.msg);
				self.location=document.referrer;
			}
	    }
	}); 
}
</script>
</body>
</html>
