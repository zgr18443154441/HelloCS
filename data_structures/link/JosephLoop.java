package data_structures.link;

import java.util.Scanner;
/**
 * 约瑟夫问题
 * 41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止
 * 求最后剩的两个人
 * @author 张国荣
 *
 */
public class JosephLoop {
	private static Scanner scan;
	/**
	 * 链表内部类（无头结点）
	 * @author 张国荣
	 *
	 */
	static class Chain{
		private Chain next;
		private Object data;
		public Chain(Object data){
			this.data = data;
			this.next = this;
		}
	}
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			int space = scan.nextInt();
			Chain c = initLoop(num);
			cal(space,c);
		}
	}
	/**
	 * 初始化循环链表
	 * @param num
	 * @return
	 */
	public static Chain initLoop(int num){
		Chain c = new Chain(1);
		for(int i=2;i<=num;i++){
			Chain temp = c;
			while(temp.next!=c){
				temp = temp.next;
			}
			Chain b =  new Chain(i);
			b.next = c;
			temp.next = b;
		}
		return c;
	}
	/**
	 * 循环链表并运算
	 * @param space
	 * @param c
	 */
	public static void cal(int space,Chain c){
		int index = 1;
		while(true){
			c = c.next;
			index++;
			if(index==space-1){	//判断是否应该删减
				c.next = c.next.next;
				index = 0;
			}
			if(c.next.next==c){	//判断剩余结点数是否满足要求
				System.out.println(c.next.data);
				System.out.println(c.data);
				break;
			}
		}
	}
}
