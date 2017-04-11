/*
 * 数组中有n个数据，顺序依次比较相邻的两个数据，把大的数往后移，最差移动n-1个数据，第i次（0<i<n）比较n-i组数据
 * 复杂度（n-1）*（n-i）
 * */

package algorithms;

import data_structures.list.ListStruct;
import self_exception.TypeSelectException;

public class BubbleSort {
	/**
	 * type	1:升序头冒泡	2:升序尾冒泡	3:降序头冒泡	4:降序尾冒泡
	 * @param ls
	 * @param type
	 * @return
	 */
	public static ListStruct sort(ListStruct ls,int type){
		int temp = 0;
		switch (type) {
		case 1:
			for(int i=0;i<ls.max_index();i++){
				for(int j=ls.max_index();j>0;j--){
					if((int)ls.getElem(j)<(int)ls.getElem(j-1)){
						temp = (int)ls.getElem(j);
						ls.setElem(j, ls.getElem(j-1));
						ls.setElem(j-1, temp);
						System.out.println(ls);
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<ls.max_index();i++){
				for(int j=0;j<ls.max_index()-i;j++){
					if((int)ls.getElem(j)>(int)ls.getElem(j+1)){
						temp = (int)ls.getElem(j);
						ls.setElem(j, ls.getElem(j+1));
						ls.setElem(j+1, temp);
						System.out.println(ls);
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<ls.max_index();i++){
				for(int j=ls.max_index();j>0;j--){
					if((int)ls.getElem(j)>(int)ls.getElem(j-1)){
						temp = (int)ls.getElem(j);
						ls.setElem(j, ls.getElem(j-1));
						ls.setElem(j-1, temp);
						System.out.println(ls);
					}
				}
			}
			break;
		case 4:
			for(int i=0;i<ls.max_index();i++){
				for(int j=0;j<ls.max_index()-i;j++){
					if((int)ls.getElem(j)<(int)ls.getElem(j+1)){
						temp = (int)ls.getElem(j);
						ls.setElem(j, ls.getElem(j+1));
						ls.setElem(j+1, temp);
						System.out.println(ls);
					}
				}
			}
			break;
		default:
			try {
				throw new TypeSelectException();
			} catch (TypeSelectException e) {
				e.printStackTrace();
			}
			break;
		}
		return ls;
	}
}
