package codeground;

import java.util.Scanner;

//CodeGround 26번 징검다리 http://www.qukihub.com/post/scpc2016-1-java
public class Sol26 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int stone = sc.nextInt();
			int jump = sc.nextInt();
			int bombSize = sc.nextInt();
			int [] bomb = new int[bombSize];
			
			for(int i=0; i<bombSize ; i++) {
				bomb[i] = sc.nextInt();
			}
			

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
