package samsung.last;

import java.util.Arrays;
import java.util.Scanner;

//백준 14499 주사위 굴리기
public class Dice_14499 {
	public static int [][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * 1. 방향으로 이동
		 * 1-1. 범위 벗어나면 출력하지 않고 continue
		 * 2. 위의 값 출력
		 * 3. 밑의 값 갱신
		 */

		int n = sc.nextInt();
		int m = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int count = sc.nextInt();

		int [] dice = new int[6];
		Arrays.fill(dice, 0);

		map = new int[m][n];

		for(int i=0; i<n ; i++)
			for(int j=0; j<m ; j++)
				map[j][i] = sc.nextInt();

		for(int i=0 ; i< count ; i++) {
			int dir = sc.nextInt();

			if(dir == 1) {
				if(x != m-1)
					x++;
			} else if(dir == 2) {
				if(x != 0)
					x--;
			} else if(dir == 3) {
				if(y != 0)
					y--;
			} else {
				if(y != n-1)
					y++;
			}

			change(dice, dir,x ,y);
		}

		sc.close();
	}

	public static void change(int [] dice, int mode, int x, int y) {
		/*
		 *  0-1-2-3-4-5   
		 *  기본 : 앞-뒤-위-밑-좌-우
		 *  1 동, 2 서, 3 남, 4 북 
		 */
		switch (mode) {
		case 1:	
			int temp = dice[2];
			dice[2] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
			break;
		case 2:
			int temp2 = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = temp2;
			break;
		case 3:
			int temp3 = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[0];
			dice[0] = temp3;

			break;
		case 4:
			int temp4 = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[1];
			dice[1] = temp4;
			break;
		}

		if(map[x][y] == 0) map[x][y] = dice[3];
		else {
			dice[3] = map[x][y];
			map[x][y] = 0;
		}

		System.out.println(dice[2]);
	}
}
