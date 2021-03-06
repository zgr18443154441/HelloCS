/*小明得到了n个石头，他想把这些石头分成若干堆，每堆至少有一个石头。他把这些石堆排在一条直线上，他希望任意相邻两堆的石头数都不一样。
小明最后的得分为石头数大于等于k的石堆数，问他最多能得多少分。
严格地，小明把n个石头分成了m堆，每堆个数依次为a1，a2，.....，am。要求满足：
1、ai≥1（1≤i≤m）
2、ai≠ai+1（1≤i＜m）
3、a1+a2+...+am＝n
小明想知道a1，a2.....，am中大于等于k的数最多能有多少个？
输入两个数n, k。（1≤k≤n≤109）
输出最大的得分*/

package algorithms;

import java.util.Scanner;

public class PutStone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int k = scan.nextInt();
			cal(n,k);
		}
	}
	
	public static void cal(int n,int k){
		if(n<k){
			System.out.println("0");
		}else if(n==k){
			System.out.println("1");
		}else{
			boolean turn = true;
			int num = 0;
			boolean index = true;
			while(turn){
				if(index){					
					n-= k;
					index = false;
				}else{
					n-= k+1;
					index = true;
				}
				if(n>=0){
					num++;
				}
				if(n<k){
					turn = false;
				}
			}
			System.out.println(num);
		}
	}

}
