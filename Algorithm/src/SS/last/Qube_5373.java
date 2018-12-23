package SS.last;

import java.util.Scanner;

//큐빙
public class Qube_5373 {
	static char [][] map;
	static int n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new char[27][6];
		StringBuffer sb = new StringBuffer();
		/*
		 * 1층 0~8 / 2층 9~17 / 3층 18~26 
		 * 0~5 는 위, 앞, 오른, 뒷, 왼쪽, 아래
		 */

		for(int i=0 ; i<n ; i++) {
			init();
			int cnt = sc.nextInt();

			for(int j=0 ; j<cnt ; j++) {
				String s = sc.next();

				int dir = s.charAt(1) == '+' ? 1 : -1;
				move(s.charAt(0), dir);
				
			}
			
			for(int k=0 ; k<3 ; k++) sb.append(map[k][0]);
			sb.append("\n");
			for(int k=3 ; k<6 ; k++) sb.append(map[k][0]);
			sb.append("\n");
			for(int k=6 ; k<9 ; k++) sb.append(map[k][0]);			
			sb.append("\n");
		}		

		System.out.println(sb);
		sc.close();
	}

	public static void init() {
		map = new char[27][6];
		
		for(int i=0 ; i<27 ; i++) {
			for(int j=0 ; j<6 ; j++) {
				if(j==0) map[i][j] = 'w';
				else if(j==1) map[i][j] = 'r';
				else if(j==2) map[i][j] = 'b';
				else if(j==3) map[i][j] = 'o';
				else if(j==4) map[i][j] = 'g';
				else map[i][j] = 'y';
			}
		}
	}

	public static void move(char pos, int dir) {
		/*
		 * 0-흰색, 1-빨간색, 2-파란색, 3-오레지색, 4-초록색, 5-노란색
		 * 1-시계방향, -1-반시계방향
		 */
		switch(pos) {
		case 'U':
			for(int i=0 ; i<=8 ; i++) {
				if(dir == 1) {
					char temp = map[i][1];
					map[i][1] = map[i][2];
					map[i][2] = map[i][3];
					map[i][3] = map[i][4];
					map[i][4] = temp;
				} else {
					System.out.println("HI");
					char temp = map[i][1];
					map[i][1] = map[i][4];
					map[i][4] = map[i][3];
					map[i][3] = map[i][2];
					map[i][2] = temp;
				}
			}
			break;
		case 'D':
			for(int i=18 ; i<=26 ; i++) {
				if(dir == 1) {
					char temp = map[i][1];
					map[i][1] = map[i][4];
					map[i][4] = map[i][3];
					map[i][3] = map[i][2];
					map[i][2] = temp;
				} else {
					char temp = map[i][1];
					map[i][1] = map[i][2];
					map[i][2] = map[i][3];
					map[i][3] = map[i][4];
					map[i][4] = temp;
				}
			}
			break;
		case 'L':
			for(int i=0 ; i<=24 ; i=i+3) {
				if(dir == 1) {
					char temp = map[i][0];
					map[i][0] = map[i][3];
					map[i][3] = map[i][5];
					map[i][5] = map[i][1];
					map[i][1] = temp;
				} else {
					char temp = map[i][0];
					map[i][0] = map[i][1];
					map[i][1] = map[i][5];
					map[i][5] = map[i][3];
					map[i][3] = temp;
				}
			}
			break;
		case 'R':
			for(int i=2 ; i<=26 ; i=i+3) {
				if(dir == 1) {
					char temp = map[i][0];
					map[i][0] = map[i][1];
					map[i][1] = map[i][5];
					map[i][5] = map[i][3];
					map[i][3] = temp;
				} else {
					char temp = map[i][0];
					map[i][0] = map[i][3];
					map[i][3] = map[i][5];
					map[i][5] = map[i][1];
					map[i][1] = temp;
				}
			}
			break;
		case 'F':
			for(int i=6 ; i<=26 ; i++) {
				if(i>=9 && i<=14) continue;
				if(i>=18 && i<=23) continue;
				
				if(dir == 1) {
					char temp = map[i][0];
					map[i][0] = map[i][4];
					map[i][4] = map[i][5];
					map[i][5] = map[i][2];
					map[i][2] = temp;
				} else {
					char temp = map[i][0];
					map[i][0] = map[i][2];
					map[i][2] = map[i][5];
					map[i][5] = map[i][4];
					map[i][4] = temp;
				}
			}
			break;
		case 'B': 
			for(int i=0 ; i<=20 ; i++) {
				if(i>=3 && i<=8) continue;
				if(i>=12 && i<=17) continue;
				
				if(dir == 1) {
					char temp = map[i][0];
					map[i][0] = map[i][2];
					map[i][2] = map[i][5];
					map[i][5] = map[i][4];
					map[i][4] = temp;
				} else {
					char temp = map[i][0];
					map[i][0] = map[i][4];
					map[i][4] = map[i][5];
					map[i][5] = map[i][2];
					map[i][2] = temp;
				}
			}
			break;
		}
	}
}