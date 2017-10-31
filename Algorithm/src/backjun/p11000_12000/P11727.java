package backjun.p11000_12000;

import java.util.Scanner;

public class P11727 {
	static int MOD = 10007;
	static int [] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		
		dp = new int[col+1];
		
		dp[0] = 1; dp[1] = 1;
		
		for(int i=2; i<=col ; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % MOD;
		}
		
		System.out.println(dp[col]);
		
		sc.close();
	}
}
