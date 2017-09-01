package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Test {
	static int [] dist;
	static ArrayList<ArrayList<Pair>> adj;
	static boolean [] ans;
	
	static class Pair implements Comparable<Pair>
	{
		public int to;
		public int via;
		public int cost;
		public Pair(int t, int c, int v)
		{
			to = t;
			cost = c;
			via = v;
		}
		public int compareTo(Pair p)
		{
			
			return this.cost - p.cost;
		}
	}
	public static void main(String args[]) throws Exception	{
	    Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int n, m, s, e, w;
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			n = sc.nextInt();
			m = sc.nextInt();
			dist = new int [n];
			adj = new ArrayList<ArrayList<Pair>>();
			ans = new boolean [n];
			
			for (int i=0; i<n; i++) 
				adj.add(new ArrayList<Pair>());
			

			for (int i=0; i<m; i++) {
				s = sc.nextInt();
				e = sc.nextInt();
				w = sc.nextInt();
				adj.get(s-1).add(new Pair(e-1, w, s-1));
				adj.get(e-1).add(new Pair(s-1, w, e-1));
			}
			
			for (int i=0; i<n; i++)
				dikstra(i);
			
			System.out.printf("Case #%d\n", test_case+1);
			
			int ansCnt = 0;
			for (int i=0; i<n; i++) 
				if (!ans[i])
					ansCnt++;
			
				
			System.out.print(ansCnt);
			for (int i=0; i<n; i++) 
				if (!ans[i])
					System.out.printf(" %d", i+1);
			System.out.println();
				
		}
		
	}
	
	static void dikstra(int s)
	{
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		q.add(new Pair(s, 0, s));
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int from_idx = p.to;
			int from_cost = p.cost;
			if (from_cost > dist[from_idx])
				continue;
			if (p.via != s)
				ans[p.via] = true;
			
			ArrayList<Pair> from_node = adj.get(from_idx);
			
			for (int i=0; i<from_node.size(); i++) {
				int to_idx = from_node.get(i).to;
				int to_cost = from_node.get(i).cost;
				
				if (dist[to_idx] >= from_cost + to_cost) {
					dist[to_idx] = from_cost + to_cost;
					q.add(new Pair(to_idx, from_cost + to_cost, from_idx));
				}
			}
		}
	}
}