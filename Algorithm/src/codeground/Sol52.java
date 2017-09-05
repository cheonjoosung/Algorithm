package codeground;

import java.util.Scanner;

public class Sol52 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			int [][] arr = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					arr[j][i] = sc.nextInt();
				}
			}
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 1 ; j < n ; j++) {
					arr[j][i] += arr[j-1][i];
				}
			}
			
			int rowSum = 0;
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = i ; j < n ; j++) {
					int partSum = 0;
					
					for(int k = 0 ; k < n ; k++) {
						if(i == 0) {
							rowSum = arr[j][k];
						} else {
							rowSum = arr[j][k] - arr[i-1][k];							
						}
						partSum = Math.max(partSum, 0) + rowSum;
						//System.out.println(rowSum + " , " + partSum);
						Answer = Math.max(Answer, partSum);
						System.out.println(k + " " + rowSum);
						/*
						 * rowSum = i 는 시작점  j = (i,k) - ( 1과 2번째 row -> 1 
						 * partSum = rowSum + partSum 을 합치는거지.  
						 * k 는 위로 몇줄까지 더할것인지..... 
						 */
					}
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
