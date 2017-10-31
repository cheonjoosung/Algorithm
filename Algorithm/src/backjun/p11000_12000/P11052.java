package backjun.p11000_12000;

import java.util.Scanner;

public class P11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int [] price = new int[num+1];
		int [] dp = new int[num+1];
		
		for(int i=1 ; i<=num ; i++) 
			price[i] = sc.nextInt();
		
		for(int i=1; i<=num ; i++) 
			for(int j=1 ; j<=i ; j++) 
				dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
		
		System.out.println(dp[num]);
		
		sc.close();
	}
}
