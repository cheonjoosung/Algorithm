package samsung.sw_expert.test_sample;

import java.util.Scanner;

//수영장
public class P1952 {
	static int n, k, ans;
	static int [] arr, cost ,dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = 12;
			arr = new int[n+1];
			cost = new int[4+1];
			dp = new int[n+1];
			ans = Integer.MAX_VALUE;

			for(int i=1 ; i<=4 ; i++) 
				cost[i] = sc.nextInt(); //1일, 1달, 3달, 1년 이용권

			for(int i=1 ; i<=12 ; i++) 
				arr[i] = sc.nextInt(); //1일, 1달, 3달, 1년 이용권

			for(int i=1 ; i<=12 ; i++) {
				if(i <= 2) {
					dp[i] = dp[i-1] + Math.min(cost[1] * arr[i], cost[2]);
				} else {
					dp[i] = Math.min(dp[i-1] + Math.min(cost[1] * arr[i], cost[2]), dp[i-3] + cost[3]);
				}
			}

			System.out.println("#" + test_case + " " + Math.min(cost[4], dp[12]));
		}

		sc.close();
	}
}
