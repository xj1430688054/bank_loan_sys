package com.load.util;
public class CommonVal {
	public static String code="721898";
	private  static String hostPort = "localhost:8080";
	public static String imgProjectName = "";
	public static String imgUri=hostPort+"/images/"+imgProjectName;
	public static String defaultImgUri=hostPort+"/bank_loan_sys/images";
	//如果需要改图片存放路径，需要将上面imgUri一起改，改为相应的url
	public static String tomcatRealPath = "";
	public static String imgRealPath=tomcatRealPath+"/webapps/images/"+imgProjectName;
}
