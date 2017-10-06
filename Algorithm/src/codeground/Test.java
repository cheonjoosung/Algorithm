package codeground;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int [][] arr = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int [][] arr2 = {{0,0,1,1},{1,1,1,1}};

		System.out.println(solution(arr) + "  11 ");
		System.out.println(solution(arr2) + "  22 ");
	}


	public static int solution(int [][]board)
	{
		int answer = 0;

		for(int i=1 ; i < board.length ; i++) {
			for(int j=1 ; j< board[i].length ; j++) {
				System.out.println(i + " , " + j);
				if(board[i][j] == 0) continue;
				else {
					if(board[i-1][j-1] == 0) {
						board[i][j] = 1;
					} else {
						if(board[i-1][j] > 0 && board[i][j-1] > 0){
							board[i][j] = Math.min(board[i-1][j], board[i][j-1])+1;
						} else {
							board[i][j] = 1;
						}
					}
				}
				
				answer = Math.max(board[i][j], answer);
			}
		}
		
		return answer*answer;
	}
}