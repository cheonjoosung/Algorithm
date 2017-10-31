package backjun.p3000_4000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3184 {
	static int [][] map;
	static int Road = 0;
	static int Wall = 3;
	static int Wolf = 1;
	static int Lamb = 2;
	
	static int row;
	static int col;
	
	static int [] dx = {1 , 0, -1, 0};
	static int [] dy = {0 , -1, 0, 1};
	
	static int TotalLamb;
	static int TotalWolf;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		col = sc.nextInt();
		row = sc.nextInt();

		map = new int[row][col];
		
		TotalLamb = 0;
		TotalWolf = 0;

		for(int i=0 ; i<col ; i++) {
			String s = sc.next();
			for(int j=0 ; j<row ; j++) {
				if(s.charAt(j) == '.') map[j][i] = Road;
				else if(s.charAt(j) == '#') map[j][i] = Wall;
				else if(s.charAt(j) == 'o') map[j][i] = Lamb;
				else if(s.charAt(j) == 'v') map[j][i] = Wolf;
			}
		}

		for(int i=0 ; i<col ; i++) {
			for(int j=0 ; j<row ; j++) {
				if(map[j][i] == Wall) continue;
				else {
					bfs(j, i);
				}
			}
		}
		
		System.out.println(TotalLamb + " " + TotalWolf);

		sc.close();
	}
	
	public static void bfs(int x, int y) {
		int lambCount = 0;
		int wolfCount = 0;
		
		if(map[x][y] == Lamb) lambCount++;
		else if(map[x][y] == Wolf) wolfCount++;
		map[x][y] = Wall;
		
		Queue<PointP3184> q = new LinkedList<>();
		q.add(new PointP3184(x, y));
		
		while(!q.isEmpty()) {
			PointP3184 temp = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
				if(map[nextX][nextY] == Wall) continue;
				
				if(map[nextX][nextY] == Lamb) lambCount++;
				else if(map[nextX][nextY] == Wolf) wolfCount++;
				map[nextX][nextY] = Wall;
				
				q.add(new PointP3184(nextX, nextY));
			}
		}
		
		if(lambCount <= wolfCount) TotalWolf += wolfCount;
		else {
			TotalLamb += lambCount;
		}
	}
}

class PointP3184 {
	int x, y;
	public PointP3184(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
