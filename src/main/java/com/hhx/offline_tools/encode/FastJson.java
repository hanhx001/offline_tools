package com.hhx.offline_tools.encode;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hhx.offline_tools.bean.FastJsonGroup;
import com.hhx.offline_tools.bean.FastJsonUser;

import lombok.Cleanup;



/**
 * 整理fastJson 工具
 * 利用了lombok 
 * @author 清水贤人
 *
 */
public class FastJson {
 
	
	 
	public static void main(String[] args) throws IOException  {
		
		// 给对象赋值 开始
		FastJsonGroup group = new FastJsonGroup();
		group.setId(10L);
		group.setName("groupName");
		
		FastJsonUser a1User = new FastJsonUser();
		a1User.setId(20L);
		a1User.setName("a1");
		a1User.setDateTime(new Date());
		a1User.setOrder("1");
		a1User.setSex("男");
		
		FastJsonUser a2User = new FastJsonUser();
		a2User.setId(30L);
		a2User.setName("a2");
		a2User.setDateTime(new Date());
		a2User.setOrder("2");
		a2User.setSex("女");
		
		group.addUser(a1User);
		group.addUser(a2User);
		// 给对象赋值  结束
		
		/** 
		 *  对象转JSON
		 *  以下为输出结果
		 * {
    		"id": 10,
    		"name": "groupName",
    		"users": [
        		{
            	"id": 20,
            	"name": "a1"
        		},
        		{
            	"id": 30,
            	"name": "a2"
        		}
    		 ]
		  }
		 */
		String json2String = JSON.toJSONString(group);
		System.out.println(json2String);
		
		String json2StringWithNull = JSON.toJSONString(group, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
		 
		
		/**
		 *   带时间格式化的输出
		 *   识别的时间格式(来自官方文档)
		 *   ISO-8601日期格式
	     *	 yyyy-MM-dd
		 *   yyyy-MM-dd HH:mm:ss
		 * 	 yyyy-MM-dd HH:mm:ss.SSS
	     *	  毫秒数字
		 *	 毫秒数字字符串
		 *	.NET JSON日期格式
		 *	new Date(198293238)
		 */
		//  时间输出样式："dateTime": "2017-03-17 11:34:00.203",
		String json2StringWithDateFormat1 = JSON.toJSONStringWithDateFormat(group, "yyyy-MM-dd HH:mm:ss.SSS");
		
		// 使用ISO-8601日期格式 时间输出样式： "dateTime":"2017-03-17T11:38:46.407+08:00"
		String json2StringWithDateFormat2 = JSON.toJSONString(group, SerializerFeature.UseISO8601DateFormat);
		
		// 全局修改日期格式  时间输出样式："dateTime":"2017-03-17"
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		String json2StringWithDateFormat3 = JSON.toJSONString(group, SerializerFeature.WriteDateUseDateFormat);
		
		/**
		 * 大文件的数组序列化 利用了lombok 风格的@Cleanup
		 * 原理就是 根据数组的大小，将数组的数据生成到你引入的那个json文件中
		 * 
		 */
		try {
			
			@Cleanup JSONWriter write = new JSONWriter(new FileWriter("./resource/json.json"));
			
			write.startArray();
			
			for(int i=0 ; i < 1 ; ++i){
				
				write.writeValue(group);
			}
			
			write.endArray();
			
			// lombok 里面带了关闭流的操作，这里再次关闭会空指针
			//write.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			/**
			 * 大文件JSONObject的序列化 利用了lombok 风格的@Cleanup
			 * 原理就是 根据数组的大小，将数组的数据生成到你引入的那个json文件中
			 * 
			 */
		   @Cleanup JSONWriter writer = new JSONWriter(new FileWriter("./resource/json.json"));
		    writer.startObject();
		    for (int i = 0; i < 10; ++i) {
		       // writer.writeKey("x" + i);
		        writer.writeValue(group);
		     }
		       writer.endObject();
		      // writer.close();
		
			/**
			 * 字符串转对象
			 * 注意事项：
			 *  1、对@JSONField注解的标记 没影响，依旧可以转换成指定字符串
			 *  2、对字符串进行时间操作后没影响
			 * 
			 */
			FastJsonGroup backGroup =JSON.parseObject(json2StringWithDateFormat3,FastJsonGroup.class);
		
	}

}
