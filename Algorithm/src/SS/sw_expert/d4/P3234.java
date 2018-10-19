package SS.sw_expert.d4;

import java.util.Arrays;
import java.util.Scanner;

//3234번 준환이의 양팔저울
public class P3234 {
	static int n, total, ans;
	static int [] arr;
	static boolean [] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();

			arr = new int[n];
			visited = new boolean[n];
			ans = 0;
			total = 0;
			
			for(int i=0 ; i<n ; i++) {
				arr[i] = sc.nextInt();
				total += arr[i];
			}
			
			Arrays.sort(arr);
			solve(0, 0, 0, 0);

			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}

	static int[] cal = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	public static void solve(int idx, int lsum, int lcnt, int rsum) {
		if(idx == n) {
			ans++;
			return;
		}
		
		if(lsum >= (total-lsum)) {
			int t = n-idx;
			ans += Math.pow(2, t)*cal[t]; //2의n * n!
			return;
		}

		for(int i= 0 ; i<n ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			solve(idx+1, lsum+arr[i], lcnt+1, rsum);
			
			if(lsum >= rsum+arr[i])
				solve(idx+1, lsum, lcnt, rsum+arr[i]);
			
			visited[i] = false;
		}
	}
}