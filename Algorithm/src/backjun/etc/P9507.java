package backjun.etc;

import java.math.BigInteger;
import java.util.Scanner;

public class P9507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i=0 ; i<n ; i++) 
			arr[i] = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) {
			if(arr[i] == 0 || arr[i] == 1) System.out.println(1);
			else if(arr[i] == 2) System.out.println(2);
			else if(arr[i] == 3) System.out.println(4);
			else {
				BigInteger [] dp = new BigInteger[arr[i]+1];
				dp[0] = BigInteger.ONE;
				dp[1] = BigInteger.ONE;
				dp[2] = BigInteger.valueOf(2);
				dp[3] = BigInteger.valueOf(4);
				
				for(int j=4 ; j <= arr[i] ; j++) {
					dp[j] = (dp[j-1].add(dp[j-2]).add(dp[j-3])).add(dp[j-4]);
				}
				System.out.println(dp[arr[i]]);
			}
		}
		sc.close();
	}
}
