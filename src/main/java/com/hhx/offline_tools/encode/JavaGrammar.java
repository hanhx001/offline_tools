/**
 * 
 */
package com.hhx.offline_tools.encode;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.net.Socket;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import lombok.Cleanup;
import lombok.AllArgsConstructor.AnyAnnotation;

/**
 * 整理JAVA基础语法
 * @author 清水贤人
 *
 */
public class JavaGrammar {

	
	public static void main(String[] args) throws IOException {
		
		//定义字符串
		String stringTemp1 = "hello , world";
		String stringTemp2 = "world";
		 
		
		//字符串比较
		boolean comp = stringTemp1.equals(stringTemp2);
		//字符串忽略大小写比较
		boolean compWithNoCase=stringTemp1.equalsIgnoreCase(stringTemp2);
		
		// 搜索 从0开始算 这里indexResult为6 ；如果有值返回对应索引，没值返回-1
		int indexResult = stringTemp1.indexOf(stringTemp2);
		
		// 搜索 从1开始算 这里indexResult为6 ；如果有值返回对应索引，没值返回-1
		int indexResult2 = stringTemp1.indexOf(stringTemp2,1); 
		
		// 字符串反转
		StringBuilder builderReverse = new StringBuilder(stringTemp1);
		
		// 反转后是每个字母均反转了
		String stringReverse = builderReverse.reverse().toString();
		
		// 转换大小写
		String strUpper = stringTemp1.toUpperCase();
		
		String strLower = stringTemp1.toLowerCase();
		
		// 移除收尾空格
		stringTemp1.trim();
		
		//移除所有空格
		stringTemp1.replace(" ","");
		
		// 字符串转数组，声明啥样转出来就是啥样(包括空格)
		String arrayTemp = "a, b , c, d   ,e";
		
		String[] arrayResult = arrayTemp.split(",");
		
		
		// 集合遍历
		HashMap map = new HashMap();
		
		map.put("key1", "111");
		map.put("key2", "222");
		map.put("key3", "333");
		
		for(Iterator iterator = map.entrySet().iterator();iterator.hasNext();) {
			
			Map.Entry entry = (Entry) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			
		}
		
		// hashMap 查找key
		 map.containsKey("key1");
		 
		//二分查找.要求是有序数组
		int[] nums = new int[]{7,5,1,3,6,8,9,2};
		// 1 2 3 5 6 7 8 9
		Arrays.sort(nums);
		int index = Arrays.binarySearch(nums, 7);
		
		//arrayList 转array
		ArrayList arrayList = new ArrayList();
		Object[] objects = arrayList.toArray();
		
		// 将hashmap 转array
		Object[] obj = map.entrySet().toArray();
		
		
		// 使用 StringBuffer 替换匹配字符串
		Pattern pattern = Pattern.compile("My");
		
		Matcher matcher = pattern.matcher("My a and My b");
		
		StringBuffer sb = new StringBuffer();
		
		boolean found = matcher.find();
		
		while(found) {
			
			matcher.appendReplacement(sb, "Here");
			found = matcher.find();
			
		}
		
		matcher.appendTail(sb);
		System.out.println(sb);//Here a and Here b

		// 判断字符串是不是数字
		String numString = "12312121";
		
		System.out.println(numString.matches("[0-9]+"));
		System.out.println(numString.matches("[0-9]{1,}"));
		
		Double aDouble = 4.50;
		Double bDouble = 4.50;
		
		// 判断Double
		boolean resultDouble=aDouble.equals(bDouble);
		
		//System.out.println(resultDouble);
				
		// 十进制转二进制，八进制，十六进制
		
		int val = 25;
		String binaryStr = Integer.toBinaryString(val);
		
		String octalStr = Integer.toOctalString(val);
		
		String hexStr = Integer.toHexString(val);
		
		//读取 压缩包文件(Jar/zip/rar )
		@Cleanup ZipFile file = new ZipFile("D://apache-tomcat-7.0.69 -Spring.zip");
		
		Enumeration entries = file.entries();
		
		while(entries.hasMoreElements()) {
			
			ZipEntry entry =(ZipEntry) entries.nextElement();
			
			if(entry.isDirectory()) {
				//System.out.println(entry.getName()+"-"+entry.getSize());
				//System.out.println("------------------");
			}
		}
		
		 
	}

}
