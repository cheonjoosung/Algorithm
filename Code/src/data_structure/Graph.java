package data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private boolean [] isVisited = new boolean[10];
	public static int [][] map = new int[10][10];
	
	
	public void dfs(int index) {
		isVisited[index] = true;
		
		for(int i=1 ; i<10 ; i++) {
			if(map[index][i] == 1 && !isVisited[i]) dfs(index);
		}
	}
	
	public void bfs(int index) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(index);
		isVisited[index] = true;
		
		while(!q.isEmpty()) {
			int val = q.poll();
			
			for(int i=1; i<=10 ; i++) {
				if(map[val][i] == 1 && isVisited[val]) {
					q.offer(i);
					isVisited[i] = true;
				}
			}
		}
	}
}
