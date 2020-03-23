package samsung.sw_expert.d3;

import java.util.Scanner;

//5642번 [Professional] 합 
public class P5642 {
	static int ans, n;
	static int [] arr, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			
			ans = Integer.MIN_VALUE;
			arr = new int[n];
			dp = new int[n+1];
			
			for(int i=0 ; i<n ; i++) {
				arr[i] = sc.nextInt();
				ans = Math.max(ans, arr[i]);
			}
			
			for(int i=0 ; i<n ; i++) {
				dp[i+1]= Math.max(dp[i] + arr[i], arr[i]);
			}

			for(int val : dp) 
				ans = Math.max(ans, val);
			
			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}
}
