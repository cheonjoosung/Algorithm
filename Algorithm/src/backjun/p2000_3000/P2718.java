package backjun.p2000_3000;

import java.util.Scanner;

public class P2718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i=0 ; i<testCase ; i++) {
			int n = sc.nextInt();
			int [] dp = new int[n+1];
			
			if(n == 1) System.out.println(1);
			else if(n == 2) System.out.println(5);
			else {
				dp[0] = 1; dp[1] = 1; dp[2] = 5;
				for(int j=3 ; j<=n ; j++) {
					dp[j] = dp[j-1] + 4*dp[j-2];
					for(int k=3; k<=j ; k++) {
						if(k%2 == 0) dp[j] += 3*dp[j-k];
						else dp[j] += 2*dp[j-k];
						
					}
				}
				System.out.println(dp[n]);
			}
			
			
		}
		sc.close();
	}
}
