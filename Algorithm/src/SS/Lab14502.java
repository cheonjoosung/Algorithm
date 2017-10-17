package SS;

import java.util.Arrays;
import java.util.Scanner;

public class Lab14502 {
	public static int [][] map;
	public static int Ans;
	public static int Wall;
	public static int [] rowDir = {1, 0, -1, 0};
	public static int [] colDir = {0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int col = sc.nextInt();
		int row = sc.nextInt();

		map = new int[row][col];
		Ans = 0;
		Wall = 0;

		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0; 

		for(int i=0; i<col ; i++)
			for(int j=0; j<row ; j++) {
				map[j][i] = sc.nextInt();
				if(map[j][i] == 1) Wall++;
			}

		while(true) {
			if(y1 > col-1) break;
			if(map[x1][y1] != 0) {
				if(x1+1 == row) y1++;
				x1 = (x1+1) % row;
				continue;
			} else {
				if(x1+1 == row) y2 = y1 + 1;
				else y2 = y1;
				x2 = (x1+1) % row;
			}

			while(true) {
				if(y2 > col-1) break;
				if(map[x2][y2] != 0) {
					if(x2 + 1 == row ) y2++;
					x2 = (x2+1) % row;
					continue;
				} else {
					if(x2+1 == row) y3 = y2+1;
					else y3 = y2;
					x3 = (x2+1) % row;
				}

				while(true) {
					if(y3 > col-1) break;
					if(map[x3][y3] != 0) {
						if(x3 + 1 == row) y3++;
						x3 = (x3+1) % row;
						continue;
					}

					int [][] tempMap = new int[row][col];
					
					for(int i=0 ; i<col ; i++) 
						for(int j=0 ; j<row ; j++)
							tempMap[j][i] = map[j][i];
					
					// 0. 벽놓기
					map[x1][y1] = 1;
					map[x2][y2] = 1;
					map[x3][y3] = 1;
					// 1. 바이러스 퍼트리기
					virus(row, col);
					
					map[x1][y1] = 0;
					map[x2][y2] = 0;
					map[x3][y3] = 0;

					if(x3 + 1 == row) y3++;
					x3 = (x3+1) % row;
				}
				
				if(x2 == row-2 && y2 == col-1) break;
				if(x2 + 1 == row) y2++;
				x2 = (x2+1) % row;
			}
			
			if(x1 == row-3 && y1 == col-1) break;
			if(x1 + 1 == row) y1++;
			x1 = (x1+1) % row;
		}
		
		System.out.println(Ans);

		sc.close();
	}

	public static void virus(int row, int col){
		boolean [][] visited = new boolean[row][col];

		for(boolean [] temp : visited) 
			Arrays.fill(temp, false);

		int virusCount = 0;
		
		for(int i=0 ; i<col ; i++) {
			for(int j=0; j<row ; j++) {
				if(map[j][i] == 2  && visited[j][i] == false) {
					virusCount += spread(j, i, row, col, visited);
				}
			}
		}
		
		Ans = Math.max(Ans, (row*col - (3 + Wall + virusCount)));

		//dfs or 재귀 
	}

	public static int spread(int x, int y, int row, int col, boolean [][] visited) {
		visited[x][y] = true;

		int res = 1;
		for(int i=0 ; i<4 ; i++) {
			int nextX = x + rowDir[i];
			int nextY = y + colDir[i];

			if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;

			if (map[nextX][nextY] != 1 && !visited[nextX][nextY]) {
				res += spread(nextX, nextY, row, col, visited);
			}
		}
		return res;
	}
}