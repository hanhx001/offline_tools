
package com.hhx.offline_tools.encode.Atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子更新基本类型类
 * @author 清水贤人
 *
 */
public class AtomicBaseType {

	// 原子方式更新基本类型，Atomic 包提供以下3个类
	static AtomicInteger aInteger = new AtomicInteger(1);     //写1 代表默认值为1
	static AtomicBoolean aBoolean = new AtomicBoolean();  //括号中可以自定义默认值，不定义默认为false
	static AtomicLong    aLong    = new AtomicLong();         //默认值为0
	
	public static void main(String[] args) {
		 /**
		  * AtomicInteger API 
		  * get()是获取当前的值
		  * addAndGet(X)是以原子方式将输入的值与实例中的值相加 并返回结果
		  * compareAndSet(x，y)先获取当前的值，如果输入的x值和当前值相等，则吧当前值变为y,否则保持不变
		  * getAndIncrement 以原子方式将当前值加1，同时返回加1之前的值
		  * decrementAndGet 以原子形式减去1 并返回减1之后的值
		  * getAndSet（x） 以原子方式设置值为ｘ　并返回原始值
		  */
		System.out.println(aInteger.get());
		System.out.println(aInteger.addAndGet(1));
		System.out.println(aInteger.compareAndSet(1, 5));
		System.out.println(aInteger.getAndIncrement());
		System.out.println(aInteger.decrementAndGet());
		System.out.println(aInteger.getAndSet(8));
		System.out.println(aInteger.get());
		
		
		//由于 AtomicBoolean，AtomicLong API和AtomicInteger 相差无几 在这里不列出
		
	}

}
