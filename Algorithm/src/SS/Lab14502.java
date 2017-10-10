package SS;

import java.util.Arrays;
import java.util.Scanner;

public class Lab14502 {
	public static int [][] map;
	public static int Ans;
	public static int [] rowDir = {1, 0, -1, 0};
	public static int [] colDir = {0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int col = sc.nextInt();
		int row = sc.nextInt();

		map = new int[row][col];
		Ans = 0;

		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0; 

		for(int i=0; i<col ; i++)
			for(int j=0; j<row ; j++)
				map[j][i] = sc.nextInt();

		while(x1 != (row-3) || y1 != (col-1)) {
			if(map[x1][y1] != 0) {
				if(x1 + 1 == row) {
					x1 = 0;
					y1++;
				} else {
					x1++;
				}
				continue;
			}

			if(x1 + 1 == row) {
				x2 = 0;
				y2 = y1 + 1;;
			} else {
				x2 = x1 + 1;
				y2 = y1;
			}

			while(x2 != (row-2) || y2 != (col-1)) {
				if(map[x2][y2] != 0) {
					if(x2 + 1 == row) {
						x2 = 0;
						y2++;
					} else {
						x2++;
					}
					continue;
				}

				if(x2 + 1 == row) {
					x3 = 0;
					y3 = y2 + 1;;
				} else {
					x3 = x2 + 1;
					y3 = y2;
				}

				while(x3 != (row-1) || y3 != (col-1)) {	
					if(map[x3][y3] != 0) {
						if(x3 + 1 == row) {
							x3 = 0;
							y3++;
						} else {
							x3++;
						}
						continue;
					}

					int [][] tempMap = new int[row][col];
					
					for(int i=0 ; i<col ; i++) 
						for(int j=0 ; j<row ; j++)
							tempMap[j][i] = map[j][i];
					
					// 0. 벽놓기
					tempMap[x1][y1] = 1;
					tempMap[x2][y2] = 1;
					tempMap[x3][y3] = 1;
					// 1. 바이러스 퍼트리기
					virus(tempMap, row, col);
					// 2. 안전구역 체크 
					countZerom(tempMap);

					if(x3 + 1 == row) {
						x3 = 0;
						y3++;
					} else {
						x3++;
					}
				}

				if(x2 + 1 == row) {
					x2 = 0;
					y2++;
				} else {
					x2++;
				}
			}

			if(x1 + 1 == row) {
				x1 = 0;
				y1++;
			} else {
				x1++;
			}
		}
		
		System.out.println(Ans);

		sc.close();
	}

	public static void virus(int [][] tempMap,int row, int col){
		boolean [][] visited = new boolean[row][col];

		for(boolean [] temp : visited) 
			Arrays.fill(temp, false);

		for(int i=0 ; i<col ; i++) {
			for(int j=0; j<row ; j++) {
				if(map[j][i] == 2  && visited[j][i] == false) {
					spread(tempMap, j, i, row, col, visited);
				}
			}
		}

		//dfs or 재귀 
	}

	public static void spread(int [][] tempMap, int x, int y, int row, int col, boolean [][] visited) {
		visited[x][y] = true;

		for(int i=0 ; i<4 ; i++) {
			int nextX = x + rowDir[i];
			int nextY = y + colDir[i];

			if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col 
					|| tempMap[nextX][nextY] == 1) continue;

			if (tempMap[nextX][nextY] != 1 && !visited[nextX][nextY]) {
				tempMap[nextX][nextY] = 2;
				spread(tempMap, nextX, nextY, row, col, visited);
			}
		}

	}

	public static void countZerom(int [][] tempMap) {
		int count = 0;
		for(int [] temp : tempMap)
			for(int val : temp) 
				if(val == 0) count++;

		Ans = Math.max(Ans, count);
	}
}
