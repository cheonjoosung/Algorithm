package backjun.p2000_3000;

import java.util.Scanner;

public class P2468 {
	static int n, ans;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		ans = 1;
		map = new int[n][n];
		visited = new boolean[n][n];

		int max = 0;

		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}

		for(int idx=1 ; idx<max ; idx++) {
			int cnt = 0;
			visited = new boolean[n][n];
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(map[i][j] > idx && !visited[i][j]) {
						cnt++;
						dfs(i, j, idx);
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);

		sc.close();
	}

	public static void dfs(int x, int y, int h) {		
		visited[x][y] = true;
		
		for(int i=0 ; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if(map[nx][ny] <= h) continue;
			if(visited[nx][ny]) continue;
			
			dfs(nx, ny, h);
		}
	}
}