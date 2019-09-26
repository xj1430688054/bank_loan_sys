package com.load.service.impl.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.load.utils.common.CommonUtils;
/**
 * 下拉列表常用数据解释器
 * @author Administrator
 *
 */
public class DataListUtils {
	public static void main(String[] args) {
	}
	 /**
 **获取loginType常用数据列表
 */
 public static List<Map<String,Object>> getLoginTypeList(Integer loginTypeId){
 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
 list.add(getMap("1","银行管理员"));
 list.add(getMap("2","学校管理员"));
 list.add(getMap("3","学生"));
 return list;
  }


 /**
 **获取check_status常用数据列表
 */
 public static List<Map<String,Object>> getCheckStatusList(Integer loginTypeId){
 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
 list.add(getMap("1","待审核"));
 list.add(getMap("2","审核通过"));
 list.add(getMap("3","审核不通过"));
 return list;
  }


public static String getCheckStatusNameById(String id,Integer loginTypeId){
	if(id==null){
		return null;
	}
	if(id.endsWith(",")){
		id = id.substring(0,id.length()-1);
	}
	String[] idsplit = id.split(",");
	String rs = "";
	List<Map<String,Object>> list = getCheckStatusList( loginTypeId);
	for(String tmp:idsplit){
		for(Map<String,Object> map:list){
			if(map.get("id").toString().equals(tmp)){
				rs+=map.get("name").toString()+",";
			}
		}
	}
	if(rs.endsWith(",")){
		rs = rs.substring(0,rs.length()-1);
	}
	return rs;
}
 /**
 **获取is_black常用数据列表
 */
 public static List<Map<String,Object>> getIsBlackList(Integer loginTypeId){
 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
 list.add(getMap("1","黑名单"));
 list.add(getMap("2","白名单"));
 return list;
  }


public static String getIsBlackNameById(String id,Integer loginTypeId){
	if(id==null){
		return null;
	}
	if(id.endsWith(",")){
		id = id.substring(0,id.length()-1);
	}
	String[] idsplit = id.split(",");
	String rs = "";
	List<Map<String,Object>> list = getIsBlackList( loginTypeId);
	for(String tmp:idsplit){
		for(Map<String,Object> map:list){
			if(map.get("id").toString().equals(tmp)){
				rs+=map.get("name").toString()+",";
			}
		}
	}
	if(rs.endsWith(",")){
		rs = rs.substring(0,rs.length()-1);
	}
	return rs;
}

	private static Map<String,Object> getMap(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}
}
