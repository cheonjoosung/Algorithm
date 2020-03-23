package samsung.sw_expert.d4;

import java.util.Scanner;

//1865번 동철이의 일 분배
public class P1865 {
	static int n, num;
	static double ans;
	static double [][] a;
	static boolean [] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();

			num = Integer.MAX_VALUE;
			ans = 0;
			a = new double[n][n];
			visited = new boolean[n];  

			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++)
					a[i][j] = sc.nextDouble() / 100;

			solve(0, 100);
			System.out.println("#" + tc + " " + String.format("%.6f", ans));

		}
		sc.close();
	}

	public static void solve(int idx, double total) {
		if(ans >= total) {
			return;
		}
		
		if(idx == n) {
			ans = total;
			return;
		}
		
		for(int j=0 ; j<n ; j++) {
			if(visited[j]) continue;
			visited[j] = true;
			solve(idx+1, total*a[idx][j]);
			visited[j] = false;
		}
	}
}
