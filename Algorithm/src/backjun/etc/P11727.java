package backjun.etc;

import java.util.Scanner;

public class P11727 {
	static int MOD = 10007;
	static int [] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = 2;
		int col = sc.nextInt();
		
		dp = new int[1001];
		
		dp[1] = 1; dp[2] = 3;
		
		for(int i=3; i<=col ; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % MOD;
		}
		
		System.out.println(dp[col]);
		
		sc.close();
	}
}
