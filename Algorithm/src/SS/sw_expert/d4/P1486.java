package SS.sw_expert.d4;

import java.util.Scanner;

//1486번 장훈이의 높은 선반
public class P1486 {
	static int n, b, ans;
	static int [] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			b = sc.nextInt();
			
			ans = Integer.MAX_VALUE;
			arr = new int[n];
			
			for(int i=0 ; i<n ; i++) 
				arr[i] = sc.nextInt();
			
			dfs(0, 0);				
				
			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}
	
	public static void dfs(int idx, int height) {
		if(idx == n) {
			if(height >= b) 
				ans = Math.min(ans, height-b);			
			return;
		}
		dfs(idx+1, height + arr[idx]);
		dfs(idx+1, height);
	}
}