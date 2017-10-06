package codeground;

import java.util.Arrays;
import java.util.Scanner;

public class Sol36 {
	static long Answer;
	
	static int [][] dist;
	static int [][] dp;
	static int [] arr;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			int trash = sc.nextInt();
		
			arr = new int[n+1];
			dist = new int[501][501];
			dp = new int[501][501];
			
			for(int i=1; i<=n ; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			
			for(int i=1 ; i<=n ; i++) {  
				for(int j=i ; j<=n ; j++) {
					int mid = (i+j) / 2;
					for(int k=i ; k<=j ; k++) {
						dist[i][j] += Math.abs(arr[k] - arr[mid]); // i -> j 거리
					}
				}
			}
			
			for (int i = 0; i <= n; i++){
				for (int j = 0; j <= trash; j++){
					dp[i][j] = 987_654_321; 
				}
			}
			
			dp[0][0] = 0;
			
			for(int i=1 ; i<=n ; i++) {
				for(int j=1 ; j<=trash ; j++) {
					
					for(int k=1 ; k<=i ; k++) {
						if(dp[i - k][j - 1] == 987_654_321) continue;
						
						//i-k까지 j-1개 있고 i-k+1부터 i까지 1개 있을 때 k를 변화시켜가며 최소값 구함
						if(dp[i][j] > dp[i-k][j-1] + dist[i-k+1][i]) 
							dp[i][j] = dp[i-k][j-1] + dist[i-k+1][i];
					}
				}
			}
			
			Answer = dp[n][trash];
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
		
		sc.close();
	}
	
	public static void find(int start, int trash, int n, int [] arr) {
		if(n <= trash) {
			Answer = 0;
		} else {
			
		}
	}
}
