package SS.last;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab2_17142 {

	static int n, m, min = Integer.MAX_VALUE;
	static int [][] map;
	
	static ArrayList<Virus> virus, selected;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		virus = new ArrayList<>();
		map = new int[n][n];

		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2)
					virus.add(new Virus(i, j));
			}
		}

		for(int i=0; i<virus.size() ; i++) {
			selected = new ArrayList<>();
			selected.add(virus.get(i));
			dfs(i, 1, m);
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else 
			System.out.println(min);

		sc.close();
	}

	public static void dfs(int v, int cnt, int limit) {
		if(cnt == limit) {
			int res = spread();
			
			if(res >= 0 && min > res) {
				min = res;
			}
		} else {
			int size = virus.size();

			for(int i=v+1 ; i<size ; i++) {
				selected.add(virus.get(i));
				dfs(i, cnt+1, limit);
			}
		}

		selected.remove(selected.size() - 1); //back_tracking
	}

	public static int spread() {
		Queue<Virus> q = new LinkedList<>();
		q.addAll(selected);
		
		int [][] copyMap = new int[n][n];
		boolean [][] visited = new boolean[n][n];
		int time = 0;
		int temp = 0;
		
		for(int i=0 ; i<n ; i++) 
			for(int j=0 ; j<n ; j++)
				copyMap[i][j] = map[i][j];
		
		while(!q.isEmpty()) {
			int size = q.size();
			boolean blank = false; //근접에 비활성화 바이러스 칸이 존재할 수 있음
			
			for(int i=0 ; i<size ; i++) {
				Virus v = q.poll();
				
				int x = v.x;
				int y = v.y;
				visited[x][y] = true;
				
				
				for(int d=0 ; d<4 ; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					if(visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					
					if(copyMap[nx][ny] == 0) {
						blank = true;
						copyMap[nx][ny] = 3;
						q.add(new Virus(nx, ny));
					} else if(copyMap[nx][ny] == 2) {
						q.add(new Virus(nx, ny));
					}
				}
				
			}
			
			if(!blank) {
				temp++;
			} else {
				time += ++temp;
				temp = 0;
			}
		}
		
		if(!check(copyMap))
			return -1;
		
		return time;
	}

	public static boolean check(int[][] map) {
		for(int [] temp : map)
			for(int val : temp)
				if(val == 0) return false;			

		return true;
	}

}

class Virus {
	int x; int y;
	Virus(int x, int y) {
		this.x = x; this.y = y;
	}
}
