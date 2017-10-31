package backjun.p11000_12000;

import java.util.Arrays;
import java.util.Scanner;

public class P11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int [] arr = new int[num];
		int [] dp = new int[num];
		Arrays.fill(dp, 1);
		
		for(int i=0 ; i<num ; i++)
			arr[i] = sc.nextInt();
		
		for(int i=1 ; i<num ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int Ans = 0;
		for(int val : dp)
			Ans = Math.max(Ans,  val);
		
		System.out.println(Ans);
		
		sc.close();
	}
}
