package SS.last;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//아기 상어
public class Shark_16236 {
	static int n, x, y;
	static int [][] map;
	static boolean[][] visited;	
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];

		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();

				if(map[i][j]==9) {
					x=i; 
					y=j;
				}
			}

		visited = new boolean[n][n];
		solve();

		sc.close();
	}
	
	private static void solve() {
		Queue<Shark> q = new LinkedList<>();

		q.add(new Shark(x,y,2,0,0));
		visited[x][y] = true;

		int res = 0;

		while(!q.isEmpty()) {
			int eatX = 99, eatY = 99; 
			int eat=0, big=0, cnt=0;
			int size = q.size();
			
			for(int j=0;j<size;j++) {
				Shark shark = q.poll();
				
				for(int i=0;i<4;i++) {
					int nx = shark.x + dir[i][0];
					int ny = shark.y + dir[i][1];
					
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					if(visited[nx][ny]) continue;
					if(map[nx][ny] > shark.big) continue;
					
					visited[nx][ny]=true;
					q.add(new Shark(nx, ny, shark.big, shark.eat, shark.cnt+1));
					
					if(map[nx][ny]!=0 && map[nx][ny] != shark.big) { //우선 : 위 -> 좌
						if(nx < eatX) {
							eatX = nx; eatY = ny; eat = shark.eat; big = shark.big; cnt = shark.cnt+1;
						} else if(nx==eatX) {
							if(ny < eatY) {
								eatX = nx; eatY = ny; eat = shark.eat; big = shark.big; cnt = shark.cnt+1;
							}
						}
					}
				}
			}
			
			if(eatX != 99) { //먹었다면....
				eat++;
				
				if(eat == big) {
					big++;
					eat=0;
				}

				map[x][y] = 0;
				map[eatX][eatY] = 9;
				res += cnt;
				x = eatX; y = eatY;

				for(boolean [] tempArr : visited) 
					Arrays.fill(tempArr, false);

				q.clear();
				visited[eatX][eatY] = true;
				q.add(new Shark(eatX,eatY,big,eat,0));
			}
		}

		System.out.println(res);
	}
}

class Shark{
	int x, y, big, eat, cnt;
	Shark(int x,int y,int big,int eat,int cnt){
		this.x = x; this.y = y; this.big = big; this.eat = eat; this.cnt = cnt;
	}
}