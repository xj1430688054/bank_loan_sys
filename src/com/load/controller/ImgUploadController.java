package com.load.controller;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.load.pojo.common.LoginModel;
import com.load.service.impl.common.Upload;
import com.load.util.CommonVal;
@Controller
@RequestMapping("/commonapi/imgUpload")
public class ImgUploadController  implements BaseModel{
	 @Autowired      
     private Upload upload;    
 		   //文件上传并生成缩略图  
 @RequestMapping(value="thumb",method=RequestMethod.POST)  
 @ResponseBody
public Object GenerateImage(@RequestParam("images")CommonsMultipartFile file,HttpServletRequest request) throws IOException{  
 Map<String,Object> result =new HashMap<String,Object>();
 String realUploadPath=CommonVal.imgRealPath;//获取上传文件的路径
    if(CommonVal.tomcatRealPath==null||CommonVal.tomcatRealPath.equals("")){//如果上传路径为空，则使用tomcat的静态资源路径做上传路径
			 realUploadPath = request.getSession().getServletContext().getRealPath("/")+"images";//使用tomcat文件路径作为上传路径
         		}
	//获取上传后原图的相对地址  
  String imageUrl=upload.uploadImage(file, realUploadPath);  
	result.put("code", 0);
	result.put("url", "http://"+imageUrl);
	return result;
	}

	
}
