package com.hhx.offline_tools.encode;

import java.util.HashMap;
import java.util.Map;

/**
 * NPE 问题
 * @author 清水贤人
 *
 */

public class NullTest {

	public static void mVoid() {
		System.out.println("NullTest.mVoid()");
	}
	
	public static void main(String[] args) {
		
		Integer nullInteger = null;
		int data = nullInteger; 
		System.out.println(data);
		
		  Map map = new HashMap<>();
	      int[] numbers = {3, 5, 7,9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};
	 
	      for(int i : numbers){ 
	    	  int f =i;
	         int count = (int) map.get(i);
	         map.put(i, count++); // NullPointerException here
	      }    
		
		//使用了带有null值的引用类型变量，instanceof操作将会返回false
		//System.out.println(nullInteger instanceof Integer);//fasle
		
		System.out.println(null == null);//true

		
		
	}

}
