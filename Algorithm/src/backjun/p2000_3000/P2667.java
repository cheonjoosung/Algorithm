package backjun.p2000_3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2667 {
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, -1, 0, 1};
	static int Ans;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		Ans = 0;
		
		for(boolean [] temp : visited)
			Arrays.fill(temp, false);
		
		for(int i=0 ; i<n ; i++) {
			String s = sc.next();
			
			for(int j=0 ; j<s.length() ; j++) {
				if(s.charAt(j) == '0') map[j][i] = 0;
				else map[j][i] = 1;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(map[j][i] == 1 && !visited[j][i]) {
					Ans = 0;
					dfs(j, i);
					list.add(Ans);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int val : list) System.out.println(val);
		
		sc.close();
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		Ans++;
		
		for(int i=0 ; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
			if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
			
			dfs(nextX, nextY);
		}
	}
}
