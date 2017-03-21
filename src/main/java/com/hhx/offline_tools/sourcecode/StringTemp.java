/**
 * 
 */
package com.hhx.offline_tools.sourcecode;

/**
 * String 源码
 * @author 清水贤人
 *
 */


public class StringTemp {
	
	private static String a;
	public static void main(String[] args) {
		
		/**
		 * 成员变量 自动赋值null
		 */
		System.out.println(a);
		
		/**
		 * bstring 是申明一个字符串 给他赋值为空
		 * ctring  是申请一个字符串，没有给他赋值，而是空引用
		 * 所以第二个会输出出现NPE问题
		 */
		String bString = "";
		String cString = null;
		
		System.out.println(bString.trim());
		//System.out.println(cString.trim()); //会有NPE问题
		
		/**
		 * 判断字符串为空
		 */
		if("" == bString || null == bString) {
			//do somthing
		}
		
		 
		 //--------------关于不可变对象 ---------------
		  
		// 创建一个String 对象dstring,让他的值为hello
		String dString = "hello";
		
		/**
		 *  让dstring 的值变为world 
		 *  这里string 只是一个引用，指向了一个具体的对象，当dString = "world"; 这句话执行之后，
		 *  又创建了一个新对象“world” 原来的“hello”还存在内存中，并没与改变
		 */
		dString = "world";
		
		//这段注释 是String类的源码
		/**
		 * public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
		 *  private final char value[];
 			private int hash;
 			
 			可以看出，String类就是对字符数组的封装
		 */
		
		String str = "abc";
		char data[] = {'a','b','c'};
		String str1 = new String("abc");
		String  str2 = "abc";
		
		System.out.println(str.equals(str1));//true
		System.out.println(str == str1 );//false
		System.out.println(str == str2 );//true
		
		
		
		 String s0= "hello"; //声明的变量存在栈内存中，会留存在字符串常量中缓存
		 String s1=new String("hello"); //定义的对象直接存在堆内存中，不会进入字符串常量，两个值也不相等
		 String s2=new String("hello"); 
		 
		 s1.intern(); 
		 s2=s2.intern();
		
		 System.out.println( s0==s1.intern() );//true
		 System.out.println( s0==s2 );         //true
		 


	}
	 

}
