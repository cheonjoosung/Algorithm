package samsung.last;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dust_17144 {
	static int row, col, ans, time;
	static int [][] map;
	static int x1, x2, y1, y2;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();
		time = sc.nextInt();

		ans = 0;
		map = new int[row][col];
		x1 = -1; x2 = -1; y1 = -1; y2 = -1;

		for(int i=row-1 ; i>=0; i--) {
			for(int j=0 ; j<col; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					if(x1 == -1) { x1 = i; y1 = j; }
					else { x2 = i; y2 = j; }
				}
			}
		}

		Queue<Dust> q = new LinkedList<>();
		for(int t=0 ; t<time ; t++) {
			/*
			 * 1.먼지 퍼트리기
			 * 2.공기청정기 틀기
			 */
			//spread();
			for(int i=row-1 ; i>=0 ; i--)
				for(int j=0 ; j<col ; j++)
					if(map[i][j] != -1 && map[i][j] != 0)
						q.add(new Dust(i, j, map[i][j]));

			while(!q.isEmpty()) {
				Dust d = q.poll();

				int x = d.x;
				int y = d.y;
				int c = d.c;
				int add = d.c/5;

				for(int dir=0 ; dir<4 ; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny] !=-1) {
						map[nx][ny] += add;
						map[d.x][d.y] -= add;					
					}
				}
			}

			clean();
		}

		//print();
		for(int [] tempArr : map)
			for(int tempVal : tempArr)
				if(tempVal != -1) ans += tempVal;

		System.out.println(ans);

		sc.close();
	}

	public static void clean() {
		//위에꺼
		for(int i=x1+1 ; i<=row-2 ; i++)
			map[i][y1] = map[i+1][y1];

		for(int j=y1 ; j<=col-2 ; j++)
			map[row-1][j] = map[row-1][j+1];

		for(int i=row-1 ; i>=x1+1 ; i--)
			map[i][col-1] = map[i-1][col-1];

		for(int j=col-1 ; j>=y1+1 ; j--)
			map[x1][j] = map[x1][j-1];

		map[x1][y1+1] = 0;

		//아래꺼
		for(int i=x2-1 ; i>=1 ; i--)
			map[i][y2] = map[i-1][y2];

		for(int j=y2 ; j<=col-2 ; j++)
			map[0][j] = map[0][j+1];

		for(int i=0 ; i<=x2-1 ; i++)
			map[i][col-1] = map[i+1][col-1];

		for(int j=col-1 ; j>=y2+1 ; j--)
			map[x2][j] = map[x2][j-1];

		map[x2][y2+1] = 0;
	}

	public static void print() {
		for(int i=row-1 ; i>=0 ; i--) {
			for(int j=0 ; j<col ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Dust {
	int x; int y; int c;
	Dust(int x, int y, int c) {
		this.x = x; this.y = y; this.c = c;
	}
}