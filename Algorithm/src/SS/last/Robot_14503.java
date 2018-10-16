package SS.last;

import java.util.Scanner;

//백준 14503 로봇청소기  
public class Robot_14503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();

		int [][] map = new int[row][col];

		int [] dx = {1, 0, -1, 0};
		int [] dy = {0, 1, 0, -1};
		int cnt = 0;

		for(int i=row-1 ; i>=0 ; i--)
			for(int j=0 ; j<col ; j++)
				map[i][j] = sc.nextInt();

		x = (row-1) - x;
		while(true) {
			if(map[x][y] == 0) {
				cnt++;
				map[x][y] = 2;
			}

			boolean back = true;
			for(int i=0 ; i<4 ; i++) {
				d = (d + 4 - 1) % 4;
				int nx = x + dx[d];
				int ny = y + dy[d];

				if(map[nx][ny] == 1 || map[nx][ny] == 2) continue;

				back = false;
				x = nx;
				y = ny;
				break;
			}

			if(back) {
				//후퇴 가능성 파악해야함
				int nx = x + dx[(d+2)%4];
				int ny = y + dy[(d+2)%4];

				if(map[nx][ny] == 1) break;
				else {
					x = nx;
					y = ny;
				}
			}
		}

		System.out.println(cnt);
		sc.close();
	}
}