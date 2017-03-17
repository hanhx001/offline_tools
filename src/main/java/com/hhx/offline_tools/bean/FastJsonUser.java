/**
 * 
 */
package com.hhx.offline_tools.bean;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 配合FastJson 的工具Bean
 * 加入lombok 风格
 * @author 清水贤人
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FastJsonUser {
	

	/**
	 * 使用@JSONField配置 进行定制序列化
	 * 自定义返回在JSON传中的字段样式
	 */

	 @JSONField(name="ID")
	 private Long   id;
	 
	 @JSONField(name="Name")
	 private String name;
	 
	// 配置date序列化和反序列使用yyyyMMdd日期格式
	 @JSONField(format="yyyyMMdd")
	 private Date dateTime;
	 
	 //指定字段不序列化
	 @JSONField(serialize=false)
	 private String sex;
	 
	 //指定字段的顺序
	 @JSONField(ordinal = 1)
	 private String order;
	 
}
