package samsung.sw_expert.d3;

import java.util.Arrays;
import java.util.Scanner;

public class P2814 {
	static int ans, n;
	static boolean [] visited;
	static int [][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			ans = 1;
			arr = new int[n+1][n+1];
			visited = new boolean[n+1];

			for(int [] temp : arr) 
				Arrays.fill(temp, 0);
			
			if(n == 1) System.out.println("#" + tc + " " + ans);
			else {
				for(int i=0 ; i<m ; i++) {
					int v1 = sc.nextInt();
					int v2 = sc.nextInt();
					
					arr[v1][v2] = 1;
					arr[v2][v1] = 1;
				}
				
				for(int i=1 ; i<=n ; i++) {
					Arrays.fill(visited, false);
					dfs(i, 1);
				}
				
				
				System.out.println("#" + tc + " " + ans);
			}

		}

		sc.close();
	}
	
	public static void dfs(int v, int cnt) {
		visited[v] = true;
		
		ans = Math.max(cnt, ans);
		
		for(int i=1 ; i<= n ; i++) {
			if(!visited[i] && arr[v][i] == 1) {
				dfs(i, cnt+1);
				visited[i] = false;
			}
		}
	}

}
