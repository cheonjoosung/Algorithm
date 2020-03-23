package samsung.sw_expert.d4;

import java.util.Scanner;

//[S/W 문제해결 기본] 2일차 - Ladder1
public class P1210 {
	static int ans;
	static int [][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();

			map = new int[100][102];
			ans = 0;

			for(int i=0 ; i<100 ; i++)
				for(int j=1 ; j<=100 ; j++)
					map[i][j] = sc.nextInt();


			for(int j=1 ; j<=100 ; j++) {
				if(map[0][j] == 1) {
					int nx = 0;
					int ny = j;
					int d = 1;

					while(nx <= 99) {
						if(d == 0) { //오른쪽 
							if(map[nx][ny+1] == 1) ny++;
							else {
								nx++;
								d = 1;
							}
						} else if(d == 1) { //아래 
							if(map[nx][ny+1] == 1) {
								ny++;
								d = 0;
							} else if(map[nx][ny-1] == 1) {
								ny--;
								d = 2;
							} else {
								nx++;
							}
						} else { //좌측 
							if(map[nx][ny-1] == 1) ny--;
							else {
								nx++;
								d = 1;
							}
						}
					}

					if(map[99][ny] == 2) {
						ans = j-1;
						break;
					}
				}
			}

			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}