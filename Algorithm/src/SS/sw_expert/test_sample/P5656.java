package SS.sw_expert.test_sample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//벽돌 깨기
public class P5656 {
	static int [][] map;
	static int [] arr;
	static int ans, n, row, col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt(); //시작 칼럼 위치
			col = sc.nextInt();
			row = sc.nextInt();

			ans = Integer.MAX_VALUE;
			
			map = new int[row][col];
			arr = new int[n]; //공이 떨어질 위치 정하기

			for(int i=row-1 ; i>=0 ; i--)
				for(int j=0 ; j<col ; j++)
					map[i][j] = sc.nextInt();

			while(true) {
				int [][] temp = new int[row][col];

				for(int i=0 ; i<row ; i++)
					temp[i] = map[i].clone();

				rocket(temp);
				calc(temp);

				arr[0]++;
				for(int i=0 ; i<n ; i++) {
					if(arr[i] >= col) {
						arr[i] %= col;
						if(i != n-1) arr[i+1]++;
					}
				}

				if(isEnd()) break;
			}

			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	public static boolean isEnd() {		
		for(int i=0 ; i<n ; i++)
			if(arr[i] != col-1) return false;
		
		return true;
	}
	
	public static void calc(int [][] temp) {
		int cnt = 0;

		for(int [] tempArr : temp)
			for(int tempVal : tempArr)
				if(tempVal != 0) cnt++;

		ans = Math.min(ans, cnt);
	}

	public static void rocket(int [][] temp) {
		for(int i=0 ; i<n ; i++) {
			int pos = arr[i];

			for(int j=row-1 ; j>=0 ; j--) {
				if(temp[j][pos] != 0) {
					bomb(j, pos, temp);
					break;
				}
			}
		}
	}

	public static void bomb(int x, int y, int [][] temp) {
		Queue<Bomb> q = new LinkedList<>();

		q.add(new Bomb(x, y, temp[x][y]));
		temp[x][y] = 0;

		while(!q.isEmpty()) {
			Bomb bomb = q.remove();
			int xPos = bomb.x;
			int yPos = bomb.y;
			int bombRange = bomb.c;

			if(bomb.c >= 1) {				
				for(int i=Math.max(0, yPos-bombRange+1) ; i<=Math.min(col-1, yPos+bombRange-1) ; i++)  {
					if(temp[xPos][i] == 1) temp[xPos][i] = 0;
					else if(temp[xPos][i] > 1) {
						q.add(new Bomb(xPos, i, temp[xPos][i]));
						temp[xPos][i] = 0;
					}
				}

				for(int i=Math.max(0, xPos-bombRange+1) ; i<=Math.min(row-1, xPos+bombRange-1) ; i++)  {					
					if(temp[i][yPos] == 1) temp[i][yPos] = 0;
					else if(temp[i][yPos] > 1) {
						q.add(new Bomb(i, yPos, temp[i][yPos]));
						temp[i][yPos] = 0;
					}
				}
			}

		}
		
		clearBlank(temp);
	}

	public static void clearBlank(int [][] temp) {
		for(int j=0 ; j<col ; j++) {
			int [] copy = new int[row];
			int idx = 0;

			for(int i=0 ; i<row ; i++)
				if(temp[i][j] != 0) copy[idx++] = temp[i][j];

			for(int i=0 ; i<row ; i++)
				temp[i][j] = copy[i];
		}
	}
}

class Bomb {
	int x, y, c;
	Bomb(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
