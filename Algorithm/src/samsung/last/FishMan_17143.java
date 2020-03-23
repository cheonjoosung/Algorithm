package samsung.last;

import java.util.Scanner;

public class FishMan_17143 {
	static int row, col, cnt, ans;
	static int [][] map;
	static Fish[] fish = new Fish[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();
		cnt = sc.nextInt();

		ans = 0;
		map = new int[row][col];

		for(int i=0 ; i<cnt ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();

			map[x-1][y-1] = z;
			fish[z] = new Fish(x-1, y-1, s ,d ,z);
		}

		for(int b=0 ; b<col ; b++) {
			/*
			 * 1.낚시군 작살 던지기
			 * 2.물고기 이동
			 * 2-1)물고기 충돌 고려
			 */
			for(int a=0 ; a<row ; a++) {
				if(map[a][b] != 0) { //작살에 제거된 물고기 위치 표시
					fish[map[a][b]] = null;
					ans += map[a][b];
					map[a][b] = 0;
					break;
				}
			}

			for(int idx=1 ; idx<=10000 ; idx++) {
				if(fish[idx] == null) continue;

				Fish f = fish[idx];

				int nx = f.x;
				int ny = f.y;
				int nd = f.d;

				map[nx][ny] = 0;

				switch(f.d) {					
				case 1:
				case 2:
					for(int cnt=0 ; cnt<f.s ; cnt++) {
						if(nd == 1) {
							if(nx == 0) { nd = 2; nx++; }
							else { nx--; }
						} else {
							if(nx == row-1) { nd = 1; nx--; }
							else { nx++; }
						}
					}	

					fish[idx] = new Fish(nx, ny, f.s ,nd, idx);
					break;

				case 3:
				case 4:
					for(int cnt=0 ; cnt<f.s ; cnt++) {
						if(nd == 3) {
							if(ny == col-1) { nd = 4; ny--; }
							else { ny++; }
						} else {
							if(ny == 0) { nd = 3; ny++; }
							else { ny--; }
						}
					}

					fish[idx] = new Fish(nx, ny, f.s , nd, idx);
					break;
				}
			}

			for (int j = 1; j <= 10000; j++) {
				if (fish[j] == null) continue;
				
				Fish f = fish[j];
				if (map[f.x][f.y] < f.z) {   //맵에 저장된 물고기보다 본인이 더 크면
					fish[map[f.x][f.y]] = null;
					map[f.x][f.y] = f.z;
				}
			}
		}

		System.out.println(ans);
		sc.close();
	}
}

class Fish {
	public int x, y, s, d, z;

	Fish(int x, int y, int s, int d, int z) {
		this.x = x; this.y = y; this.s = s; this.d = d; this.z = z;
	}
}