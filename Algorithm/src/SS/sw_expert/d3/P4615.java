package SS.sw_expert.d3;

import java.util.Scanner;

//재미있는 오셀로 게임
public class P4615 {
	static int [] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int [] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	static int n;
	static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			map = new int[n][n];
			int blackCnt = 0; int whiteCnt = 0;
			
			for(int i=n/2-1 ; i<=n/2 ; i++) {
				for(int j=n/2-1 ; j<=n/2 ; j++) {
					if((i+j) % 2 == 0) map[i][j] = 2;
					else map[i][j] = 1;
				}
			}
			
			for(int i=0 ; i<m ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt(); //1백, 2 흑
				
				/*
				 * 1.맵에 돌 놓기
				 * 2.색깔바뀌는 돌 표시
				 */
//				System.out.println(x + " " + y);
				map[x-1][y-1] = c;
				find(x-1, y-1, c);				
			}
			
			for(int [] tempArr : map)
				for(int tempVal : tempArr) {
					if(tempVal == 1) blackCnt++;
					else if(tempVal == 2) whiteCnt++;
				}
			
			System.out.println("#" + t + " " + blackCnt + " " + whiteCnt);
		}
		
		sc.close();
	}
	
	public static void find(int x, int y, int c) {
		for(int d=0 ; d<8 ; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			boolean check = false;
			while(nx >= 0 && ny >= 0 && nx < n && ny <n && map[nx][ny] != 0) {
				if(map[nx][ny] == c) {
					check = true;
					break;
				}
				nx += dx[d];
				ny += dy[d];
			}
			
			while(check) {
				if(nx == x && ny == y) break;
				map[nx][ny] = c;
				nx -= dx[d];
				ny -= dy[d];
			}
		}
	}
}