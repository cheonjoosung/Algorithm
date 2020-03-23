package samsung.sw_expert.d4;

import java.util.HashMap;
import java.util.Scanner;

//2819번 격자판의 숫자 이어 붙이기
public class P2819 {
	static int n, num, ans;
	static HashMap<String,Integer> hash;
	static int [][] arr;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;
			arr = new int[4][4];
			hash = new HashMap<>();

			for(int i=0 ; i<4 ; i++)
				for(int j=0 ; j<4 ; j++)
					arr[i][j] = sc.nextInt();
	
			
			
			for(int i=0 ; i<4 ; i++)
				for(int j=0 ; j<4 ; j++) {
					dfs(i, j, 1, String.valueOf(arr[i][j]));
				}
			
			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}
	
	public static void dfs(int x, int y, int cnt, String res) {
		if(cnt == 7) {
			if(!hash.containsKey(res)) {
				hash.put(res, 1);
				ans++;
			}
			return;
		}
		
		for(int d=0 ; d<4 ; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0 || ny<0 || nx>=4 || ny>=4) continue;
			dfs(nx, ny, cnt+1, res.concat(String.valueOf(arr[nx][ny])));
		}
	}
}