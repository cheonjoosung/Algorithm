package backjun.p2000_3000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
	static int row, col;
	static int [][] map;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	static boolean [][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();

		map = new int[row][col];
		visited = new boolean[row][col];

		for(int i=0 ; i<row ; i++) {
			String s = sc.next();
			for(int j=0 ; j<col; j++)
				map[i][j] = s.charAt(j)-'0';
		}

		visited[0][0] = true;
		bfs();
		System.out.println(map[row-1][col-1]);
		sc.close();
	}

	public static void bfs() {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0, 0));

		while(!q.isEmpty()) {
			Dot d = q.poll();

			for(int i=0 ; i<4 ; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];

				if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
				if(map[nx][ny] == 0 || visited[nx][ny]) continue;

				q.add(new Dot(nx, ny));
				map[nx][ny] = map[d.x][d.y] + 1;
				visited[nx][ny] = true;
			}
		}
	}
}

class Dot {
	int x; int y;
	Dot(int x, int y) {
		this.x=x ; this.y=y;
	}
}