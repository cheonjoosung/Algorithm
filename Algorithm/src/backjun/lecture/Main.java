package backjun.lecture;

import java.util.Scanner;

public class Main {
	static int Ans = 0;
	static int m [][];
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, -1, 0 ,1};
	static boolean [] visited;
	static int row;
	static int col;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		col = sc.nextInt();
		row = sc.nextInt();

		m = new int[row][col];
		visited = new boolean[26];
		
		Ans = 1;

		for(int i=0 ; i<col ; i++) {
			String s = sc.next();
			for(int j=0; j<s.length() ; j++) {
				m[j][i] = s.charAt(j) - 'A';
			}
		}

		visited[m[0][0]] = true;
		dfs(0, 0, 1);

		System.out.println(Ans);
	}

	public static void dfs(int x, int y, int step) {
		Ans = Math.max(Ans, step);
		
		for(int i=0 ; i<4 ; i++) {
			int nextRow = x + dx[i];
			int nextCol = y + dy[i];
			
			if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) continue;
			if(visited[m[nextRow][nextCol]]) continue;
			
			visited[m[nextRow][nextCol]] = true;
			dfs(nextRow, nextCol, step+1);
			visited[m[nextRow][nextCol]] = false;
		}

	}
}

