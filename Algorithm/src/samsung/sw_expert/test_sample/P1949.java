package samsung.sw_expert.test_sample;

import java.util.Scanner;

//등산로 조성
public class P1949 {
		static int n, k, ans;
		static int [][] map;
		static int [] dx = {0, -1, 0, 1};
		static int [] dy = {1, 0, -1, 0};
		static boolean [][] visited;
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			
			for(int test_case = 1; test_case <= T; test_case++)
			{
				n = sc.nextInt();
				k = sc.nextInt(); //깎는 높이
				
				map = new int[n][n];
				ans = 1;
				int max = -1;
				
				for(int i=0 ; i<n ; i++) {
					for(int j=0 ; j<n ; j++) {
						map[i][j] = sc.nextInt();
						max = Math.max(map[i][j], max);
					}
				}
				
				for(int i=0 ; i<n ; i++) {
					for(int j=0 ; j<n ; j++) {
						if(max == map[i][j]) {
							visited = new boolean[n][n];
							dfs(i, j, 1, false);
						}
					}
				}
				
				System.out.println("#" + test_case + " " + ans);
			}
		}
		
		public static void dfs(int x, int y, int cnt, boolean isDip) {
			visited[x][y] = true;
			
			ans = Math.max(ans, cnt);
			
			for(int i=0 ; i<4 ; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				
				if(nextX >= n || nextX<0 || nextY>= n || nextY<0) continue;
				if(visited[nextX][nextY]) continue;
				
				if(map[x][y] > map[nextX][nextY]) {
					dfs(nextX, nextY, cnt+1, isDip);
				} else {
					for(int m=1 ; m <= k ; m++) {
						if(map[x][y] > map[nextX][nextY] - m && !isDip) {
							map[nextX][nextY] -= m;
							isDip = true;
							dfs(nextX, nextY, cnt+1, isDip);
							isDip = false;
							map[nextX][nextY] += m;
						}
					}
				}
				
				visited[nextX][nextY] = false;
			}
		}
}
