package exam;

import java.util.Scanner;

public class Sol02 {
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] v = {20, 8, 10, 1, 4 , 15};
		int [] res = new int[v.length];
		boolean [] visited = new boolean[v.length];
		
		ans = 0;
		
		dfs(v, res, visited, 0, v.length);
		System.out.println(ans);
		sc.close();
	}
	
	public static void dfs(int [] arr, int [] temp, boolean [] visited, int cnt, int size) {
		if(cnt == size) {
			int res = calc(temp);
			ans = Math.max(ans, res);
			return;
		}
		
		for(int i=0 ; i<size ; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			temp[cnt] = arr[i]; 
			dfs(arr, temp, visited, cnt+1, size);
			visited[i] = false;
			
		}
		
	}
	
	public static int calc(int [] temp) {
		int res = 0;
		
		for(int i=1 ; i<temp.length ; i++) {
			res += Math.abs(temp[i] - temp[i-1]);
		}
		
		return res;
	}
}
