package SS.sw_expert.d3;

import java.util.Scanner;

//1873번 상호의 배틀필드
public class P1873 {
	static int ans, row, col, x, y, d;
	static char [][] map;
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			row = sc.nextInt();
			col = sc.nextInt();
			
			map = new char[row][col];
			
			/*
			 * . 평지 , * 벽돌 , # 강철 , - 물 , ^ 위쪽 , v 아래쪽 , < 왼쪽 , > 오른쪽
			 * (U 위로 , D 아래쪽, L 왼쪽 , R 오른쪽) + 한칸전진 , S 바라보는 방향으로 포탄 발사 
			 */
			
			for(int i=0 ; i<row ; i++) {
				String s = sc.next();
				for(int j=0 ; j<s.length() ; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v'){
						x = i;
						y = j;
						if(map[i][j] == '>') d = 0;
						if(map[i][j] == 'v') d = 1;
						if(map[i][j] == '<') d = 2;
						if(map[i][j] == '^') d = 3;
					}
				}
			}
			
			int count = sc.nextInt();
			String s = sc.next();
			
			for(int i=0 ; i<s.length() ; i++) {
				switch(s.charAt(i)){
				case 'U':
					d = 3;
					move(x, y, d);
					break;
				case 'D':
					d = 1;
					move(x, y, d);
					break;
				case 'L':
					d = 2;
					move(x, y, d);
					break;
				case 'R':
					d = 0;
					move(x, y, d);
					break;
				case 'S':
					bomb(x, y, d);
					break;
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0 ; i<row ; i++) {
				for(int j=0 ; j<col ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

		sc.close();
	}
	
	public static void move(int i, int j, int dir) {
		//. 평지 , * 벽돌 , # 강철 , - 물
		int nextX = x + dx[dir];
		int nextY = y + dy[dir];
		
		if(dir == 0) map[x][y] = '>';
		else if(dir == 1) map[x][y] = 'v';
		else if(dir == 2) map[x][y] = '<';
		else map[x][y] = '^';
		
		if(nextX<0 || nextY<0 || nextX>=row || nextY>= col) return; //범위 밖
		if(map[nextX][nextY] == '#' || map[nextX][nextY] == '-' || map[nextX][nextY] == '*') return; //물, 벽돌, 강철
		
		map[x][y] = '.';
		
		x = nextX;
		y = nextY;		
		
		if(dir == 0) map[x][y] = '>';
		else if(dir == 1) map[x][y] = 'v';
		else if(dir == 2) map[x][y] = '<';
		else map[x][y] = '^';
	}
	
	public static void bomb(int i, int j, int dir) {
		switch(dir) {
		case 0:
			for(int idx=j ; idx<col ; idx++) {
				if(map[i][idx] == '#') break;
				else if(map[i][idx] == '*') { 
					map[i][idx] = '.';
					break;
				}
			}
			break;
		case 1:
			for(int idx=i ; idx<row ; idx++) {
				if(map[idx][j] == '#') break;
				else if(map[idx][j] == '*') {
					map[idx][j] = '.';
					break;
				}
			}
			break;
		case 2:
			for(int idx=j ; idx>=0 ; idx--) {
				if(map[i][idx] == '#') break;
				else if(map[i][idx] == '*') {
					map[i][idx] = '.';
					break;
				}
			}
			break;
		case 3:
			for(int idx=i ; idx>=0 ; idx--) {
				if(map[idx][j] == '#') break;
				else if(map[idx][j] == '*') {
					map[idx][j] = '.';
					break;
				}
			}
			break;
		}
	}
}