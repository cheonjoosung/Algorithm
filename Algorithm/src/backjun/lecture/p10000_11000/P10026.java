package backjun.lecture.p10000_11000;

import java.util.Arrays;
import java.util.Scanner;

public class P10026 {
	static int Red = 0;
	static int Blue = 1;
	static int Green = 2;

	static int [][] map;
	static boolean [][] visited;

	static int [] dx = { 1, 0, -1, 0};
	static int [] dy = { 0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		map = new int[size][size];
		visited = new boolean[size][size];

		for(boolean [] temp : visited)
			Arrays.fill(temp, false);

		String [] s = new String[size];

		for(int i=0 ; i<size ; i++)
			s[i] = sc.next();

		for(int i=0 ; i<size ; i++) {
			String temp = s[i];
			for(int j=0 ; j<size ; j++) {
				if( (temp.charAt(j) + "").equals("R") ) map[j][i] = Red;
				else if( (temp.charAt(j) + "").equals("B") ) map[j][i] = Blue;
				else map[j][i] = Green;
			}
		}

		int Ans = 0;
		for(int i=0 ; i<size ; i++) {
			for(int j=0; j<size ; j++) {
				if(!visited[j][i]) {
					Ans++;
					dfs(j, i, size);
				}
			}
		}

		for(boolean [] temp : visited)
			Arrays.fill(temp, false);

		int Ans2 = 0;
		for(int i=0 ; i<size ; i++) {
			for(int j=0; j<size ; j++) {
				if(!visited[j][i]){
					Ans2++;
					dfs2(j, i, size);
				}
			}
		}

		System.out.println(Ans + " " + Ans2);

		sc.close();
	}
	
	public static void dfs(int x, int y, int size) {
		visited[x][y] = true;

		for(int i=0; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if(nextX < 0 || nextY < 0 || nextX > size-1 || nextY > size-1) continue;
			if(visited[nextX][nextY]) continue;

			if(map[x][y] == map[nextX][nextY]) dfs(nextX, nextY, size);
		}
	}

	public static void dfs2(int x, int y, int size) {
		visited[x][y] = true;

		for(int i=0; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if(nextX < 0 || nextY < 0 || nextX > size-1 || nextY > size-1) continue;
			if(visited[nextX][nextY]) continue;

			if(map[x][y] == Blue) {
				if(map[nextX][nextY] != Blue) continue;
				dfs2(nextX, nextY, size);
			} else {
				if(map[nextX][nextY] == Blue) continue;
				dfs2(nextX, nextY, size);
			}
		}
	}
}
