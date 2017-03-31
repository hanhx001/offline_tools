/**
 * 
 */
package com.hhx.offline_tools.encode.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import org.omg.CORBA.ObjectHolder;

/**
 * 原子更新字段类
 * 类为：
 * 1、AtomicIntegerFieldUpdater 原子更新整形的字段的更新器
 * 2、AtomicLongFieldUpdater    原子更新长整形字段的更新器
 * 3、AtomicStampedReference    原子更新带有版本号的引用类型
 * @author 清水贤人
 *
 */
public class AtomicFieldType {
	
	
	 

	/**
	 * 创建原子更新器，并设置需要更新的对象类和对象的属性
	 * 
	 * 原子更新字段需要两部：
	 * 1、因为原子更新字段都是抽象类，每次使用的时候，必须使用静态方法NewUpdater()，创建一个更新器
	 * 并且需要设置需要更新的类和属性
	 * 2、更新字段，字段必须使用public volatile修饰
	 */
	private static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.
			newUpdater(User.class, "old");
	
	public static void main(String[] args) {
		
		User user = new User("hhx", 8);
		
		// 增整了1 但是会输出旧的值
		System.out.println(atomicIntegerFieldUpdater.getAndIncrement(user));
		
		// 直接输出新值（增长后的）
		System.out.println(atomicIntegerFieldUpdater.get(user));
	}
			
			
	
	
	
	
	// User 实体
	public static class User {
		
		private String name;
		public volatile int old;
	    volatile Integer sex=3;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getOld() {
			return old;
		}
		public void setOld(int old) {
			this.old = old;
		}
		public User(String name, int old) {
			super();
			this.name = name;
			this.old = old;
		}
	}
}
