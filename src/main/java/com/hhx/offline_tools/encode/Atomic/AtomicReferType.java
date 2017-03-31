/**
 * 
 */
package com.hhx.offline_tools.encode.Atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 
 * 原子更新引用类型
 * 
 * 1、AtomicReference               原子更新引用或类型的字段
 * 2、AtomicReferenceFieldUpdater   原子更新带有引用类型的字段
 * 3、AtomicMarkableReference       原子更新带有标记位的引用类型
 * 
 * @author 清水贤人
 *
 */
public class AtomicReferType {
	
	public static AtomicReference<User> atomicUser = new AtomicReference<User>();
	
	
	public static void main(String[] args) {
		
		User user = new User("hhx" , 8);
		
		atomicUser.set(user);
		
		User updateUser = new User("hhx1" , 81);
		
		/**
		 * compareAndSet
		 * 这两个方法 目前是一样的，但是源码的注释不一样
		 * 老外给的解释是：我们暴保留后期会更改的权利,只不过暂时没有变
		 * 建议分开使用
		 */
		System.out.println(atomicUser.compareAndSet(user, updateUser));
		System.out.println(atomicUser.weakCompareAndSet(user, updateUser));
		
		/**
		 * AtomicReferenceFieldUpdater 
		 * 他能对指定类的指定volatile字段进行原子更新（不能声明为private）
		 * 第一个参数为要更新的类的类名
		 * 第二个字段为要更新的字段名属性（包装类）
		 * 第三个字段为要更新的字段的 字段名（用双引号包裹）
		 */
		AtomicReferenceFieldUpdater fileUpload = AtomicReferenceFieldUpdater.
				                                 newUpdater(User.class, Integer.class, "sex");
		
		fileUpload.compareAndSet(user, user.sex, 6);
		
		System.out.println(user.sex);
		
	}
	
	
	 


	// User 实体
	static class User {
		
		private String name;
		private int old;
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
