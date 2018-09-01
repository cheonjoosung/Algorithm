package SS.sw_expert.d4;

import java.util.Scanner;

//1824번 혁진이의 프로그램 검증
public class P1824 {
	static int row, col, x, y, val;
	static String [][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			String res = "YES";

			row = sc.nextInt();
			col = sc.nextInt();
			x = 0; //시작 좌표
			y = 0;
			val = 0;

			map = new String[row][col];

			for(int i=0 ; i<row ; i++) {
				/*
				 * < > ^ v 방향에 따라 이동
				 * _ 메모리에 0이 저장되어 있으면 이동방향 오른쪽으로 바꾸고 아니면 왼쪽으로
				 * | 메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고 아니면 위쪽으로
				 * ? 이동 방향을 상화좌우 중 하나로 무작위로 바꾼다. 
				 * . 아무것도 하지 않는다
				 * @ 프로그램의 실행을 정지
				 * 0~9 메모리에 문자가 나타내는 값을 저장
				 * + 메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15라면 0으로 바꾼다. 
				 * - 메모리 저장된 값에 1을 뺀다. 빼기 전값이 0이라면 15로 바꾼다.
				 * 
				 * 처음의 시작은 > 방향이 디폴트
				 */
				String s = sc.next();

				for(int j=0 ; j<col ; j++)
					map[i][j] = s.charAt(j)+"";
			}
			
			val = Integer.parseInt(map[0][0]);
			
			while(!(x == (row-1) && y == (col-1))) {
				switch(map[x][y]) {
				
				}
			}

			System.out.println("#" + t + " " + res);
		}

		sc.close();
	}
}
