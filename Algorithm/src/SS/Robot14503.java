package SS;

import java.util.Scanner;

public class Robot14503 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int y = sc.nextInt();
		int x = sc.nextInt();
		int d = sc.nextInt(); // 0 : 북, 1 : 동, 2 : 남, 3 : 서

		int count = 0;
		int [][] map = new int[m][n];

		for(int i=0; i< n ; i++) {
			for(int j=0; j<m ; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		/*
		 * 1.보고있는 방향에서 왼 위 오 가 막혔다
		 * 1-1. 뒤로 물러날 곳이 존재한다. 한칸 뒤로 가도록 하
		 * 1-2. 뒤로 물러날 곳이 존재하지 않는다. 종료!!!
		 * 2.아니 한군데라도 남아있다.
		 * 2-1. 그 방향을 찾아서 회전하고 한칸 전진 - count++;
		 */
		
		while(true) {
			if(map[x][y] == 0) {
				map[x][y] = 2;
				count++;
			}

			boolean back = true;

			for(int i=0 ; i< 4 ; i++) {
				if(d == 3) {
					d = 2;
					if(map[x][y+1] == 0) {
						y = y+1;
						back = false;
						break;
					}
				} else if(d == 2){
					d = 1;
					if(map[x+1][y] == 0) {
						x = x+1;
						back = false;
						break;
					}
				} else if(d == 1) {
					d = 0;
					if(map[x][y-1] == 0) {
						y = y-1;
						back = false;
						break;
					}
				} else if(d == 0) {
					d = 3;
					if(map[x-1][y] == 0) {
						x = x-1;
						back = false;
						break;
					}
				}
			}

			if(back) {
				if(d == 3) {
					if(map[x+1][y] == 1) break;
					else x++;
				} else if(d == 2) {
					if(map[x][y-1] == 1) break;
					else y--;
				} else if(d == 1) {
					if(map[x-1][y] == 1) break;
					else x--;
				} else if(d == 0) {
					if(map[x][y+1] == 1) break;
					else y++;
				}
			}
		}

		System.out.println(count);

		sc.close();
	}

}
