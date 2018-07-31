package SS.last;

import java.util.Arrays;
import java.util.Scanner;

//백준 14500 테트로미노
public class Tetris_14500 {
	static int row, col, Ans;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		Ans = 0;
		
		map = new int[row][col];
		visited = new boolean[row][col];
		
		for(int i=0 ; i<row ; i++)
			for(int j=0 ; j<col ; j++)
				map[i][j] = sc.nextInt();
		
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				dfs(i, j, 0, 0);
				solve(i, j);
			}
		}
		
		System.out.println(Ans);
		
		sc.close();
	}
	
	public static void dfs(int x, int y, int sum, int cnt) { // ㅗ를 제외한 나머지 모양은 한점에서 4칸이동한 모든 재귀로 구현 가능
		if(cnt == 3) {
			Ans = Math.max(Ans, (sum+map[x][y]));
			return;
		}
		
		visited[x][y] = true;
		for(int i=0 ; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX<0 || nextY<0 || nextX >= row || nextY >= col) continue;
			if(visited[nextX][nextY]) continue;
			
			dfs(nextX, nextY, sum + map[x][y], cnt+1);
		}
		visited[x][y] = false;
		
	}
	
	public static void solve(int x, int y) { // ㅗ 모양을 위해서
		int res = 0;
		
		if(x == 0) {
			if(y>=1 && y<=col-2) 
				res += map[x][y] + map[x][y-1] + map[x][y+1] + map[x+1][y];
		} else if(x == row-1) {
			if(y>=1 && y<=col-2) 
				res += map[x][y] + map[x][y-1] + map[x][y+1] + map[x-1][y];
		} else {
			if(y == 0) {
				if(x>=1 && x<=row-2)
					res += map[x][y] + map[x+1][y] + map[x-1][y] + map[x][y+1];
			} else if(y == col-1) {
				if(x>=1 && x<=row-2)
					res += map[x][y] + map[x+1][y] + map[x-1][y] + map[x][y-1];
			} else {
				int temp1 = map[x][y] + map[x][y-1] + map[x][y+1] + Math.max(map[x+1][y], map[x-1][y]);
				int temp2 = map[x][y] + map[x+1][y] + map[x-1][y] + Math.max(map[x][y+1], map[x][y-1]);
				
				res = Math.max(temp1, temp2);
			}
		}
		
		Ans = Math.max(Ans, res);
	}
}