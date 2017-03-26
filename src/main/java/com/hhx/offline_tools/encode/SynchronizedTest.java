/**
 * 
 */
package com.hhx.offline_tools.encode;

/**
 * Synchronized获取锁的原理解析
 * @author 清水贤人
 *
 */
public class SynchronizedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//对Synchronized Class 对象进行加锁
		synchronized (SynchronizedTest.class) {
			
		}
		//静态同步方法，对Synchronized Class 对象进行加锁
		m();
	}
	
	public static synchronized void m(){
		
		
	}

}
