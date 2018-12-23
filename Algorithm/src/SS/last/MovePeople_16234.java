package SS.last;

import java.util.ArrayList;
import java.util.Scanner;

//인구이동
public class MovePeople_16234 {
	static int n, ans, l, r;
	
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	static int [][] map;
	static boolean [][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		ans = 0; //인구이동수
		map = new int[n][n];

		for(int i=0 ; i<n ; i++) 
			for(int j=0 ; j<n ; j++)
				map[i][j] = sc.nextInt();
		
		while(true) {
			visited = new boolean[n][n];
			
			if(!check()) ans++;
			else break;		
		}

		System.out.println(ans);
		sc.close();
	}
	
	public static boolean check() {
		ArrayList<City> list;
		boolean isEnd = true;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(visited[i][j]) continue;
				
				list = new ArrayList<>();
				list.add(new City(i, j));
				
				int sum = dfs(i, j, list, 0);
				if(list.size() > 1) {
					changeMap(sum, list);
					isEnd = false;
				}
			}
		}
		return isEnd;
	}
	
	public static int dfs(int x, int y, ArrayList<City> list, int sum) {
		visited[x][y] = true;
		sum = map[x][y];
		
		for(int d=0 ; d<4 ; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if(visited[nx][ny]) continue;
			
			int diffVal = Math.abs(map[x][y]-map[nx][ny]);
			if(diffVal >= l && diffVal <= r) {
				list.add(new City(nx, ny));
				sum += dfs(nx, ny, list, sum);
			}
		}
		
		return sum;
	}
	
	public static void changeMap(int sum, ArrayList<City> list) {
		int avg = sum/list.size();
		
		for(City city : list) 
			map[city.x][city.y] = avg;
	}
}

class City {
	int x; int y;
	City(int x, int y) {
		this.x = x; this.y = y;
	}
}