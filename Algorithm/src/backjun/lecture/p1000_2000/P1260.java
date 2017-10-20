package backjun.lecture.p1000_2000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vertex = sc.nextInt();
		int count = sc.nextInt();
		int startPoint = sc.nextInt();
		int [][] arr = new int[vertex+1][vertex+1];
		
		for(int [] temp : arr)
			Arrays.fill(temp, 0);
		
		boolean [] visited = new boolean[vertex+1];
		Arrays.fill(visited, false);
		
		for(int i=0 ; i<count ; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		dfs(startPoint, vertex, arr, visited);
		
		visited = new boolean[vertex+1];
		Arrays.fill(visited, false);
		System.out.println();
		bfs(startPoint, vertex, arr, visited);
		
		sc.close();
	}
	
	public static void dfs(int start, int size, int [][] arr, boolean [] visited) {
		System.out.print(start + " ");
		visited[start] = true;
		for(int i=1; i<=size ; i++) {
			if(arr[start][i] == 1 && !visited[i]) dfs(i, size, arr, visited);
		}
	}
	
	public static void bfs(int start, int size, int [][] arr, boolean [] visited) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		System.out.print(start + " ");
		
		int val = 0;
		
		while(!q.isEmpty()) {
			val = q.poll();
			for(int i=1 ; i<=size ; i++) {
				if(arr[val][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}