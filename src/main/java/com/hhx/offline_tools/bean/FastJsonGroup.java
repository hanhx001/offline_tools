package com.hhx.offline_tools.bean;

import java.util.ArrayList;
import java.util.List;

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
public class FastJsonGroup {

	private Long    id ;
	private String  name ;
	private List<FastJsonUser> users =new ArrayList<FastJsonUser>();
	
	public void addUser(FastJsonUser user){
		users.add(user);
		
	}

}
