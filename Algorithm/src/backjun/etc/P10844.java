package backjun.etc;

import java.util.Scanner;

public class P10844 {
	static int MOD = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Ans = 0;
		int n = sc.nextInt();
		
		int [][] dp = new int[n+1][10];
		
		for(int i=1 ; i<=9 ; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2 ; i<=n ; i++) {
			for(int j=0; j<=9 ; j++) {
				dp[i][j] = 0;
				if(j-1 >= 0) dp[i][j] += dp[i-1][j-1];
				if(j+1 <= 9) dp[i][j] += dp[i-1][j+1];
				dp[i][j] %= MOD;
			}
		}
		
		
		
		for(int i=0 ; i<=9 ; i++) {
			Ans += dp[n][i];
			Ans %= MOD;
		}
		
		System.out.println(Ans);
		
		sc.close();
	}
}
