package backjun.p11000_12000;

import java.util.Arrays;
import java.util.Scanner;

public class P11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		int [] dp = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0 ; i<n ; i++) {
			dp[i] = 1;
			for(int j=0 ; j<i ; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			//System.out.println(i + " " + dp[i]);
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
		
		sc.close();
	}
}
