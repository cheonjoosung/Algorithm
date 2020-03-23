package samsung.sw_expert.d3;

import java.util.Scanner;

public class P2817 {
	static int ans, n, sum;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;
			
			n = sc.nextInt();
			arr = new int[n];
			sum = sc.nextInt();
			
			for(int i=0 ; i<n ; i++)
				arr[i] = sc.nextInt();
			
			for(int i=0 ; i<n ; i++) 
				dfs(i, arr[i]);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	public static void dfs(int i, int value) {
		if(value == sum) {
			ans++;
		} else if(value > sum) {
			return;
		} else {
			for(int j=i+1 ; j<n ; j++) {
				dfs(j, value+arr[j]);
			}
		}
	}
}
