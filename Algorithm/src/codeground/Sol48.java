package codeground;

import java.util.Scanner;

public class Sol48 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int forward = sc.nextInt();
			int backward = sc.nextInt();
			int distance = sc.nextInt();
			
			double a = distance - backward;
			double b = forward - backward;
			
			double res = a/b;
			
			//System.out.println(a + " , " + b + " ," + res);
			
			if(Math.floor(res) - res == 0) {
				Answer = (int) res;
			} else {
				Answer = (int) res;
				Answer++;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
