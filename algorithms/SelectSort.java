/*
 * 数组中有n个元素，依次从数组中剩余的未排序元素中选择出最大（小）的一个元素和未排序的第一个元素位置作交换，直到所有元素被排序，共计选择n次，每次比较n-1~1组元素
 * 
 * */

package algorithms;

import data_structures.list.ListStruct;
import self_exception.TypeSelectException;

public class SelectSort {
	/**
	 * type 1:升序选小数 2:升序选大数 3:降序选小数 4:降序选大数
	 * 
	 * @param ls
	 * @param type
	 * @return
	 */
	public static ListStruct sort(ListStruct ls, int type) {
		int temp = 0;
		switch (type) {
		case 1:
			for (int i = 0; i <= ls.max_index(); i++) {
				int min_index = i;
				for (int j = i + 1; j <= ls.max_index(); j++) {
					if ((int) ls.getElem(j) < (int) ls.getElem(min_index)) {
						min_index = j;
					}
				}
				if (min_index != i) {
					temp = (int) ls.getElem(i);
					ls.setElem(i, ls.getElem(min_index));
					ls.setElem(min_index, temp);
					System.out.println(ls);
				}
			}
			break;
		case 2:
			for(int i=ls.max_index();i>=0;i--){
				int max_index = i;
				for(int j=i-1;j>=0;j--){
					if((int)ls.getElem(j)>(int)ls.getElem(max_index)){
						max_index = j;
					}
				}
				if(max_index!=i){
					temp = (int) ls.getElem(i);
					ls.setElem(i, ls.getElem(max_index));
					ls.setElem(max_index, temp);
					System.out.println(ls);
				}
			}
			break;
		case 3:
			for(int i=ls.max_index();i>=0;i--){
				int min_index = i;
				for(int j=i-1;j>=0;j--){
					if((int)ls.getElem(j)<(int)ls.getElem(min_index)){
						min_index = j;
					}
				}
				if(min_index!=i){
					temp = (int) ls.getElem(i);
					ls.setElem(i, ls.getElem(min_index));
					ls.setElem(min_index, temp);
					System.out.println(ls);
				}
			}
			break;
		case 4:
			for(int i=0;i<=ls.max_index();i++){
				int max_index = i;
				for(int j=i+1;j<=ls.max_index();j++){
					if((int)ls.getElem(j)>(int)ls.getElem(max_index)){
						max_index = j;
					}
				}
				if(max_index!=i){
					temp = (int) ls.getElem(i);
					ls.setElem(i, ls.getElem(max_index));
					ls.setElem(max_index, temp);
					System.out.println(ls);
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
