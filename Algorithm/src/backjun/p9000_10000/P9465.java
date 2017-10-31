package backjun.p9000_10000;

import java.util.Scanner;

public class P9465 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int textCase = sc.nextInt();

		while(textCase-- > 0) {
			int n = sc.nextInt();		
			long [][] arr = new long[n+1][2];

			for(int i=0 ; i<2 ; i++)
				for(int j=1 ; j<=n ; j++) 
					arr[j][i] = sc.nextLong();
				
			//d[N][S] : XX , 1 : OX, 2: XO 0로우에서 칼럼 0과 1을 선택한 상태

			
			long [][] dp = new long[n+1][3];
			for(int i=1 ; i<=n ; i++) {
				dp[i][0] = Math.max(dp[i-1][0] , Math.max(dp[i-1][1], dp[i-1][2]));
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + arr[i][0];
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][1];
			}

			long ans = 0;
			ans = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
			System.out.println(ans);
		}

		sc.close();
	}
}

