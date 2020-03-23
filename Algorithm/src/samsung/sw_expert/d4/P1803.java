package samsung.sw_expert.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1803번 Shortest Path Faster
public class P1803 {
	static int n, m, s, e;
	static long ans;
	static ArrayList<ArrayList<Node>> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			s = sc.nextInt();
			e = sc.nextInt();

			ans = 0;
			list = new ArrayList<>();
			for(int i=0 ; i<=n ; i++) list.add(new ArrayList<>());

			for(int i=0 ; i<m ; i++) {
				int startN = sc.nextInt();
				int endN = sc.nextInt();
				long cost = sc.nextLong();
				
				list.get(startN).add(new Node(endN, cost));
				list.get(endN).add(new Node(startN, cost));
			}

			if(s!= e) {
				dfs(s);
				System.out.println("#" + tc + " " + ans);}
			else 
				System.out.println("#" + tc + " " + 0);
		}
		sc.close();
	}

	public static void dfs(int start) {
		long [] distance = new long[n+1];
		
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[start] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while(!q.isEmpty()) {
			int idx = q.remove();
			
			for(int i=0 ; i<list.get(idx).size() ; i++) {
				int end = list.get(idx).get(i).v;
				long cost = list.get(idx).get(i).w;
				
				if(distance[end] > distance[idx] + cost) {
					distance[end] = distance[idx] + cost;
					q.add(end);
				}
			}
		}
		ans = distance[e];
	}
}

class Node {
	int v; long w;
	Node(int v,long w) {
		this.v = v; this.w = w;
	}
}