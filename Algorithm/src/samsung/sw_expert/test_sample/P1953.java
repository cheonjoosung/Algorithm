package samsung.sw_expert.test_sample;

import java.util.Arrays;
import java.util.Scanner;

//탈주범 검거
public class P1953 {
	static int ans, col, row, total;
	static int [][] map;
	static int [] dx = {0, -1, 0 , 1};
	static int [] dy = {1, 0, -1, 0};
	static boolean [][] visited;
	static boolean [][] ret;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			row = sc.nextInt();
			col = sc.nextInt();

			int x = sc.nextInt();
			int y = sc.nextInt();
			total = sc.nextInt();
			ans = 0;

			map = new int[row][col];
			visited = new boolean[row][col];
			ret = new boolean[row][col]; 
			/* ret 과 visited 를 따로 두어야 하는 이유
			 * 5 6
			 * 4 1 의 경우 존재 돌고 돌아 1에 와도 시간이 남으면 더갈수있는데 6에서 먼저 와버리는 순간 멈춤
			 */

			for(boolean [] temp : visited)
				Arrays.fill(temp, false);
			
			for(boolean [] temp : ret)
				Arrays.fill(temp, false);

			for(int i=row-1 ; i>=0 ; i--)
				for(int j=0 ; j<col ; j++)
					map[i][j] = sc.nextInt();

			dfs( (row-1)-x , y, 1);

			for(int i=0 ; i<row ; i++) {
				for(int j=0 ; j<col ; j++) {
					if(ret[i][j] == true) {
						ans++;
					}
				}
			}

			System.out.println("#" + test_case + " " + ans + " ");
		}

		sc.close();
	}

	public static void dfs(int x, int y, int t) {


		if(total < t) return;
		ret[x][y] = true;

		int cur = map[x][y];

		for(int i=0 ; i<4 ; i++) {
			if(i == 0 && (cur == 2 || cur == 6 || cur == 7) ) continue;
			if(i == 1 && (cur == 3 || cur == 4 || cur == 7) ) continue;
			if(i == 2 && (cur == 2 || cur == 4 || cur == 5) ) continue;
			if(i == 3 && (cur == 3 || cur == 5 || cur == 6) ) continue;
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if(visited[nextX][nextY] || map[nextX][nextY] == 0 || cur == 0) continue;

			int nxt = map[nextX][nextY];
			
			if(i == 0 && (nxt == 2 || nxt == 4 || nxt ==5) ) continue;
			if(i == 1 && (nxt == 3 || nxt == 5 || nxt ==6) ) continue;
			if(i == 2 && (nxt == 2 || nxt == 6 || nxt ==7) ) continue;
			if(i == 3 && (nxt == 3 || nxt == 4 || nxt ==7) ) continue;
			
			visited[nextX][nextY] = true;
			dfs(nextX, nextY, t+1);
			visited[nextX][nextY] = false;

		}
	}
}
