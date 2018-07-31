package SS.last;

import java.util.Scanner;

//백준 14888 연산자
public class Operation_14888 {
	static int n, Min, Max;
	static int [] arr;
	static int [] op;
	static boolean [] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		op = new int[n-1];
		visited = new boolean[n-1];
		Min = Integer.MAX_VALUE;
		Max = Integer.MIN_VALUE;		
		
		for(int i=0 ; i<n ; i++)
			arr[i] = sc.nextInt();
		
		int idx = 0;
		for(int i=0 ; i<4 ; i++) { 
			// + , - , * , / 4개의 값 순서대로
			int val = sc.nextInt();
			
			for(int j=0 ; j<val ; j++) 
				op[idx++] = i;
		}
		
		dfs(1, arr[0] , 0);
		
		System.out.println(Max);
		System.out.println(Min);
		
		sc.close();
	}
	
	public static void dfs(int idx, int sum, int cnt) {
		int res = 0;
		
		if(cnt == (n-1)) {
			Max = Math.max(Max, sum);
			Min = Math.min(Min, sum);
			return;
		}
		
		for(int i=0 ; i<n-1 ; i++) {
			if(visited[i]) continue;
					
			visited[i] = true;
			switch(op[i]) {
			case 0:
				res = sum + arr[idx]; 
				break;
			case 1:
				res = sum - arr[idx]; 
				break;
			case 2:
				res = sum * arr[idx]; 
				break;
			case 3:
				res = sum / arr[idx]; 
				break;
			}
			
			dfs(idx+1, res, cnt+1);
			visited[i] = false;
		}
		
	}
}