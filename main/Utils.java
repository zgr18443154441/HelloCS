package main;

import self_exception.NumberException;

public class Utils {
	/**
	 * 生成一个随机数组
	 * @param num
	 * @return
	 */
	public static Object[] randomIntArray(int num,int min,int max){
		try {
			if(min>max)throw new NumberException();
		} catch (NumberException e) {
			e.printStackTrace();
		}
		Object[] arr = new Object[num];
		for(int i=0;i<num;i++){
			arr[i] = (int)(Math.random()*(max-min)+min);
		}
		return arr;
	}
}
