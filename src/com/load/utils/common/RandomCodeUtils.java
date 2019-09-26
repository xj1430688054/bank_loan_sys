package com.load.utils.common;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
public class RandomCodeUtils {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	public static String getRandomCode(){
		Random rand = new Random();
		String ranInt = rand.nextInt(1000000)+"";
		int len = ranInt.length();
		for(int i=len;i<6;i++){
			ranInt="0"+ranInt;
		}
		return ranInt;
	}
}
