package backjun.lecture.p1000_2000;

import java.util.Arrays;
import java.util.Scanner;

public class P1012 {
	static int Wall = 0;
	static int Kimchi = 1;
	static int Ans;
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, -1, 0, 1};
	static int row;
	static int col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=0; t<testCase ; t++) {
			Ans = 0;
			
			row = sc.nextInt();
			col = sc.nextInt();
			int kimchiCount = sc.nextInt();
			
			int [][] arr = new int[row][col];
			
			for(int [] temp : arr) Arrays.fill(temp, Wall);
			
			for(int i=0 ; i<kimchiCount ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arr[x][y] = Kimchi;
			}
			
			for(int q=0 ; q<col ; q++) {
				for(int p=0 ; p<row ; p++) {
					if(arr[p][q] == 1) { 
						Ans++;
						dfs(kimchiCount, arr, p, q);
					}
				}
			}
			
			System.out.println(Ans);
		}
		
		sc.close();
	}
	
	public static void dfs(int totalCount, int [][] map, int x, int y) {
		if(totalCount == 0) return;
		map[x][y] = 0;
		totalCount--;
		
		for(int i=0 ; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if(map[nextX][nextY] == 0) continue;
			
			dfs(totalCount, map, nextX, nextY);
		}
		
	}
}
