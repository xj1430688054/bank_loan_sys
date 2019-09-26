function setNullToEmpty(val){//将所有空数据都转为'-'
		if(val===null||val==='null'||val===''||val==undefined||val=='undefined'){
		return '-';
		}
		return val;
	}

function isIntNum(s){//是否为正整数
	var re = /^[0-9]*[1-9][0-9]*$/ ;
	return re.test(s)
}
function isNum(val){
	if(isNaN(val)==true){
		return false;
	}else{
		return true;
	}
}
  function getFormJson(formId){//将form表单转成js对象
 		var obj = $("#"+formId).serializeArray();
		    var postData = {};  //创建一个对象  
		$.each(obj, function(n,v) {      
		      postData[obj[n].name]=obj[n].value;  //循环数组，把数组的每一项都添加到对象中  
		});  
		return  postData;
 }
var urlEncode = function (param, key, encode) {//将js对象转成参数
		  if(param==null) return '';  
		  var paramStr = '';  
		  var t = typeof (param);  
		  if (t == 'string' || t == 'number' || t == 'boolean') {  
		    paramStr += '&' + key + '=' + ((encode==null||encode) ? encodeURIComponent(param) : param);  
		  } else {  
		    for (var i in param) {  
		      var k = key == null ? i : key + (param instanceof Array ? '[' + i + ']' : '.' + i);  
		      paramStr += urlEncode(param[i], k, encode);  
		    }  
		  }  
		  return paramStr;  
		};

function initPca(){
		//省市区组件初始化
		var pcaDiv = $(".pcaDiv");
		for(var i=0;i<pcaDiv.length;i++){
			var dataId = $(pcaDiv[i]).attr("data-id");
			var val = $(pcaDiv[i]).attr("val");
			$(pcaDiv[i]).ProvinceCity(dataId+"Province",dataId+"City1",dataId+"City2");
		} 
 }
 

	function getImgShowStr(val,type){
		if(val==null){
			return '-';
		}
		if(type==1){//文本格式
			return val;
		}else{
			var imgs = val.split(";");
			val = '';
			for (var p = 0; p < imgs.length; p++) {
				if (imgs[p] != '') {
					val += ' <p><img src="'
							+ imgs[p]
							+ '" onclick="maxImg(this)" style="width:80px;"/></p>';
				}
			}
			return val;
		}
		
	}
	
	function getVedioShowStr(val,type){
		if(val==null){
			return '-';
		}
		if(type==1){//文本格式
			return val;
		}else{
			var imgs = val.split(";");
			val = '';
			for (var p = 0; p < imgs.length; p++) {
				if (imgs[p] != '') {
					val+='<p><video src="'+imgs[p]+'"  style="width:80px;" controls="controls">您的浏览器不支持 video 标签。</video></p>';
				}
			}
			return val;
		}	
	}
	
	
	function getAudioShowStr(val,type){
		if(val==null){
			return '-';
		}
		if(type==1){//文本格式
			return val;
		}else{
			var imgs = val.split(";");
			val = '';
			for (var p = 0; p < imgs.length; p++) {
				if (imgs[p] != '') {
					val+='<p><audio src="'+imgs[p]+'"  style="width:80px;" controls="controls">您的浏览器不支持 audio 标签。</audio></p>';
				}
			}
			return val;
		}	
	}
	
	function getFileStr(val,type){
		if(val==null){
			return '-';
		}
		if(type==1){//文本格式
			return val;
		}else{
			var imgs = val.split(";");
			val = '';
			for (var p = 0; p < imgs.length; p++) {
				if (imgs[p] != '') {
					val += ' <p><a href="'+imgs[p]+'">点击下载</a></p>';
				}
			}
			return val;
		}
		
	}
	
	
	function maxQrcode(e){
		var content = $(e).attr("data-content");
		$("#imgMaxContent").html('<div style="width:100%" id="maxQrcodeDiv"></div>');
		
		new QRCode('maxQrcodeDiv', {
		   	  text: content,
		   	  width: 300,
		   	  height: 300,
		   	  colorDark : '#000000',
		   	  colorLight : '#ffffff',
		   	  correctLevel : QRCode.CorrectLevel.H
		   	});
		$("#imgMaxModal").modal('show');
	}
	
	function maxImg(e){
		var url = $(e).attr("src");
		$("#imgMaxContent").html('<img style="width:100%"  src="'+url+'"/>');
		$("#imgMaxModal").modal('show');
	}

function inPcaVal(){
	 
	 	var pcaDiv = $(".pcaDiv");
		for(var i=0;i<pcaDiv.length;i++){
			var qname = $(pcaDiv[i]).attr("data-id");
			var val="";
			var provinceName= $("#"+qname+"Province").val();
			var cityName1= $("#"+qname+"City1").val();
			var cityName2= $("#"+qname+"City2").val();
			if(provinceName!=''&&provinceName!='请选择'){
				val+=provinceName;
				if(cityName1!=''&&cityName1!='请选择'){
					val+=" "+cityName1;
					if(cityName2!=''&&cityName2!='请选择'){
						val+=" "+cityName2;
					}
				}
			}
			$("#"+qname+"PcaDivVal").val(val);
		}
		
	}


function checkIsEmpty(data){
		if(data==undefined||data=='undefined'||data==''||data==null||data=='null'){
			return true;
		}else{
			return false;
		}
	}

function getImgUrlStr(domId){
	var urls = getUrls(domId);
	var urlstr='';
	for(var i=0;i<urls.length;i++){
		urlstr+=urls[i]+';';
		
	}
	if(urlstr.endsWith(';')==true){
		urlstr = urlstr.substring(0,urlstr.length-1);
	}
	return urlstr;
}

function prePage() {
		if (page <= 1) {
			alert("没有上一页了");
			return;
		}
		page = page - 1;
		ajaxList();

	}
	function nextPage() {
		debugger;
		var totalPage = $("#totalPage").html();
		if (new Number(totalPage) <= new Number(page)) {
			alert("没有下一页了");
			return;
		}
		page = page + 1;
		ajaxList();

	}