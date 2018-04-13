package SS.sw_expert.test_sample;

import java.util.Scanner;

//디저트 카페
public class P2105 {
	static int N, ans, sx, sy;
	static int [][] map;
	static boolean [] visited;

	static int dy[] = {1,1,-1,-1};
	static int dx[] = {1,-1,-1,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();

			ans = -1;
			map = new int[N][N];
			//visited = new boolean[N][N];
			visited=new boolean[101];

			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					//dir 0 : 우상, 1 : 우하, 2 : 좌하, 3 : 좌상
					sx = i;
					sy = j;
					visited[map[i][j]] = true;
					dfs(i, j, 1, 0); //초기는 항상 1
					visited[map[i][j]] = false;
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}

		sc.close();
	}

	public static void dfs(int x, int y, int cnt, int dir) {
		if(dir == 4) return;
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		 if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
	            if(nx==sx&&ny==sy) {
	                ans = Math.max(ans, cnt);
	            }
	             
	            if(!visited[map[nx][ny]]) {
	            	visited[map[nx][ny]] = true;
	                go(nx, ny, (cnt + 1), dir);
	                go(nx, ny, (cnt + 1), (dir + 1));
	                visited[map[nx][ny]] = false;
	            }
	        }
	}
}
