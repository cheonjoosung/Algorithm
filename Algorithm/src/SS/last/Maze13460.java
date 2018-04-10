package SS.last;

import java.util.Arrays;
import java.util.Scanner;

public class Maze13460 {
	static int [][] map;
	static boolean [][] visited;
	static int Ans;
	static int Blank = 0;
	static int Wall = 1;
	static int Red = 2;
	static int Blue = 3;	
	static int End = 4;	
	
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	
	static int rx, ry, bx, by;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();
		
		rx = 0; ry = 0; bx = 0;	by = 0;

		map = new int[row][col];
		visited = new boolean[row][col];
		
		for(boolean [] temp : visited)
			Arrays.fill(temp, false);

		for(int i=0 ; i<row ; i++) {
			String s = sc.next();
			for(int k=0 ; k<s.length() ; k++) {
				if(s.charAt(k) == '#') map[i][k] = Wall;
				else if(s.charAt(k) == '.') map[i][k] = Blank;
				else if(s.charAt(k) == 'R') {
					rx = i; ry = k;
					map[i][k] = Red;
				} else if(s.charAt(k) == 'B') {
					bx = i; by = k;
					map[i][k] = Blue;
				} else if(s.charAt(k) == 'O') map[k][i] = End;
			}
		}

		for(int i =0 ; i<col ; i++) {
			for(int j=0; j<row ; j++)
				System.out.print(map[j][i] + " ");
			System.out.println();
		}
		
		dfs(rx, ry, bx, by, 0);
		
		
		System.out.println(rx + " " + ry + " " + bx + " " + by);
		sc.close();
	}
	
	public static void dfs(int x, int y, int x2, int y2, int cnt) {
		cnt++;
		
		if(cnt > 10) return;
		
		visited[x][y] = true;
		//끝나는 조건 문
		
		for(int i=0 ; i<4 ; i++) { // 0 동, 1 서, 2 남, 3 북
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			int nextX2 = x2 + dx[i];
			int nextY2 = y2 + dy[i];
			
			boolean redEnd = false;
			boolean blueEnd = false;
			
			while(map[nextX][nextY] != Wall) {
				if(map[nextX][nextY] == End) { 
					redEnd = true;
					break;
				}
				nextX += dx[i];
				nextY += dy[i];
				
				visited[nextX][nextY] = true;
			}
			
			while(map[nextX2][nextY2] != Wall) {
				if(map[nextX2][nextY2] == End) { 
					blueEnd = true;
					break;
				}
				nextX2 += dx[i];
				nextY2 += dy[i];
			}
			
			if(redEnd && !blueEnd) {
				Ans = Math.min(Ans, cnt);
				continue;
			}
			
			dfs(nextX, nextY, nextX2, nextY2, cnt);
			/*
			 * 0. 방향에 따라 이동가는한지 체크.. 불가하면 continue;
			 * 1. nextX, nextY 까지 이동하는 거 구현
			 * 2. bx, by 의 이동도 체크해야함.
			 */
		}
	}

}
