package SS;

import java.util.Scanner;

public class RobotCleaner {

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
