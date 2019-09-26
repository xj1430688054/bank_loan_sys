package com.load.utils.common;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;
public class CommonUtils {
	/**
	 * 将json转成json字符串的配置
	 * @return
	 */
	public static 	 JsonConfig getJsonConfig(){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor() {
			public Object getDefaultValue(Class type) {
				return null;//double类型如果为null，则返回null
			}
		});
		jsonConfig.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor() {
			public Object getDefaultValue(Class type) {
				return null;//integer类型如果为null，则返回null
			}
		});
		return jsonConfig;
	}
	/**
	 * 拼装下拉列表的id和名称
	 * @return
	 */
	public static Map<String,Object> getCommonMap(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}
	/**
	 * 检查字符串是否是int类型
	 * @param str
	 * @return
	 */
	public static boolean checkIsIntStr(String str){
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 检查字符串是否是double类型
	 * @param str
	 * @return
	 */
	public static boolean checkIsDoubleStr(String str){
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * str字符串是否包含subStr字符串
	 * @param str
	 * @return
	 */
	public static boolean isContain(String str,String subStr){
		if(str.contains(subStr+",")
				||str.contains(","+subStr)
				||str.equals(subStr)){
			return true;
		}
		return false;
	}
	/**
	 * 检查int数字是否大于0
	 * @param str
	 * @return
	 */
	public static boolean checkIntNumIsOverZerio(Integer num){
		if(num==null){
			return false;
		}
		if(num>=0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 检查double数字是否大于0
	 * @param str
	 * @return
	 */
	public static boolean checkDoubleNumIsOverZerio(Double num){
		if(num==null){
			return false;
		}
		if(num>=0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 检查是否是yyyy-MM-dd格式的字符串
	 * @param str
	 * @return
	 */
	public static boolean checkDateFormat(String dateStr){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{  
            Date date = formatter.parse(dateStr);  
           return true;
        }catch(Exception e){
        	return false;
        }
}
	public static String  dateFormat(String dateStr){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{  
           Date date = formatter.parse(dateStr);
           return formatter.format(date);
        }catch(Exception e){
        	return null;
        }
}
	public static  boolean checkDateTimeFormat(String dateStr){
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try{  
        Date date = formatter.parse(dateStr);  
       return true;
    }catch(Exception e){
    	return false;
    }
}
	public static String  dateTimeFormat(String dateStr){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{  
           Date date = formatter.parse(dateStr);
           return formatter.format(date);
        }catch(Exception e){
        	return null;
        }
}
	/**
	 * 将y轴数据按照x轴顺序提取出来
	 * @param list
	 * @param xList
	 * @return
	 */
	public static List<String> getYValueList(List<Map<String,Object>> list,List<String> xList){
		 List<String> rs = new ArrayList<String>();
		 for(String s:xList){
			 for(Map<String,Object> map:list){
				 if(s.equals(map.get("xValue").toString())){
					 rs.add(map.get("yValue").toString());
					 break;
				 }
			}
		 }
		 return rs;
	}
	/**
	 * 合并掉所有的x轴数据，并按照大小排序
	 * @param list
	 * @return
	 */
	public static List<String> mergeAllXValueList(List<List<Map<String,Object>>> list){
		 Set<String> rs1 = new HashSet<String>();
		 for(List<Map<String,Object>> l:list){
			 for(Map<String,Object> map:l){
				rs1.add(map.get("xValue").toString());
			 }
		 }
		 List<String> rs = new ArrayList<String>();
		 for(String s:rs1){
			 rs.add(s);
		 }
		 Collections.sort(rs, new Comparator<String>(){
	            public int compare(String p1, String p2) {
	                //按照Person的年龄进行升序排列
	                if(p1.compareTo(p2)>0){
	                    return 1;
	                }
	                if(p1.equals(p2)){
	                    return 0;
	                }
	                return -1;
	            }
	        });
		 return rs;
	}
	/**
	 * 当x轴该点没有数据时，自动填充0进去
	 * @param list
	 * @param timeList
	 */
	public static void setEmptyObjInList(List<Map<String,Object>> list,List<String> timeList){
		for(String s:timeList){
			boolean flag=false;
			for(Map<String,Object> map:list){
				if(map.get("xValue").toString().equals(s)){//存在x轴对应的值
					flag=true;
					break;
				}
			}
			if(flag==false){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("xValue", s);
				map.put("yValue", 0);
				list.add(map);
			}
		}
		 Collections.sort(list, new Comparator<Map<String,Object>>(){
	            public int compare(Map<String,Object> p1, Map<String,Object> p2) {
	                //按照Person的年龄进行升序排列
	                if(p1.get("xValue").toString().compareTo(p2.get("xValue").toString())>0){
	                    return 1;
	                }
	                if(p1.get("xValue").toString().equals(p2.get("xValue").toString())){
	                    return 0;
	                }
	                return -1;
	            }
	        });
	}
	public static List<String> getTimeList(String fomat,Integer xValueType){
		List<String> rs = new ArrayList<String>();
		Date now = new Date();
	    SimpleDateFormat df = new SimpleDateFormat(fomat);
	    if(xValueType==11){//当天24小时
	    	 Calendar date = Calendar.getInstance();
		    date.setTime(now);
		   date.set(Calendar.HOUR_OF_DAY, 0);
		   date.set(Calendar.MINUTE, 0);
		   int day = date.get(Calendar.DATE);
	    	while(day== date.get(Calendar.DATE)){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.HOUR_OF_DAY, 1);
	    	}
	    }
	    if(xValueType==2){//近24小时
	    	 Calendar date = Calendar.getInstance();
 		    date.setTime(now);
 		   date.set(Calendar.MINUTE, 0);
	    	for(int i=0;i<=23;i++){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.HOUR_OF_DAY, -1);
	    	}
	    }
	    if(xValueType==3){//昨天24小时
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	  	  date.set(Calendar.MINUTE, 0);
	    	date.add(Calendar.DATE, -1);
	    	date.set(Calendar.HOUR_OF_DAY, 0);
	    	date.set(Calendar.MINUTE, 0);
	    	for(int i=0;i<=23;i++){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.HOUR_OF_DAY, 1);
	    	}
	    }
	    if(xValueType==4){//近7天
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	  	  date.set(Calendar.HOUR_OF_DAY, 0);
	    	for(int i=0;i<=6;i++){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.DATE, -1);
	    	}	
	    }
	    if(xValueType==9){//上一周
	  	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	    	  date.set(Calendar.DAY_OF_WEEK, 1);
	    	  date.add(Calendar.DATE, -7);
	    	  for(int i=0;i<=6;i++){
		    		rs.add(df.format(date.getTime()));
		    		date.add(Calendar.DATE, 1);
		    	}
	    }
	    if(xValueType==10){//本周
		  	  Calendar date = Calendar.getInstance();
		  	    date.setTime(now);
		    	  date.set(Calendar.DAY_OF_WEEK, 1);
		    	  for(int i=0;i<=6;i++){
			    		rs.add(df.format(date.getTime()));
			    		date.add(Calendar.DATE, 1);
			    	}
		    }
	    if(xValueType==5){//近30天
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	  	  date.set(Calendar.HOUR_OF_DAY, 0);
	    	for(int i=0;i<=29;i++){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.DATE, -1);
	    	}
	    }
	    if(xValueType==12){//本月
	    	Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	  	  date.set(Calendar.DATE, 1);
	  	  date.set(Calendar.HOUR_OF_DAY, 0);
	  	  int month = date.get(Calendar.MONTH); 
	  	while(date.get(Calendar.MONTH)==month){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.DATE, 1);
	    	}
	    }
	    if(xValueType==6){//上个月所有天数
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	    	date.add(Calendar.MONTH, -1);
	    	  date.set(Calendar.HOUR_OF_DAY, 0);
	    	int lastMonth = date.get(Calendar.MONTH); 
	    	 date.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	    	while(date.get(Calendar.MONTH)==lastMonth){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.DATE, 1);
	    	}
	    }
	    if(xValueType==7){//1年内
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	  	  date.set(Calendar.DATE, 1);
	    	for(int i=0;i<12;i++){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.MONTH, -1);
	    	}
	    }
	    if(xValueType==13){//本年
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	    	 date.set(Calendar.MONTH,0);//设置为1号,当前日期既为本月第一天 
	  	  date.set(Calendar.DATE, 1);
	    	int lastYear = date.get(Calendar.YEAR); 
	    	while(date.get(Calendar.YEAR)==lastYear){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.MONTH, 1);
	    	}
	    }
	    if(xValueType==8){//上一年
	    	  Calendar date = Calendar.getInstance();
	  	    date.setTime(now);
	    	date.add(Calendar.YEAR, -1);
	    	 date.set(Calendar.MONTH,0);//设置为1号,当前日期既为本月第一天 
	  	  date.set(Calendar.DATE, 1);
	    	int lastYear = date.get(Calendar.YEAR); 
	    	while(date.get(Calendar.YEAR)==lastYear){
	    		rs.add(df.format(date.getTime()));
	    		date.add(Calendar.MONTH, 1);
	    	}
	    }
	    Collections.sort(rs, new Comparator<String>(){
            public int compare(String p1, String p2) {
                //按照Person的年龄进行升序排列
                if(p1.compareTo(p2)>0){
                    return 1;
                }
                if(p1.equals(p2)){
                    return 0;
                }
                return -1;
            }
        });
	    return rs;	
	}
	 public static String removeDoubleStringToIntString(String val){
	    	if(val.contains(".")){
	    		return val.split("\\.")[0];
	    	}
	    	return val;
	    }
}
