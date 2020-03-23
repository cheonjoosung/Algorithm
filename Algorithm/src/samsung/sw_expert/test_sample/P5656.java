package samsung.sw_expert.test_sample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//SWExpertAcademy 모의 SW 역량 테스트 벽돌 깨기
public class P5656 {
	static int n, row, col, ans;
	static int [][] map;
	static int [] ball;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			col = sc.nextInt();
			row = sc.nextInt();
			
			map = new int[row][col];
			ball = new int[n];
			ans = Integer.MAX_VALUE;
			
			for(int i=row-1 ; i>=0 ; i--)
				for(int j=0 ; j<col ; j++)
					map[i][j] = sc.nextInt();
			
			while(true) {
				int [][] copyArr = new int[row][col];
				
				for(int i=0 ; i<row ; i++) 
					copyArr[i] = map[i].clone();
				
				spread(copyArr, ball);
				calc(copyArr);
				
				//System.out.println(ball[0] + " " + ball[1] + " " + ball[2]);

				//종료 조건
				if(end(ball)) break;
				
				ball[ball.length-1]++;
				for(int i=ball.length-1 ; i>=1 ; i--) {
					if(ball[i] >= col) {
						ball[i] %= col;
						ball[i-1]++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
		sc.close();		
	}
	
	public static void spread(int [][] tempArr, int [] ball) {
		for(int c=0 ; c<n ; c++) {
			int val = ball[c];
			
			for(int i=row-1 ; i>=0 ; i--) {
				if(tempArr[i][val] != 0) {
					solve(i, val, tempArr);
					break;
				}
			}
		}
	}
	
	public static void solve(int x, int y, int [][] tempArr) {
		Queue<Rock> q = new LinkedList<>();
		
		q.add(new Rock(x, y, tempArr[x][y]));
		tempArr[x][y] = 0;
		
		while(!q.isEmpty()) {
			Rock r = q.remove();
			int nx = r.x;
			int ny = r.y;
			int c = r.c;
			
			if(c >= 1) {
				//가로
				for(int i=Math.max(0, ny-c+1) ; i<=Math.min(col-1, ny+c-1) ; i++) {
					if(tempArr[nx][i] == 1) tempArr[nx][i] = 0;
					else if(tempArr[nx][i] >= 2) {
						q.add(new Rock(nx, i, tempArr[nx][i]));
						tempArr[nx][i] = 0;
					}
				}
				
				//세로
				for(int i=Math.max(0, nx-c+1) ; i<=Math.min(row-1, nx+c-1) ; i++) {
					if(tempArr[i][ny] == 1) tempArr[i][ny] = 0;
					else if(tempArr[i][ny] >= 2) {
						q.add(new Rock(i, ny, tempArr[i][ny]));
						tempArr[i][ny] = 0;
					}
				}
			}
		}
		
		blank(tempArr);
	}
	
	public static void blank(int [][] tempArr) {
		for(int j=0 ; j<col ; j++) {
			int [] temp = new int[row];
			int idx = 0;
			
			for(int i=0 ; i<row ; i++) {
				if(tempArr[i][j] != 0)
					temp[idx++] = tempArr[i][j];
			}
			
			for(int i=0 ; i<row ; i++) 
				tempArr[i][j] = temp[i];
		}
	}
	
	public static void calc(int [][] tempArr) {
		int res = 0;
		
		for(int [] temp : tempArr)
			for(int val : temp) 
				if(val != 0) res++;
		
		ans = Math.min(ans, res);
	}
	
	public static boolean end(int [] temp) {
		for(int i=0 ; i<temp.length ; i++) {
			if(temp[i] != col-1) return false;
		}
		return true;
	}
}

class Rock {
	int x; int y; int c;
	Rock(int x, int y, int c) {
		this.x = x; this.y = y; this.c = c;
	}
}
