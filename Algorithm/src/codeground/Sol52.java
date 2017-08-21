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
					arr[i][j] = sc.nextInt();
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
