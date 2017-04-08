/*	三子棋是一种大家熟知的游戏，几乎所有人都会玩。游戏规则相当简单，两人依次在一个3X3棋盘格上下棋，一个人画叉，另一个人画圈。
  	任何一个人画的三个记号如果形成构成一条水平、垂直或对角的直线则获胜，游戏结束。画叉的人先开始游戏，如果所有的棋盘格都画满了但两人都不能获胜，则游戏平局结束。
	游戏在一个3X3的棋盘上进行，每个棋盘格单元处于空白、画叉或画圈状态中的一种，你的任务是确定下一轮由谁下棋:
	1：轮到先手下棋；
	2：轮到后手下棋；
	或者是判定游戏的状态：
	x：给定的棋局不是合法的棋局；
	1 won：先手获胜；
	2 won：后手获胜；
	draw：平局；
	
	小东对棋类游戏很有研究，这一次三子棋比赛中，她被邀请作为评判，为了提携后进，她请你帮忙判定。
	 	
	 	样例输入		样例输出
		X0X			2
		.0.
		.X.
*/

package algorithms;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuffer stringBuffer = new StringBuffer();
		int index = 0;
		while(scan.hasNext()){
			stringBuffer.append(scan.nextLine());
			index++;
			if(index==3){
				cal(stringBuffer.toString());
				stringBuffer = new StringBuffer();
				index = 0;
			}
		}
	}
	
	public static void cal(String input){
		String[][] state = new String[3][3];
		int index = 0;
		for(int i=0; i<3; i++){
			for(int j=0 ; j<3; j++){
				state[i][j] = input.split("")[index];
				index++;
			}
		}
		//合法性检查
		boolean legal = true;
		int first_num = 0,second_num=0;
		for(int i=0; i<3; i++){
			for(int j=0 ; j<3; j++){
				if(state[i][j].equals("x")){
					first_num++;
				}else if(state[i][j].equals("0")){
					second_num++;
				}
			}
		}
		//1.旗子数量差的合法性区间[0,1]
		if(first_num-second_num<0||first_num-second_num>1){
			System.out.println("x");
			return;
		}
		//2.不能同时胜利
		if(isWon(state,"x")&&isWon(state,"0")){
			System.out.println("x");
			return;
		}
		//3.后手已获胜前提下先手无需再下
		if(first_num!=second_num&&isWon(state,"0")){
			System.out.println("x");
			return;			
		}
		//游戏是否结束检查
		if(isWon(state,"x")){
			System.out.println("1 won");
			return;
		}else if(isWon(state,"0")){
			System.out.println("2 won");
			return;			
		}else if(first_num+second_num==9){
			System.out.println("draw");
			return;		
		}
		//判断轮次
		if(first_num==second_num){
			System.out.println("1");
			return;			
		}else{
			System.out.println("2");
			return;			
		}
	}
	
	public static boolean isWon(String[][] state,String who){
		boolean won = false;
		//1.一横
		if(state[0][0].equals(state[0][1])&&state[0][0].equals(state[0][2])&&state[0][0].equals(who)){
			won = true;
		}
		//2.二横
		if(state[1][0].equals(state[1][1])&&state[1][0].equals(state[1][2])&&state[1][0].equals(who)){
			won = true;
		}
		//3.三横
		if(state[2][0].equals(state[2][1])&&state[2][0].equals(state[2][2])&&state[2][0].equals(who)){
			won = true;
		}
		//4.一竖
		if(state[0][0].equals(state[1][0])&&state[0][0].equals(state[2][0])&&state[0][0].equals(who)){
			won = true;
		}
		//5.二竖
		if(state[0][1].equals(state[1][1])&&state[0][1].equals(state[2][1])&&state[0][1].equals(who)){
			won = true;
		}
		//6.三竖
		if(state[0][2].equals(state[1][2])&&state[0][2].equals(state[2][2])&&state[0][2].equals(who)){
			won = true;
		}
		//7.左斜
		if(state[0][0].equals(state[1][1])&&state[0][0].equals(state[2][2])&&state[0][0].equals(who)){
			won = true;
		}
		//8.右斜
		if(state[0][2].equals(state[1][1])&&state[0][2].equals(state[2][0])&&state[0][2].equals(who)){
			won = true;
		}
		return won;
	}
}
