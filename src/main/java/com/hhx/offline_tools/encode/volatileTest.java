package com.hhx.offline_tools.encode;

/**
 * volatile 原理之内存语义实现浅析
 * @author 清水贤人
 *
 */
public class volatileTest {
	
	int a;
	volatile int v1 = 1;
	volatile int v2 = 2;
	
	void readAndWriteVolatile() {
		/**
		 * 第一个volatile读
		 * 
		 * 在第一个volatile读 和第二个volatile读之间 插入了LoadLoad屏障
		 * 用来禁止上面volatile读和下面的volatile读重排序
		 * 
		 * 同时这里还省略了一个LoadStore屏障，因为下面的普通写根本不可能越过上卖弄的volatile读
		 * 
		 */
		int i = v1;
		/**
		 * 第二个volatile读
		 *
		 * 第二个volatile读和普通写之间
		 * 这里省略了LoadLoad屏障，因为下面根本没有普通读操作
		 * 这里插入了一个LoadStore内存屏障 用来禁止下面的普通写和上面的volatile读重排序
		 */
		int j = v2;
		/**
		 *普通写
		 *
		 *普通写和第一个volatile写之间 插入了 一个StoreStore屏障 用来禁止上面的普通写和下面的volatile写重排序
		 *
		 */
		a = i + j;
		/**
		 * 第一个volatile 写
		 * 
		 *  在第一一个volatile 写和第二个volatile写  之间省略了StoreLoad 屏障，仅仅插入StoreStore屏障即可，因为下面跟着一个volatile
		 *  
		 *  同时在这里还插入了一个StoreStore屏障 用来禁止上卖弄的volatile写与下面的volatile写 重排序
		 *  
		 */
		v1 = i + 1;
		/**
		 * 第二个volatile写
		 * 
		 *  在第二个volatile写之后 加入了StoreLoad 屏障 用来防止上面的volatile写与后面可能有的volatile读写重排序
		 *  这一步不能省略，因为在第二个volatile写之后，方法立即return 此时编译器肯恩无法准确判定后面是否会有volatile读或者写
		 *  为了安全起见，编译器通常会在这里插入一个StoreLoad屏障
		 */
		v2 = j + 2;
	}
}
