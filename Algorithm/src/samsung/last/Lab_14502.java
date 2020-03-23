package samsung.last;

import java.util.Arrays;
import java.util.Scanner;

//백준 14502 연구소
public class Lab_14502 {
	static int row, col, Ans, wallCount;
	static int [][] map;

	static final int BLANK = 0;
	static final int WALL = 1;
	static final int VIRUS = 2;

	static int [] dy = {1, 0, -1, 0}; //맵 상에서 y증가, x감소, y증가, x증가 순서를 위한 변수
	static int [] dx = {0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();

		map = new int[row][col];

		Ans = 0;
		wallCount = 0;

		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				int val = sc.nextInt(); //0은 빈칸, 1은 벽, 2는 바이러스 
				map[i][j] = val;
				if(val == 1) wallCount++;
			}
		}

		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					
					if(j == (col-1)) //다음 시작될 곳인데 행을 바꿔야 할 때
						dfs(i+1, 0 , 1);
					else 
						dfs(i, j+1, 1);
					
					map[i][j] = 0;
				}
			}
		}

		System.out.println(Ans);

		sc.close();
	}

	public static void dfs(int x, int y, int cnt) {
		if(cnt == 3) {
			boolean [][] visited = new boolean[row][col];

			for(boolean [] temp : visited) 
				Arrays.fill(temp, false);

			int virus = 0;
			for(int i=0 ; i<row ; i++) {
				for(int j=0 ; j<col ; j++) {
					if(map[i][j] == 2 && !visited[i][j])
						virus += spread(i , j, visited);
				}
			}
			Ans = Math.max(Ans, row*col - (virus + 3 + wallCount)); //전체에서 바이러스 퍼진거 + 벽3개 설치 + 기존에 벽 갯수

			return;
		}


		for(int i=x ; i<row ; i++) {
			for(int j=y ; j<col ; j++) {
				//x 가 row 넘어갈경우 col 변경 필요
				if(map[i][j] == 0) {
					map[i][j] = 1;
					
					if(j == (col-1))
						dfs(i+1, 0, cnt+1);
					else 
						dfs(i, j+1, cnt+1);

					map[i][j] = 0;
					//1로 선택했다가 그만큼 재귀돌리고 다시 0으로 백트래킹 (0,0) (0,1) -> 0, 2.3.4.5.6.7. 주루
				}
			}
			y = 0; //첫 행의 끝까지 돌았는데 아무것도 선택안되면 칼럼시작 0부터 해야됨
		}
	}

	public static int spread(int x, int y, boolean [][] visited) { 
		/*
		 * 바이러스 퍼트리기
		 * dfs 를 이용하여 퍼트리는데 1인 벽빼고 전파.
		 * 재귀형태상 온곳을 돌아가는것을 막기위해 visited 필요
		 */
		int res = 1;

		visited[x][y] = true;

		for(int i=0 ; i<4 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if(!visited[nextX][nextY] && map[nextX][nextY] != 1)
				res += spread(nextX, nextY, visited);
		}

		return res;
	}
}