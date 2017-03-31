/**
 * 
 */
package com.hhx.offline_tools.encode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 清水贤人
 *
 */
public class HashmapTest {

	 
	public static void main(String[] args) {
		
		// Hashmap非线程安全
		HashMap map = new HashMap();
		
		//Hashmap 线程安全的获取方法
		Map mapSynch = Collections.synchronizedMap(new HashMap(100));
		
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
		
		Integer aInteger = new Integer(1);
		Integer biInteger = new Integer(1);
		System.out.println(aInteger.hashCode());
		System.out.println(biInteger.hashCode());
		
		//最优 加载因子
		Map mapBest = new HashMap((int) ((float) 100 / 0.75F + 1.0F));
		
	}

}
