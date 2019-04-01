package test;

import java.util.Scanner;

public class Main {
	static int N, M, K, T;
	static int [][] MAP;
	static boolean isPossible;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	static boolean [][] visited;
	static Shark s;
	static int desX, desY, desMove;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		MAP = new int[N][N];
		T = 0;

		for(int i=0 ; i<N ; i++)
			for(int j=0 ; j<N ; j++) {
				MAP[i][j] = sc.nextInt();
				if(MAP[i][j] == 9) {
					s = new Shark(i, j, 2, 0);
				}
			}

		isPossible = true;
		while(isPossible) {
			isPossible = false;

			/*
			 * 1.먹을수 있는 물고기 찾기
			 * 2.그 물고기 위치로 이동
			 */
			visited = new boolean[N][N];
			desX = Integer.MAX_VALUE; desY = Integer.MAX_VALUE; desMove = -1;

			visited[s.x][s.y] = true;
			dfs(s.x, s.y, 0);
			visited[s.x][s.y] = false;

			if(isPossible) { //가능하면 갱신
				MAP[s.x][s.y] = 0;
				s.x = desX;
				s.y = desY;
				s.eating();
				MAP[s.x][s.y] = 0;
				T += desMove;
			}
		}

		System.out.println(T);

		sc.close();
	}

	public static void dfs(int x, int y, int move) {
		if(MAP[x][y] < s.size && MAP[x][y] >= 1) {
			//갱신
			if(desMove == -1){
				isPossible = true;
				desX = x;
				desY = y;
				desMove = move;
			} else {
				if(desMove > move) { 
					isPossible = true;
					desX = x;
					desY = y;
					desMove = move;
				} if(desMove == move) {
					isPossible = true;
					if(desX < x) {
						desX = x;
						desY = y;
					} else if(desX == x) {
						if(desY > y) 
							desY = y;
					}
				}
			}
		}

		for(int d=0 ; d<4 ; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(MAP[nx][ny] > s.size) continue;
			if(visited[nx][ny]) continue;
			if(MAP[nx][ny] == 9) continue;

			visited[nx][ny] = true;
			dfs(nx, ny, move+1);
			visited[nx][ny] = false;
		}
	}
}


class Shark {
	int x; int y; int size; int eat;
	Shark(int x, int y, int size, int eat) {
		this.x = x; this.y = y; this.size = size; this.eat = eat;
	}

	void eating() {
		this.eat++;
		if(this.size == this.eat) {
			this.eat = 0;
			this.size++;
		}
	}
}