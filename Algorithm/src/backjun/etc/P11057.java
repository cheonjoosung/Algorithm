package backjun.etc;

import java.util.Scanner;

public class P11057 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [][] dp = new int[1001][10];
		int Ans = 0;

		for(int i=0 ; i < 10 ; i++ )
			dp[1][i] = 1;

		//i자리수 j의 수로 끝나는 경우 2,0 이면 두자리이면서 마지막 자리가 0
		for(int i=2 ; i<=n ; i++) {
			for(int j=0 ; j<=9 ; j++) {
				for(int k=j; k<10 ; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;					
				}
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
