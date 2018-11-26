package SS.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//6057번 그래프의 삼각형
public class P6057 {
	static int ans, n, m;
	static int [][] map;
	static boolean [] visited;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			ans = 0;
			visited = new boolean[n+1];
			map = new int[n+1][n+1];
			list = new ArrayList<>();

			for(int i=0 ; i<m ; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				map[s][e] = 1;
				map[e][s] = 1;
			}

			dfs(0, 1);

			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}
	
	public static void dfs(int cnt, int idx) {
		if(cnt == 3) {
			//System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
			if(map[list.get(0)][list.get(1)] == 1 
					&& map[list.get(0)][list.get(2)] == 1
							&& map[list.get(1)][list.get(2)] == 1) 
				ans++;
			return;
		}
		
		for(int i=idx ; i<=n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(i);
				dfs(cnt+1, i+1);
				list.remove(list.indexOf(i));
				visited[i] = false;
			}
		}
	}
}
