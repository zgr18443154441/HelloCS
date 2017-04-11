/**
 * 按序找到数组中最小的k个数（完美世界2017秋招真题）
 * 对于一个无序数组，数组中元素为互不相同的整数，请返回其中最小的k个数，顺序与原数组中元素顺序一致。
 * 输入
 * 第一行为数组的长度n，需要返回的数目k，n >= k
 * 接下来n行为数组的n个元素，每行为一个整数
 * 输出
 * 输出为k行，每行为一个整数
 * 
 * 我的思路：同时用两个数组，保存原输入数据及其索引顺序，对保存数据的数组进行排序，同时将排序的操作在保存索引的数组中也执行一遍
 * 			此时通过比较保存索引的数组中前要求输出个数的数据大小顺序，输出保存数据的数组中的数据
 */

package ac;

import java.util.Scanner;

public class ArrayMinNumber {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int k = scan.nextInt();
			int[] array = new int[n];
			for(int i=0;i<n;i++){
				array[i] = scan.nextInt();
			}
			int[] index = new int[n];
			for(int i=0;i<n;i++){
				index[i] = i;
			}
			insert_sort(array, index,k);
		}
	}
	
	public static void insert_sort(int[] array,int[] num_index,int k){
		int temp = 0;
		int temp_index = -1;
		int index = -1;
		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[j]>array[i]){
					index = j;
					break;
				}
			}
			if(index!=-1){
				temp = array[i];
				temp_index = num_index[i];
				for(int j=i;j>index;j--){
					array[j] = array[j-1];
					num_index[j] = num_index[j-1];
				}
				array[index] = temp;
				num_index[index] = temp_index;
				index = -1;
			}
		}
		output(array, num_index,k);
	}
	
	public static void output(int[] array,int[] num_index,int k){
		//要输出的数的在array中的索引
		for(int i=0;i<k;i++){
			int index = -1;
			int min = -1;
			for(int j=0;j<k;j++){
				if(num_index[j]!=-1){
					min = num_index[j];
					index = j;
					break;
				}
			}
			for(int j=1;j<k;j++){
				if(num_index[j]!=-1&&num_index[j]<min){
					min = num_index[j];
					index = j;
				}				
			}
			num_index[index] = -1;
			System.out.println(array[index]);
		}
	}
}
