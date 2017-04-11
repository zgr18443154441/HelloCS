/*
 * 数组中有n个元素，依次将数组中的元素取出并插入到已有排序的适当位置，共须插入n-1次数据，每次插入须比较1~n-1组元素，移动0~n个元素
 * tips：可将比较和移动的步骤合并，从最右侧的元素比较起，满足条件直接交换（借鉴冒泡排序思想）
 */

package algorithms;

import data_structures.list.ListStruct;
import self_exception.TypeSelectException;

public class InsertSort {
	/**
	 * 1:升序 2:降序
	 * @param ls
	 * @param type
	 * @return
	 */
	public static ListStruct sort(ListStruct ls,int type){
		int temp = 0;
		int index = -1;
		switch (type) {
		case 1:
			for(int i=1;i<=ls.max_index();i++){
				for(int j=0;j<i;j++){
					if((int)ls.getElem(j)>(int)ls.getElem(i)){
						index = j;
						break;
					}
				}
				if(index!=-1){
					temp = (int)ls.getElem(i);
					for(int j=i;j>index;j--){
						ls.setElem(j, ls.getElem(j-1));
					}
					ls.setElem(index, temp);
					System.out.println(ls);
					index = -1;	//标识是否需要重新排序的索引每次需要更新
				}
			}
			break;
		case 2:
			for(int i=1;i<=ls.max_index();i++){
				for(int j=0;j<i;j++){
					if((int)ls.getElem(j)<(int)ls.getElem(i)){
						index = j;
						break;
					}
				}
				if(index!=-1){
					temp = (int)ls.getElem(i);
					for(int j=i;j>index;j--){
						ls.setElem(j, ls.getElem(j-1));
					}
					ls.setElem(index, temp);
					System.out.println(ls);
					index = -1;	//标识是否需要重新排序的索引每次需要更新
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
