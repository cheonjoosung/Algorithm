package backjun.lecture.p11000_12000;

import java.util.Scanner;

public class P11048 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int [][] dp = new int[m+1][n+1];
		int [][] arr = new int[m+1][n+1];

		for(int i=1 ; i<=n ; i++)
			for(int j=1 ; j<=m ; j++)
				arr[j][i] = sc.nextInt();
		
		for(int i=1; i<=n ; i++)
			for(int j=1; j<=m ; j++)
				dp[j][i] = Math.max(Math.max(dp[j-1][i], dp[j][i-1]), dp[j-1][i-1]) + arr[j][i];

		System.out.println(dp[m][n]);
	}
}