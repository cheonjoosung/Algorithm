package SS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Robot14503 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt(); // 0 : 북, 1 : 동, 2 : 남, 3 : 서

		int count = 0;
		int [][] map = new int[m][n];

		for(int i=0; i< n ; i++) {
			for(int j=0; j<m ; j++) {
				map[j][i] = sc.nextInt();
			}
		}

		boolean isEnd = false;

		/*
		 * 1.보고있는 방향에서 왼 위 오 가 막혔다
		 * 1-1. 뒤로 물러날 곳이 존재한다. 한칸 뒤로 가도록 하
		 * 1-2. 뒤로 물러날 곳이 존재하지 않는다. 종료!!!
		 * 2.아니 한군데라도 남아있다.
		 * 2-1. 그 방향을 찾아서 회전하고 한칸 전진 - count++;
		 */
		while(!isEnd) {
			switch(d) {
			case 0:
				if(y == n-1) {
					if(isBlock(count, m, map, x, y, d)) {
						isEnd = true;
					} else {
						//어디론가 회전
					}
				} else {
					if(isBack(count, m, map, x, y, d)) {
						y++;
					} else {
						d = 3;
						//추가
					}
				}

				break;

			case 1:
				if(x == 0) {
					if(isBlock(count, m, map, x, y, d)) {
						isEnd = true;
					} else {
						//어디론가 회전
					}
				} else {
					if(isBack(count, m, map, x, y, d)) {
						x--;
					} else {
						d = 0;
						//추가
					}
				}
				break;

			case 2:
				if(y == 0) {
					if(isBlock(count, m, map, x, y, d)) {
						isEnd = true;
					} else {
						//어디론가 회전
					}
				} else {
					if(isBack(count, m, map, x, y, d)) {
						y--;
					} else {
						d = 1;
						//추가
					}
				}
				break;

			case 3:
				if(x == m-1) {
					if(isBlock(count, m, map, x, y, d)) {
						isEnd = true;
					} else {
						//어디론가 회전
					}
				} else {
					if(isBack(count, m, map, x, y, d)) {
						x++;
					} else {
						d = 2;
						//추가
					}
				}
				break;
			}
		}

		System.out.println(count);
	}

	public static boolean isBack(int n, int m, int [][] map, int x, int y, int d) {
		return false;
	}

	public static boolean isBlock(int n, int m, int [][] map, int x, int y, int d) {
		boolean res = false;

		switch(d) {

		case 0:


			break;

		case 1:
			break;

		case 2:
			break;

		case 3:
			break;
		}

		return res;
	}
}
