package backjun.etc;

import java.util.Scanner;

public class P11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int [] price = new int[num+1];
		int [] dp = new int[num+1];
		
		for(int i=1 ; i<=num ; i++) {
			price[i] = sc.nextInt();
		}
		
		dp[1] = price[1];
		
		for(int i=2 ; i<=num ; i++) {
			dp[i] = price[i];
			for(int j=i-1 ; j>=0 ; j--) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		
		System.out.println(dp[num]);
		
		sc.close();
	}
}
