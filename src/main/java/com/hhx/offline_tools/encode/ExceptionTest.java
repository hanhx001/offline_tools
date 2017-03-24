/**
 * 
 */
package com.hhx.offline_tools.encode;

/**
 * 自定义异常
 * @author 清水贤人
 *
 */
public class ExceptionTest {

	/**
	 * 
	 */
	public ExceptionTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExceptionTest test = new ExceptionTest();
		try {
			test.display(0);
		} catch (ExceptionDefine e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void display(int i) throws ExceptionDefine {
		
		if(i == 0) {
			
			throw new ExceptionDefine("你好啊");
			
		}else {
			System.out.println(i/2);
		}
		
	}

}
