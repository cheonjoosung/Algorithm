package SS.sw_expert.d3;

import java.util.Scanner;

//햄버거 다이어트
public class P5215 {
	static int n, l, ans;
	static boolean [] visited;
	static int [] a, b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			n = sc.nextInt(); //수
			l = sc.nextInt(); //칼로리
			
			a = new int[n];
			b = new int[n];
			visited = new boolean[n];
			
			ans = 0;
			
			for(int i=0 ; i<n ; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}

			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
	
	public static void dfs(int c, int t, int k) {
		if(c == n) {
			if(k <= l && ans < t) ans = t;
			return;
		}
		
		if(k + b[c] <= l)
			dfs(c+1, t+a[c], k+b[c]);
		dfs(c+1, t, k);
	}
}