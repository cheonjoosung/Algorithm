package backjun.p11000_12000;

import java.util.Scanner;

public class P11403 {
	static int size;
	static int [][] map;
	static int [][] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		map = new int[size][size];
		res = new int[size][size];

		//입력 
		for(int i=0 ; i<size ; i++)
			for(int j=0 ; j<size ; j++)
				map[j][i] = sc.nextInt();

		//DFS
		for(int i=0 ; i<size ; i++) {
			int [] visited = new int[size];
			dfs(map, visited, i, true);
			res[i] = visited;
		}


		//출력
		for(int i=0 ; i<size ; i++) {
			for(int j=0 ; j<size ; j++) {
				System.out.print(res[j][i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void dfs(int [][] map, int [] visited, int x, boolean isFirst) {
		if(!isFirst) visited[x] = 1;
		for(int i=0 ; i<map.length ; i++) {
			if(map[x][i] == 1 && visited[i] == 0) dfs(map, visited, i, false);
		}
	}
}
