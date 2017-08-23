package codeground;

import java.util.Scanner;

//Codeground 31번 프리랜서
public class Sol31 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			
			int [] p = new int[n];
			int [] q = new int[n];
			
			int [] res = new int[n];
			
			for(int i = 0 ; i < n ; i++)
				p[i] = sc.nextInt();
			
			for(int i = 0 ; i < n ; i++)
				q[i] = sc.nextInt();			
		
			res[0] = Math.max(p[0], q[0]);
			res[1] = Math.max(res[0] + p[1], q[1]);
			
			for(int i = 2 ; i < n ; i++) {
				//res[i] = q[i-1] + res[i-2];
				//res[i] = p[i-1] + res[i-1];
				
				res[i] = Math.max(q[i] + res[i-2], p[i] + res[i-1]);
				//System.out.print(res[i] + "\n");
			}
			
			Answer = res[n-1];
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
