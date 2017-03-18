/**
 * 
 */
package com.hhx.offline_tools.encode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.hhx.offline_tools.bean.LombokUser;

import lombok.Cleanup;
import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;



/**
 * Lombok 消除冗余代码
 * @author 清水贤人
 *
 */
public class Lombok {
	
	
	/**
	 * val 的运用
	 * @return
	 */
	public String finalExample() {
		
		// 一下两句代码效果一样 区别在于 lombok 的运用
		 val  example = new ArrayList<String>();
		//final ArrayList<String> example = new ArrayList<String>();
		
		example.add("Hello");
		example.add("world");
		
		// 一下两句代码效果一样 区别在于 lombok 的运用
		  val foo = example.get(0);
		//final String foo = example.get(0);
		
		return foo.toLowerCase();
		
	}
	
	/**
	 * @NonNull 的运用
	 * 在入参列表中 加入这个注解 就可以省去 方法内部的if 为空的判断
	 * 这个注解会自动在方法内对该参数进行是否为空的校验，如果为空，则抛出NPE
	 */
	
	private String id;
	
	public void NonNullExample(@NonNull LombokUser user) {
		
		if(user == null){
			throw new NullPointerException("用户对象为空");
		}
		
		this.id = user.getId();
	}
	
	
	/**
	 * @SneakyThrows
	 * 作用就是抛出异常
	 * 对于拟不想处理的异常，直接在类上这样抛出，分分钟简化代码
	 * @param bytes
	 * @return
	 */
	@SneakyThrows(UnsupportedEncodingException.class)
	public String utf2Strinig(byte [] bytes) {
		
		return new String(bytes,"UTF-8");
		
	}
	
 
	/**
	 * @Getter(lazy=true)
	 * 这个注解的作用相当于缓存，就是我在第一次调用后这个值会一直存在，不在浪费资源去重复生成了
	 * 使用了getter这个annotation可以在实际使用到cached的时候生成cached，同时，Lombok会自动去管理线程安全的问题，不会存在重复赋值的问题
	 */
	
	@Getter(lazy=true)private final String lazyCache = newLazyData();

	private String newLazyData() {
		
		StringBuilder builder =new StringBuilder();
		
		for(int i = 0; i < 10*10; ++i) {
			
			builder.append("data" + i);
			
		}
		return builder.toString();
		
		
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * Cleanup的应用
		 * 自动管理资源，用在局部变量之前
		 * 他会默认帮你加入 try/catch 最后还会默认执行close 关闭方法
		 * 在这里例子里 需要将异常抛出，相对加入try/catch 的代码简介许多
		 */
		@Cleanup InputStream inputStream = new FileInputStream(args[0]);
	    @Cleanup OutputStream out = new FileOutputStream(args[1]);

	}

}
