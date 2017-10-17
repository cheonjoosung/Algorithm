package backjun.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2583 {
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int col = sc.nextInt();
		int row = sc.nextInt();
		int count = sc.nextInt();

		map = new int[row][col];
		visited = new boolean[row][col];

		for(int [] temp : map)
			Arrays.fill(temp, 0);
		
		for(boolean [] temp : visited)
			Arrays.fill(temp, false);

		for(int i=0; i<count ; i++) {
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			int rx = sc.nextInt();
			int ry = sc.nextInt();

			for(int y=ly ; y < ry ; y++) 
				for(int x=lx ; x < rx ; x++) 
					map[x][y] = 1;
		}

		ArrayList<Integer> list = new ArrayList<>();
		int Ans = 0;
		for(int i=0 ; i<col ; i++)
			for(int j=0 ; j<row ; j++) {
				if(map[j][i] == 0 && !visited[j][i]) 
					list.add(dfs(j,i, row, col));
			}

		System.out.println(list.size());
		Collections.sort(list);
		for(int val : list) System.out.print(val + " ");
		System.out.println();
		sc.close();
	}
	
	public static int dfs(int x, int y, int row, int col) {
		visited[x][y] = true;
		
		int ret = 1;
		
		for(int i=0 ; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if(visited[nextX][nextY]) continue;
			if(map[nextX][nextY] != 0) continue;
			
			ret += dfs(nextX, nextY, row, col);
		}
		
		return ret;
	}
}
