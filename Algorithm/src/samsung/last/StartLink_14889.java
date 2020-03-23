package samsung.last;

import java.util.Scanner;

////백준 14889 스타트와 링크
public class StartLink_14889 {
	static int n, Ans;
	static int [][] map;
	static boolean [] isVisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		Ans = Integer.MAX_VALUE;
		map = new int[n+1][n+1];
		isVisited = new boolean[n+1]; //팀선택 표시를 위해서
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0 , 0);
		System.out.println(Ans);
		
		sc.close();
	}
	
	public static void dfs(int v, int cnt) {
		if(cnt == (n/2)) {
			calc();
			return;
		}
		
		for(int i=v+1 ; i<=n ; i++) {
			if(isVisited[i]) continue;
			
			isVisited[i] = true;
			dfs(i, cnt+1);
			isVisited[i] = false;
		}
	}
	
	public static void calc() {
		int [] a = new int[(n/2) + 1];
		int [] b = new int[(n/2) + 1];
		
		int aIdx = 1, bIdx = 1; //스타트와 링크팀
		for(int i=1 ; i<=n ; i++) {
			if(isVisited[i]) a[aIdx++] = i;
			else b[bIdx++] = i;
		}
		
		int resA = getScore(a);
		int resB = getScore(b);
		Ans = Math.min(Ans, Math.abs(resA-resB));
	}
	
	public static int getScore(int [] arr) {
		int res = 0;
		int len = n/2;
		
		for(int i=1 ; i<=len ; i++) {
			for(int j=i+1 ; j<=len ; j++) {
				res += map[arr[i]][arr[j]];
				res += map[arr[j]][arr[i]];
			}
		}
		
		return res;
	}
}