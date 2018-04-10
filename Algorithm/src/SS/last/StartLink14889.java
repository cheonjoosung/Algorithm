package SS.last;

import java.util.Scanner;

public class StartLink14889 {
	static int [][] map;
	static boolean [] visited;
	static int ans;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		ans = Integer.MAX_VALUE;
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1; j<=n ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0, 0);
		System.out.println(ans);
		sc.close();
	}
	
	public static void dfs(int v, int len) {
		if(n/2 == len) {
			cal();
		} else {
			for(int i=v+1; i<=n ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i, len+1);
				}
			}
		}
		
		visited[v] = false;
	}
	
	public static void cal() {
		int [] a = new int[n/2+1];
		int [] b = new int[n/2+1];
		
		int aIdx = 1, bIdx = 1;
		for(int i=1 ; i<=n ; i++) {
			if(visited[i]) a[aIdx++] = i;
			else b[bIdx++] = i;
		}
		
		int resA = getScore(a);
		int resB = getScore(b);
		ans = Math.min(ans, Math.abs(resA-resB));
	}
	
	public static int getScore(int [] a) {
		int res = 0;
		int len = n/2;
		
		for(int i=1; i<=len ; i++) {
			for(int j=i+1 ; j<=len ; j++) {
				res += map[a[i]][a[j]];
				res += map[a[j]][a[i]];
			}
		}
		
		return res;
	}
}
