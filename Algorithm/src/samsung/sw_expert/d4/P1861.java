package samsung.sw_expert.d4;

import java.util.Scanner;

//1861번 정사각형 방
public class P1861 {
	static int n, ans, num;
	static int [][] map;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();

			num = Integer.MAX_VALUE;
			ans = 0;
			map = new int[n][n];

			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++)
					map[i][j] = sc.nextInt();

			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					solve(i, j, map[i][j], 1);
				}
			}
			System.out.println("#" + tc + " " + num + " " + ans);

		}
		sc.close();
	}

	public static void solve(int x, int y, int s, int cnt) {
		for(int d=0 ; d<4 ; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if((map[nx][ny] - map[x][y]) != 1) continue;

			solve(nx, ny, s, cnt+1);
		}

		if(cnt == ans) {
			num = Math.min(num, s);
		} else if(cnt > ans) {
			ans = cnt;
			num = s;
		}
	}
}
