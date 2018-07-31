package SS.last;

import java.util.Arrays;
import java.util.Scanner;

//백준 14501 퇴사
public class Retire_14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int [] day = new int[n+1];
		int [] price = new int[n+1];
		int [] dp = new int[n+1];

		Arrays.fill(dp, 0);

		for(int i=0 ; i<n ; i++) {
			day[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}

		for(int i=n-1 ; i>=0 ; i--) {
			int p = price[i];
			int d = day[i];

			if(i + d > n) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i+1], dp[i+d] + p);
			}
		}

		int max = 0;
		for(int val : dp)
			max = Math.max(val, max);

		System.out.println(max);

		sc.close();
	}
}