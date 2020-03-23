package samsung.sw_expert.test_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//SWExpertAcademy 모의 SW 역량 테스트 핀볼 게임
public class P5650 {
	static int [][] map;
	static boolean [] visited;
	static int ans, n, blackX, blackY;
	static int [] dx = {0, 1, 0 , -1};
	static int [] dy = {1, 0, -1 , 0};	
	static ArrayList<Holl> wormList; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;

			n = sc.nextInt();

			map = new int[n+2][n+2];
			wormList = new ArrayList<>();
			ans = 0;

			for(int [] tempArr : map)
				Arrays.fill(tempArr, 5);

			for(int i=1 ; i<=n ; i++) {
				for(int j=1 ; j<=n ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] >= 6 && map[i][j] <= 10)
						wormList.add(new Holl(i, j, map[i][j])); 
				}
			}

			for(int i=1 ; i<=n ; i++) {
				for(int j=1 ; j<=n ; j++) {
					if(map[i][j] == 0) {
						for(int dir=0 ; dir<4 ; dir++)
							solve(i, j, i, j, dir);	//위치 선택후 4방향으로 이동 가능
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}

	public static void solve(int sx, int sy, int nx, int ny, int dir) {
		/*
		 * 1. 현재 위치에서 이동하고 반복하며 위치 변경
		 * 1.1 벽을 만나면 +1
		 * 1.2 블록을 만나면 +1
		 * 2. 종료조건 
		 * 2-1) 블랙홀에 빠졌을때
		 * 2-2) 현재 위치로 다시 돌아왔을 때
		 * 2-3) 특정 지점 x.y 에서 d 방향으로 이전에 이동한 적이 있을 때 -> 이경우는 없다 ?
		 * 3. 종료될 때 ans 값 갱신하기
		 */

		int res = 0;

		while(true){	
			nx += dx[dir];
			ny += dy[dir];
			
			if((nx==sx && ny==sy) || (map[nx][ny]==-1)) {
				ans = Math.max(ans, res);
				return;
			}

			if(map[nx][ny] != 0) {
				if(map[nx][ny] >= 1 && map[nx][ny] <= 5) {
					//블록에 부딪힌다.
					res++;
					dir = changeDir(dir, map[nx][ny]);
				} else {
					//웜훨 이동
					for(int i=0 ; i<wormList.size() ; i++) {
						if(map[nx][ny] == wormList.get(i).num) {
							if(!(wormList.get(i).x == nx && wormList.get(i).y == ny)) {
								nx = wormList.get(i).x;
								ny = wormList.get(i).y;
								break;
							}
						}
					}
				}
			}
		}
	}

	public static int changeDir(int dir, int val) {
		switch(val) {
		case 1:
			if(dir == 0) dir = 2;
			else if(dir == 1) dir = 0;
			else if(dir == 2) dir = 3;
			else dir = 1;
			break;
		case 2:
			if(dir == 0) dir = 2;
			else if(dir == 1) dir = 3;
			else if(dir == 2) dir = 1;
			else dir = 0;
			break;
		case 3:
			if(dir == 0) dir = 1;
			else if(dir == 1) dir = 3;
			else if(dir == 2) dir = 0;
			else dir = 2;
			break;
		case 4:
			if(dir == 0) dir = 3;
			else if(dir == 1) dir = 2;
			else if(dir == 2) dir = 0;
			else dir = 1;
			break;
		case 5:
			if(dir == 0) dir = 2;
			else if(dir == 1) dir = 3;
			else if(dir == 2) dir = 0;
			else dir = 1;
			break;
		}
		return dir;
	}
}

class Holl {
	int x; int y; int num;
	Holl(int x, int y, int num) {
		this.x=x; this.y=y; this.num=num;
	}
}