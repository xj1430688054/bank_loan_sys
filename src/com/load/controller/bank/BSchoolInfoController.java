package com.load.controller.bank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.load.service.impl.common.DataListUtils;
import com.load.controller.BaseModel;
import com.load.dao.*;
import com.load.model.*;
import com.load.service.impl.*;
import com.load.util.*;
import java.text.SimpleDateFormat;
import com.load.pojo.common.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.load.utils.common.RandomCodeUtils;
import java.util.ArrayList;
import com.load.utils.common.CommonUtils;
@Controller
@RequestMapping("/bank/schoolInfo")
public class BSchoolInfoController implements BaseModel{
 	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	SchoolInfoServiceImpl service;
	@Autowired
	SchoolInfoMapper mapper;
	
	/**
	 * 返回学校管理员列表查询页面
	 */
	 @RequestMapping(value="")  
	 public String index(ModelMap modelMap,SchoolInfo data,HttpServletRequest request){
	 LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		 modelMap.addAttribute("pageSize", pageSize);
		 modelMap.addAttribute("modelName","学校管理员");
	 	modelMap.addAttribute("login",user);
		    modelMap.addAttribute("data",JSONObject.fromObject(data,CommonUtils.getJsonConfig()));
		service.setModelMapVal(modelMap,user,data,0);
			return "bank/schoolInfo/list";		
		}
	 /**
	 * 根据查询条件分页查询学校管理员数据，然后返回给前台渲染
	 */
	 @RequestMapping(value="toList")  
	 @ResponseBody
	 public Object toList(SchoolInfo model,Integer page,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
		
		int total = service.count(model,user);
		int totalPage = total/pageSize;
		rs.put("data", service.getList(model, page, pageSize,user));
		rs.put("count", total);
		rs.put("totalPage", (totalPage+1));
		return rs;
	}
	 
	  
	 @RequestMapping("add")
	public String toAdd(ModelMap modelMap,HttpServletRequest request
	,String act,String model,SchoolInfo data) {
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);	
  		modelMap.addAttribute("queryData",JSONObject.fromObject(data,CommonUtils.getJsonConfig()));//将默认查询条件传给前台进行默认赋值
  		modelMap.addAttribute("data",data);//数值为空的对象给前台
 		modelMap.addAttribute("act", act);//act用来说明时添加操作还是修改操作
 		modelMap.addAttribute("model", model);//按钮名
 		service.setModelMapVal(modelMap,user,data,1);//1表示编辑状态，下拉数据提供有权限的数据列表供用户编辑
 		return  "bank/schoolInfo/addOrUpdate";	
 	}	

	 @RequestMapping("update")
	public String update(ModelMap modelMap,HttpServletRequest request
	,String act,String model,SchoolInfo data) {
		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);	
  		modelMap.addAttribute("data", service.getById(data.getId(),user));//将该数据原先的值传给前台进行初始化
  		modelMap.addAttribute("queryData",JSONObject.fromObject(data,CommonUtils.getJsonConfig()));//将默认查询条件传给前台进行默认赋值
 		modelMap.addAttribute("act", act);//act用来说明时添加操作还是修改操作
 		modelMap.addAttribute("model", model);//按钮名
 		service.setModelMapVal(modelMap,user,data,1);//1表示编辑状态，下拉数据提供有权限的数据列表供用户编辑
 		return  "bank/schoolInfo/addOrUpdate";	
 	}	

	
	 @RequestMapping("save")
 	@ResponseBody
	public Object save(@RequestBody SchoolInfo model,String act,String actName,ModelMap modelMap,HttpServletRequest request){
 	Map<String,Object> rs = new HashMap<String,Object>();//返回保存信息提示
 	LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
	if(actName.equals("新增")){
		if(model.getName()==null||model.getName().trim().equals("")){
				rs.put("code","0");
				rs.put("msg","登录名不能为空");
				return rs;
			}
		if(model.getPassWord()==null||model.getPassWord().trim().equals("")){
				rs.put("code","0");
				rs.put("msg","登录密码不能为空");
				return rs;
			}
	}
	if(actName.equals("修改")){
		if(model.getName()==null||model.getName().trim().equals("")){
				rs.put("code","0");
				rs.put("msg","登录名不能为空");
				return rs;
			}
		if(model.getPassWord()==null||model.getPassWord().trim().equals("")){
				rs.put("code","0");
				rs.put("msg","登录密码不能为空");
				return rs;
			}
	}

 	
	if(act.equals("add")){//act=add表示新增操作
	model.setCreateTime(sdf1.format(new Date()));//默认赋值日期格式
	model.setUpdateTime(sdf1.format(new Date()));//默认赋值日期格式
	model.setIsDelete(0);

			model.setId(null);
			rs = service.add(model);
	}
	if(act.equals("update")){//act=update表示修改操作
			model.setUpdateTime(sdf1.format(new Date()));
			SchoolInfo preModel = mapper.selectByPrimaryKey(model.getId());
			rs =service.update(model);
	}
		//完成修改和添加操作
		return rs;
	}

	  @RequestMapping("delete")
	@ResponseBody
	public Object delete(Integer id,String act,ModelMap modelMap,HttpServletRequest request) {
 		LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
 		SchoolInfo preModel = mapper.selectByPrimaryKey(id);
  	Map<String,Object> rs = new HashMap<String,Object>();
		int count = service.delete(id,user );
		if(count>0){
			rs.put("code", 1);
			rs.put("msg", "操作成功");
			return rs;
		}else{
			rs.put("code", 0);
			rs.put("msg", "系统异常");
			return rs;
		}
	}

	 	 @RequestMapping(value = "exportModel", method = RequestMethod.GET)
	 @ResponseBody
	  public void exportModel(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   	List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();//传入空数据，导出数据为空的excel模板
	  	PoiExcelExport pee = new PoiExcelExport(response,"学校管理员导入模板","sheet1"); 
 		String[] headers = {"登录名(*必填)","登录密码(*必填)"		};//定义excel表头中文名
 	String[] columns = {"name","passWord"		};//定义excel表头英文名，跟上面的中文名一一对应，后面好判断哪一列是对应什么数据的，英文名需要和表的属性名对应
	int titleSize[] = {20,20	};//定义excel每一列的宽度
 	try {
 			pee.wirteExcel(columns, headers, titleSize, list);
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	  /**
批量导入数据的接口，解析上传的excel中的数据，将数据批量插入到数据库中
**
**/	@RequestMapping(value = "importData", method = RequestMethod.POST)
 		@ResponseBody
   	public Object importData(@RequestParam MultipartFile file,HttpServletRequest request ,
 				HttpServletResponse response) throws IOException {
			response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
			LoginModel user = (LoginModel) request.getSession().getAttribute(sessionName);
			String data = service.importData(file.getInputStream(),file.getOriginalFilename(),user);//导入数据	
			Map<String,Object> result = new HashMap<String,Object>();
			if(!data.equals("")){
				result.put("code", 0);
 				result.put("msg", data);
 				return result;
 			}else{
 				result.put("code", 1);
 				result.put("msg", "导入成功");
 				return result;
 			}
 		}

	 
	 
	 
}
