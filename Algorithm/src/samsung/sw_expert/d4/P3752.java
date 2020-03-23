package samsung.sw_expert.d4;

import java.util.Scanner;

//3752번 최솟값으로 이동하기
public class P3752 {
	static int n, ans;
	static int [] arr;
	static boolean [] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			
			ans = 0;
			visited = new boolean[10001];
			arr = new int[n];
			
			for(int i=0 ; i<n ; i++)
				arr[i] = sc.nextInt();
			
			visited[0] = true;
			
			for(int j=0 ; j<arr.length ; j++) {
				for(int k=visited.length-1 ; k>=0 ; k--) {
					if(visited[k]) visited[k+arr[j]] = true;
				}
			}
			
			for(int j=0 ; j<visited.length ; j++) {
				if(visited[j]) ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}