package codeground;

import java.util.Scanner;

public class Sol35 {
	static long Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

			int n = sc.nextInt();
			int [] tree = new int[n];
			int [] laser = new int[n];

			for(int i=0; i<n ; i++) {
				tree[i] = sc.nextInt();
			}

			int minLaser = Integer.MAX_VALUE;
			
			for(int i=0; i<n ; i++) {
				laser[i] = sc.nextInt();
				if(minLaser + i> laser[i]) minLaser = laser[i] - i;
			}

			for(int j=0; j<n ; j++) {
				if(tree[j] - minLaser > 0) {
					Answer += (tree[j] - minLaser);
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
