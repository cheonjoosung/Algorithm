package SS.last;

import java.util.Scanner;

public class Operation14888 {
	static boolean [] visited = new boolean[10];
	static int [] numbers = new int[11];
	static int [] op = new int[10];
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int idx = 0;

		for(int i=0 ; i<n ; i++) numbers[i] = sc.nextInt();
		for(int i=0 ; i<4 ; i++) {
			int cnt = sc.nextInt();
			for(int j=0 ; j<cnt ; j++) {
				op[idx++] = i+1;
			}
		}

		dfs(0, 1, numbers[0], 0);
		System.out.println(max);
		System.out.println(min);

		sc.close();
	}

	public static void dfs(int v, int idx, int num, int len) {
		int res = 0;
		
		if(len == n-1) {
			if(num > max) max = num;
			if(num < min) min = num;
		} else {
			for(int i=0 ; i<n-1 ; i++) {
				if(!visited[i]) {
					switch (op[i]) {
					case 1:
						res = num + numbers[idx];
						break;
					case 2:
						res = num - numbers[idx];
						break;
					case 3:
						res = num * numbers[idx];
						break;
					case 4:
						res = num / numbers[idx];
						break;
					}
					visited[i] = true;
					dfs(i, idx + 1, res, len+1);
				}
			}
		}

		visited[v] = false;
	}
}
