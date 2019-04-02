package backjun.p3000_4000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3055 {
	static int r, c; 
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	static char [][] map;
	static Queue<Dot> q, water;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();

		map = new char[r][c];
		
		q = new LinkedList<>();
		water = new LinkedList<>();

		for(int i=0 ; i<r ; i++) {
			char [] input= sc.next().toCharArray();

			for(int j=0; j<c ; j++) {
				map[i][j] = input[j];
				
				if(input[j] == '*') {
					water.add(new Dot(i, j));
				}
				
				if(input[j] == 'S') {
					q.add(new Dot(i, j));
				}
			}
		}
		
		int ans = 0;
		while(true) {
			ans++;
			if(q.size() == 0) {
				System.out.println("KAKTUS");
				return;
			}
			
			spreadWater();
			if(spreadDog()) {
				System.out.println(ans);
				return;
			}
		}
	}
	
	public static void spreadWater() {
		int size = water.size();
		
		for(int i=0 ; i<size ; i++) {
			Dot d = water.poll();
			
			for(int j=0 ; j<4 ; j++) {
				int nx = d.x + dx[j];
				int ny = d.y + dy[j];
				
				if(0<=nx && 0<=ny && nx<r && ny<c) {
					if(map[nx][ny] == '.') {
						map[nx][ny] = '*';
						water.add(new Dot(nx, ny));
					}
				}
			}
		}
	}

	public static boolean spreadDog() {
		int size = q.size();
		
		for(int i=0; i<size ; i++) {
			Dot d = q.poll();
			
			for(int j=0 ; j<4 ; j++) {
				int nx = d.x + dx[j];
				int ny = d.y + dy[j];
				
				if(0<=nx && nx<r && 0<=ny && ny<c) {
					if(map[nx][ny] == 'D') {
						q.add(new Dot(nx, ny));
						return true;
					}
					if(map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						q.add(new Dot(nx, ny));
					}
				}
			}
		}
		return false;
	}
}

class Dot {
	int x; int y;
	Dot(int x, int y) {
		this.x=x; this.y=y;
	}
}
