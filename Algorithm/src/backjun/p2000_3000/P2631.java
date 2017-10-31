package backjun.p2000_3000;

import java.util.Scanner;

public class P2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n+1];
		int [] dp = new int[n+1];
		
		for(int i=1 ; i<=n ; i++) arr[i] = sc.nextInt();
		
		for(int i=1 ; i<=n ; i++) {
			dp[i] = 1;
			for(int j=1; j<i ; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int Ans = 0;
		for(int val : dp) Ans = Math.max(Ans, val);
		
		System.out.println(n - Ans);
		
		sc.close();
	}
}
