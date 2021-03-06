package samsung.last;

import java.util.Arrays;
import java.util.Scanner;

//백준 뱀 3190
public class SnakeTwo_3190 {
	static int [][] map;
	static int [][] mapDir;
	static int [] time = new int[10001];
	static int BLANK = 0;
	static int APPLE = 1;
	static int SNAKE = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int appleCount = sc.nextInt();
		
		map = new int[n][n];
		mapDir = new int[n][n];
		
		for(int [] temp : map) 
			Arrays.fill(temp, BLANK);
		
		Arrays.fill(time, BLANK);

		for(int i=0 ; i< appleCount ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[y-1][x-1] = APPLE;
		}
		
		int count = 0;
		int curDir = 0;
		int x = 0,  y = 0;
		int tailX = 0, tailY = 0;
		
		map[x][y] = SNAKE;
		mapDir[x][y] = curDir;

		int moveCount = sc.nextInt();
		
		for(int i=0 ; i<moveCount ; i++) {
			int t = sc.nextInt();
			int d = sc.next().equals("L") ? 1 : -1;
			time[t] = d;
		}
		
		for(int i=1 ; i<=10000 ; i++) {
			count++;
			
			mapDir[x][y] = curDir;
			
			if(curDir == 0) x++;
			else if(curDir == 1) y--;
			else if(curDir == 2) x--;
			else y++;
			
			if(x < 0 || y < 0 || x >= n || y >= n) {
				System.out.println(count);
				break;
			}
			
			if(map[x][y] == APPLE) 
				map[x][y] = SNAKE;
			else if(map[x][y] == SNAKE) {
				System.out.println(count);
				break;
			} else {
				map[x][y] = SNAKE;
				map[tailX][tailY] = BLANK;
				if(mapDir[tailX][tailY] == 0) tailX++;
				else if(mapDir[tailX][tailY] == 1) tailY--;
				else if(mapDir[tailX][tailY] == 2) tailX--;
				else if(mapDir[tailX][tailY] == 3) tailY++;
			}
			
			if(time[count] != 0) 
				curDir = (curDir + time[count] + 4) % 4;
		}
		
		sc.close();
	}
}

class P3190 {
	int time;
	int dir;
	
	P3190(int time, int dir) {
		this.time = time;
		this.dir = dir;
	}
}
