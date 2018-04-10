package SS;

import java.util.Scanner;

public class Main {
	static int n;
	static int [] arr;
	static int [] op; // 0 plus, 1 minus, 2 mul, 3 div
	static boolean [] visited;

	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		arr = new int[n];
		op = new int[n-1];
		visited = new boolean[n-1];

		int idx = 0;

		for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt();
		
		for(int j=0 ; j<4 ; j++) {
			int val = sc.nextInt();
			for(int k=0 ; k<val ; k++) {
				if(j == 0) op[idx++] = 0;
				else if(j == 1) op[idx++] = 1;
				else if(j == 2) op[idx++] = 2;
				else if(j == 3) op[idx++] = 3;
			}
		}

		dfs(0, 1, arr[0], 0);

		System.out.println(MAX);
		System.out.println(MIN);

		sc.close();
	}

	public static void dfs(int start, int step, int sum, int len) {
		int res = 0;

		if(len == n-1) {
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
		} else {
			for(int i=0 ; i<n-1 ; i++) {
				if(!visited[i]) {
					System.out.println(" " + i);
					if(op[i] == 0) res = sum + arr[step];
					else if(op[i] == 1) res = sum - arr[step];
					else if(op[i] == 2) res = sum * arr[step];
					else res = sum / arr[step];

					visited[i] = true;
					//연산자 꺼내서 더해서 넘겨야 겠네
					dfs(i, step+1, res, len+1);			
				}
			}
		}
		
		System.out.println("END");
		visited[start] = false;
	}
}
