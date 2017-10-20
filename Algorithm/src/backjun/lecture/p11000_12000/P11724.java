package backjun.lecture.p11000_12000;

import java.util.Arrays;
import java.util.Scanner;

public class P11724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vertex = sc.nextInt();
		int count = sc.nextInt();

		int Ans = 0;
		boolean [] visited = new boolean[vertex+1];
		Arrays.fill(visited, false);

		int [][] gragh = new int[vertex+1][vertex+1];

		for(int i=0 ; i<count ; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			gragh[s][e] = 1;
			gragh[e][s] = 1;
		}

		for(int i=1 ; i<=vertex ; i++) {
			if(!visited[i]){
				Ans++;
				dfs(gragh, i, vertex, visited);
			}
		}
		System.out.println(Ans);
		sc.close();
	}

	public static void dfs(int [][] gragh, int vertax, int size, boolean [] visited) {
		visited[vertax] = true;
		for(int j=1 ; j<=size ; j++) {
			if(!visited[j] && gragh[vertax][j] == 1) dfs(gragh, j, size, visited);
		}
	}
}
