/*有一条很长的队伍，队伍里面一共有n个人。所有的人分为三类：警察，小偷和普通人。将队伍里面的人从前到后由1到n编号，编号为i的人与编号为j的人的距离为i与j之差的绝对值。
每一个警察有一个能力值x，表示他能够监视与他距离不超过x的所有人，小偷被警察发现当且仅当他被一个或多个警察监视到。你知道在整条队伍中，一共有多少个小偷会被警察发现吗？

输入有两行，第一行一个数n(1<=n<=100000)，接下来一行有一个长度为n的字符串，依次表示队伍中的每一个人。
如果某一位是1-9的某个数字x，表示这一位是一个能力值为x的警察；如果某一位是字符X表示这一位是小偷；如果某一位是字符#表示这是一个普通人。输入保证不会出现其它字符。
输出一个数，整条队伍中被警察发现的小偷总数。 */
package algorithms;

import java.util.Scanner;

public class PoliceThief {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = Integer.parseInt(scan.nextLine());
			String people = scan.nextLine();
			cal(num,people);
		}
	}
	
	public static void cal(int num,String people){
		String[] list = new String[num];
		int thief_num = 0;
		for(int i=0;i<num;i++){
			list[i] = people.split("")[i];
			if(people.split("")[i].equals("X")){
				thief_num++;
			}
		}
		int[] thief_index = new int[thief_num];
		int index = 0;
		//记录小偷位置
		for(int i=0; i<num; i++){
			if(list[i].equals("X")){
				thief_index[index] = i;
				index++;
			}
		}
		int[] scaned = new int[thief_num];
		for(int i=0; i<thief_num; i++){
			scaned[i] = -1;
		}
		for(int i=0;i<num;i++){
			if(Character.isDigit(list[i].charAt(0))){
				int scope = Integer.parseInt(list[i]);
				for(int j=i-scope<0?0:i-scope;j<=(i+scope>=num?num-1:i+scope);j++){
					if(list[j].equals("X")){
						int message = has_scan(thief_index,scaned, j);
						if(message!=-1){
							scaned[message] = 0;
						}
					}
				}
			}
		}
		int scaned_num = 0;
		for(int i=0;i<thief_num;i++){
			if(scaned[i]==0){
				scaned_num++;
			}
		}
		System.out.println(scaned_num);
	}
	
	public static int has_scan(int[] thief_index,int[] scaned,int index){
		int has_scan = -1;
		for(int i=0;i<thief_index.length;i++){
			if(thief_index[i]==index&&scaned[i]==-1){
				has_scan = i;
			}
		}
		return has_scan;
	}

}
