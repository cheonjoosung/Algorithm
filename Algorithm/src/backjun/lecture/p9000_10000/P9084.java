package backjun.lecture.p9000_10000;

import java.util.Scanner;

public class P9084 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i=0 ; i<testCase ; i++) {
			int coinCount = sc.nextInt();
			int [] coin = new int[coinCount+1];
			
			for(int j=1 ; j<=coinCount ; j++) coin[j] = sc.nextInt();
			
			int val = sc.nextInt();
			
			int [] dp = new int[val + 1];
			dp[0] = 1;
			for(int k=1 ; k<=coinCount ; k++) {
				//System.out.println("Start : " + k);
				for(int m=coin[k] ; m<=val ; m++) {
					dp[m] += dp[m-coin[k]];
					//System.out.print("dp["+m+"]"+ " : " +dp[m] + "  ");
				}
				//System.out.println();
			}
			
			System.out.println(dp[val]);
			
			
		}
		sc.close();
	}
}
