/**
 * 
 */
package com.hhx.offline_tools.bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Lombok 消除冗余代码
 * @author 清水贤人
 *
 */


//@Data 

/**
 * @Data 是一个组合集
 * 注解在类上，
 * 相当于同时使用了
 * @ToString、
 * @EqualsAndHashCode、
 * @Getter、
 * @Setter
 * @RequiredArgsConstrutor这些注解
 *
 */

public class LombokUser {
	
	/**
	 *  @Getter @Setter
	 *  在属性上写这个，只是给这个属性加入相应的get set 方法
	 *  如果要求get/set 包访问权限不是public 可以通过 @Getter @Setter(AccessLevel.PROTECTED) 选项分为PUBLIC, PROTECTED, PACKAGE, and PRIVATE.
	 *  
	 */
	 @Getter @Setter()
	 private String id;
	 
	 @Getter @Setter()
	 private String lazy;
	
	 private String name;
	 
	 @Getter @Setter(AccessLevel.PROTECTED)
	 private String isFoo;
	 
	 
}
