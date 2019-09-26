function getUrls(domId){
	var urls =[];
	var uploadType = $(domId).attr("upload-type");
	var p  =$(domId).children();
	for(var i=0;i<p.length;i++){
		if(uploadType==1){//图片上传
			var children = $(p[i]).find("img").eq(1);
			var val = $(children[0]).attr("src");
			if(val!=undefined){
				if(val.endsWith(';')==true){
					val = val.substring(0,val.length-1);
				}
			}
			urls.push(val);	
		}else 	if(uploadType==2){//视频上传
			var val =$($(p[i]).children()[1].children[0].children[0]).attr("src");
			if(val!=undefined){
				if(val.endsWith(';')==true){
					val = val.substring(0,val.length-1);
				}
			}
			urls.push(val);	
		}else 	if(uploadType==3){//音频上传
			var val = $($(p[i]).children()[1].children[0]).attr("src");
			if(val!=undefined){
				if(val.endsWith(';')==true){
					val = val.substring(0,val.length-1);
				}
			}
			urls.push(val);	
		}else 	if(uploadType==4){//文件上传
			var val = $($(p[i]).children()[1].children[0]).attr("href")
			if(val!=undefined){
				if(val.endsWith(';')==true){
					val = val.substring(0,val.length-1);
				}
			}
			urls.push(val);	
		}

	}

	return urls;
}
//选择图片，马上预览
function xmTanUploadImg(obj) {
    var file = obj.files[0];
    var contentId = $(obj).attr('contentId');
    var formId = $(obj).attr('formId');
    var imgNum = $(obj).attr('imgNum');
    var uploadType=$(obj).attr("upload-type");
    var uploadName='';
    if(uploadType==1){
    	uploadName='图片';
    }else if(uploadType==2){
    	uploadName='视频';
    }else if(uploadType==3){
    	uploadName='音频';
    }else if(uploadType==4){
    	uploadName='文件';
    }
    
    if(file.size>100000000){
    	alert('上传'+uploadName+'大小不能大于1M','好的', function(){console.log('ok');});
    	return;
    }
    	 var urls = getUrls("#"+contentId);
    	 if(urls.length>=imgNum){
    		 alert('不能上传大于'+imgNum+'个'+uploadName,'好的', function(){console.log('ok');});
    	    	return;
    	 }
 
   
    var reader = new FileReader();

    //读取文件过程方法
    reader.onloadstart = function (e) {
        console.log("开始读取....");
    }
    reader.onprogress = function (e) {
        console.log("正在读取中....");
    }
    reader.onabort = function (e) {
        console.log("中断读取....");
    }
    reader.onerror = function (e) {
        console.log("读取异常....");
    }
    reader.onload = function (e) {
        console.log("成功读取....");
        
        var fileType=e.target.result.split(";")[0];
        if(uploadType==1){//图片
        	if(!(fileType.indexOf("png")
        			||fileType.indexOf("jpg")
        			||fileType.indexOf("jpeg")
        			||fileType.indexOf("JPEG")
        			||fileType.indexOf("JPG")
        			||fileType.indexOf("PNG"))){
        		alert('上传图片格式需为：png/jpg/jpeg格式','好的', function(){console.log('ok');});
      	    	return;
        	}
        }else if(uploadType==2){//视频格式
        	if(!(fileType.indexOf("avi")
        			||fileType.indexOf("mp4"))){
        		alert('上传视频格式需为：avi/mp4格式','好的', function(){console.log('ok');});
      	    	return;
        	}
        }else if(uploadType==3){//音频格式
        	if(!(fileType.indexOf("mp3"))){
        		alert('上传音频格式需为：mp3格式','好的', function(){console.log('ok');});
      	    	return;
        	}
        }
        $("#imgModal").html('');
        if(uploadType==1){
        	
        	var html = '<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
	+'<div class="modal-dialog">'
		+'<div class="modal-content radius">'
			+'<div class="modal-header">'
				+'<h3 class="modal-title">提示</h3>'
				+'<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>'
			+'</div>'
			+'<div class="modal-body">'
				+'<img src="'+e.target.result+'" height="500px;" width="100%">'
			+'</div>'
			+'<div class="modal-footer">'
				+'<button class="btn btn-primary" upload-type="'+uploadType+'" form-id="'+formId+'" content-id="'+contentId+'" onclick="uploadImg(this)">确定</button>'
				+'<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>'
			+'</div>'
		+'</div>'
	+'</div>'
	+'</div>';
          	$("#imgModal").html(html);
        }else if(uploadType==2){
        	var html = '<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
        		+'<div class="modal-dialog">'
        			+'<div class="modal-content radius">'
        				+'<div class="modal-header">'
        					+'<h3 class="modal-title">提示</h3>'
        					+'<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>'
        				+'</div>'
        				+'<div class="modal-body">';
        	        		html+='<video src="'+e.target.result+'"  height="500px;" width="100%" controls="controls">您的浏览器不支持 video 标签。</video>';
        				html+='</div>'
        				+'<div class="modal-footer">'
        					+'<button class="btn btn-primary" upload-type="'+uploadType+'" form-id="'+formId+'" content-id="'+contentId+'" onclick="uploadImg(this)">确定</button>'
        					+'<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>'
        				+'</div>'
        			+'</div>'
        		+'</div>'
        		+'</div>';
        			  	$("#imgModal").html(html);
        }else if(uploadType==3){
        	var html = '<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
        		+'<div class="modal-dialog">'
        			+'<div class="modal-content radius">'
        				+'<div class="modal-header">'
        					+'<h3 class="modal-title">提示</h3>'
        					+'<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>'
        				+'</div>'
        				+'<div class="modal-body">';
        	        		html+='<audio  src="'+e.target.result+'"  height="500px;" width="100%" controls="controls">您的浏览器不支持 audio  标签。</audio >';
        				html+='</div>'
        				+'<div class="modal-footer">'
        					+'<button class="btn btn-primary" upload-type="'+uploadType+'" form-id="'+formId+'" content-id="'+contentId+'" onclick="uploadImg(this)">确定</button>'
        					+'<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>'
        				+'</div>'
        			+'</div>'
        		+'</div>'
        		+'</div>';
        	$("#imgModal").html(html);
        }else{
         	var html = '<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
         		+'<div class="modal-dialog">'
         			+'<div class="modal-content radius">'
         				+'<div class="modal-header">'
         					+'<h3 class="modal-title">提示</h3>'
         					+'<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>'
         				+'</div>'
         				+'<div class="modal-body">'
         					+'<a href="#">确认上传该文件吗？</a>'
         				+'</div>'
         				+'<div class="modal-footer">'
         					+'<button class="btn btn-primary" upload-type="'+uploadType+'" form-id="'+formId+'" content-id="'+contentId+'" onclick="uploadImg(this)">确定</button>'
         					+'<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>'
         				+'</div>'
         			+'</div>'
         		+'</div>'
         		+'</div>';
         	          	$("#imgModal").html(html);
        	
        	
        }
        	
      
     $("#modal-demo").modal("show");
        	
    }
    reader.readAsDataURL(file);
  
}


function uploadImg(e){
	var formId = $(e).attr("form-id");
	var contentId = $(e).attr("content-id");
	var uploadType = $(e).attr("upload-type");
		$("#"+formId).ajaxSubmit({
		    success: function (data) {

		    	var html='<div>'
	    			+'<a href="javascript:void(0)" data-type="img" onclick="deleteImg(this)" style="position:relative;left:59%;top:20px;">'
	    			+'<img width="40px;" src="'+uri+'/static/fileupload/关 闭.png">'
	    			+'</a>'
	    			+'<div>';
	    			if(uploadType==1){//图片
	    				html+='<img width="60%" class="imgClass" src="'+data.url+'">'
	            		
	            	}else if(uploadType==2){//视频
	            		html+='<video width="60%" controls>'
			        	+'<source src="'+data.url+'" type="video/mp4">'
			        		+'您的浏览器不支持 video 标签。'
						+'</video>';	
	            	}else if(uploadType==3){//音频
	            		html+='<audio width="60%" src="'+data.url+'" controls>'
				        		+'您的浏览器不支持 video 标签。'
							+'</audio>';	
		            }else{//文件格式
		            	html+='<a href="'+data.url+'">点击下载</a>'
		            }
	    			
	    			
	    			html+='</div>'
	    			+'</div>';
		    	$("#"+contentId).append(html);
		    	 $("#modal-demo").modal("hide");
			}
		  });

}

function deleteImg(e){
	
	$(e).parent().remove();	


}

