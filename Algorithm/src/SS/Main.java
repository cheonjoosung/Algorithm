package SS;

import java.util.Scanner;

public class Main {
	static int Ans = 0;
	static int Len = 4;
	static int row, col;
	static int [][] map;
	static boolean [][] visited;
	static int [] dR = {1, 0, -1, 0};
	static int [] dC = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		col = sc.nextInt();
		row = sc.nextInt();
		
		map = new int[row][col];
		visited = new boolean[row][col];
		Ans = 0;
		
		for(int i=0; i<col ; i++)
			for(int j=0 ; j<row ; j++) 
				map[j][i] = sc.nextInt();
			
		for(int i=0 ; i<col ; i++) {
			for(int j=0; j<row ; j++) {
				dfs(0, j , i, 0);
				solve(j, i);
			}
		}
		
		System.out.println(Ans);
		
		sc.close();
	}
	
	public static void dfs(int depth, int x, int y, int sum) {
		if(depth == Len - 1) {
			sum += map[x][y];
			
			Ans = Math.max(sum, Ans);
			return;
		}
		
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nextX = x + dR[i];
			int nextY = y + dC[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if(visited[x][y]) continue;
			
			dfs(depth+1, nextX, nextY, sum+map[x][y]);
		}
		
		visited[x][y] = false;
	}
	
	public static void solve(int x, int y) {		
		if(y == 0) {
			if(x == 0 || x == row-1) return;
			int temp = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y+1];
			Ans = Math.max(Ans, temp);
		} else if(y == col-1) {
			if(x == 0 || x == row-1) return;
			int temp = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y-1];
			Ans = Math.max(Ans, temp);
		} else {
			if(x == 0) {
				int temp = map[x][y-1] + map[x][y] + map[x][y+1] + map[x+1][y];
				Ans = Math.max(Ans, temp);
			} else if(x == row-1) {
				int temp = map[x][y-1] + map[x][y] + map[x][y+1] + map[x-1][y];
				Ans = Math.max(Ans, temp);
			} else {
				int temp1 = map[x][y-1] + map[x][y] + map[x][y+1] + map[x+1][y];
				int temp2 = map[x][y-1] + map[x][y] + map[x][y+1] + map[x-1][y];
				int temp3 = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y-1];
				int temp4 = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y+1];
				int temp = Math.max(Math.max(temp1, temp2), Math.max(temp3, temp4));
				Ans = Math.max(Ans, temp);
			}
		}
	}
}
