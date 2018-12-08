package SS.sw_expert.d4;

import java.util.Scanner;

//[S/W 문제해결 기본] 2일차 - Ladder1
public class P1226 {
	static int sx, sy, fx, fy, ans, finalY;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();

			map = new int[16][16];
			visited = new boolean[16][16];

			ans = 0;

			for(int i=0 ; i<16 ; i++) {
				String s = sc.next();
				for(int j=0 ; j<16 ; j++) {
					map[i][j] = Integer.parseInt(s.charAt(j)+"");
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}
				}
			}

			if(find(sx, sy) > 0) 
				System.out.println("#" + t + " " + 1);
			else 
				System.out.println("#" + t + " " + 0);
		}
		
		sc.close();
	}

	public static int find(int x, int y) {		
		int res = 0;
		if(map[x][y] == 1 || visited[x][y]) return 0;
		else if(map[x][y] == 3) return 1;
		else {
			visited[x][y] = true;
			res += find(x-1, y);
			res += find(x+1, y);
			res += find(x, y-1);
			res += find(x, y+1);
			visited[x][y] = false;

			return res;
		}

	}
}