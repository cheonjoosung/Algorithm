package backjun.etc;

import java.util.Scanner;

public class P1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [][] dp = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			int [] temp = new int[i+1];

			for(int j=0; j<=i ; j++) {
				temp[j] = sc.nextInt();
			}

			if(i==0) dp[0][0] = temp[0];
			else {
				for(int j=0 ; j<=i ; j++) {
					if(j == 0) {
						dp[i][j] = dp[i-1][j] + temp[j];
					} else if(j == i) {
						dp[i][j] = dp[i-1][j-1] + temp[j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1] + temp[j], dp[i-1][j] + temp[j]);
					}
				}
			}
		}

		int Ans = 0;
		for(int i=0 ; i<n ; i++) {
			Ans = Math.max(Ans, dp[n-1][i]);
		}
		System.out.println(Ans);


		sc.close();
	}
}
