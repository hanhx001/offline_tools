/**
 * 
 */
package com.hhx.offline_tools.encode.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 原子更新数组类型类
 * 
 * 1、AtomicIntegerArray     原子更新整数类型里的元素
 * 2、AtomicLongArray        原子更新长整型数组里的元素
 * 3、AtomicReferenceArray   原子更新引用类型数组里的元素
 * @author 清水贤人
 *
 */
public class AtomicArrayType {
	
	// 定义数组
	static int[] value = new int[] { 7, 2 };

	// 原子更新整数类型里 的元素,这里的value 复制时吧里面的两个元素给初始化到这个数组
	static AtomicIntegerArray integerArray = new AtomicIntegerArray(value);
	
	// 原子更新长整形类型数组里的内容
	static AtomicLongArray longArray = new AtomicLongArray(0);
	
	//原子更新引用类型数组里的元素
	static AtomicReferenceArray referenceArray = new AtomicReferenceArray(0);
	
	public static void main(String[] args) {
		
		//integerArray.getAndSet(0, 8);// 获取数组的第0个元素 并赋值为8
		
		//System.out.println(integerArray.get(0)); // 这个是获取修改后的值 为8
		
		/**
		 * 数组value 通过构造方法传递进去，
		 * 然后AtomicIntegerArray 会将当前的数组复制一份，
		 * 所以当AtomicIntegerArray对内部元素进行修改的时候
		 * 不会影响传入的数组
		 */
		//System.out.println(value[0]); // 原始数组的值不变 得到的依旧是7
		
		/**
		 * addAndGet 方法
		 * 第一个入参是 数组中的元素位置（i）
		 * 第二个元素是 准备要加的值（即加数）
		 * 运行后的结果 的返回值就是 数组中的 i和加数的 加法运算值
		 */
		//System.out.println(integerArray.addAndGet(0, 2));
		
		/**
		 * compareAndSe 方法的返回值是boolean
		 * 第一个参数的是数组的下标
		 * 第二个参数是期望的元素的指定下标的值
		 * 第三个参数 如果准备修改为的值
		 * 
		 * 如果第二个元素和数组下标指定的元素的值 相等，则将该小标的值修改为第三个参数的值，返回true
		 * 反之，不做任何修改 返货false
		 */
		//System.out.println(integerArray.compareAndSet(0, 7, 9));
		
		/**
		 * 对指定数组下标的元素进行加1 操作
		 */
		System.out.println(integerArray.incrementAndGet(0));
		 
		// 其余的和AtomicIntegerArray 相差无几 不在列出
	}
	
	 
	
	
}
