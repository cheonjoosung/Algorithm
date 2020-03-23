package samsung.sw_expert.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1868번 파핑파핑 지뢰찾기
public class P1868 {
	static int n, num;
	static int ans;
	static int [][] arr;
	static int [] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int [] dy = {1, 1, 0, -1, -1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();

			ans = 0;
			arr = new int[n][n];

			for(int i=0 ; i<n ; i++) {
				String s = sc.next();
				for(int j=0 ; j<n ; j++) {
					if(s.charAt(j) == '.') arr[i][j] = -1; //안지뢰
					else arr[i][j] = -2; //지뢰
				}
			}

			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(arr[i][j] == -1 && isNonBomb(i,j)) {
						arr[i][j] = 0;
						ans++;
						solve(i, j);
					}
				}
			}
			
			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++)
					if(arr[i][j] == -1) ans++;
			
			
			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}

	public static void solve(int x, int y) {
		Queue<Bomb> q = new LinkedList<>();
		q.add(new Bomb(x, y));
		
		while(!q.isEmpty()) {
			Bomb b = q.remove();
			
			for(int i=0 ; i<8 ; i++) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(arr[nx][ny] == -1) {
					arr[nx][ny] = 5;
					if(isNonBomb(nx,ny))
						q.add(new Bomb(nx, ny));
				}
			}
			
		}
	}
	
	public static boolean isNonBomb(int x, int y) {
		boolean res = true;
		
		for(int i=0 ; i<8 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if(arr[nx][ny] == -2) {
				res = false;
				break;
			}
		}
		
		return res;
	}
}

class Bomb{
	int x; int y;
	Bomb(int x, int y) {
		this.x = x; this.y = y;
	}
}
