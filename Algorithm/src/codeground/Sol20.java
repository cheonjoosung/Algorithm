package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//CodeGround 20번 캠퍼스와 도로(2)
public class Sol20 {
	static int N;
	static int R;
	static int MAX = 987_654_321;
	static boolean [] VIA;
	static ArrayList<ArrayList<P20>> LIST;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			N = sc.nextInt();
			R = sc.nextInt();

			VIA = new boolean[N+1];
			LIST = new ArrayList<>(N+1);

			Arrays.fill(VIA, false);

			for(int i=0 ; i<=N ; i++)
				LIST.add(new ArrayList<P20>());

			for(int i=0 ; i<R ; i++) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				int cost = sc.nextInt();

				LIST.get(s).add(new P20(d, cost));
				LIST.get(d).add(new P20(s, cost));
			}

			for(int i=1 ; i<= N ; i++)
				find(i);

			int count = 0;

			for(int i=1 ; i <= N ; i++)
				if(VIA[i]) count++;

			System.out.println("Case #"+(test_case+1));
			System.out.print(count);
			for(int i=1 ; i <= N ; i++)
				if(VIA[i]) System.out.print(" " + i);
			System.out.println();
		}
	}

	public static void find(int s) {
		//System.out.println("Start : " + s);
		PriorityQueue<P20> Q = new PriorityQueue<>();
		int [] dist = new int[N+1];
		ArrayList<ArrayList<Integer>> viaList = new ArrayList<>();
		Arrays.fill(dist, MAX);
		dist[s] = 0;

		for(int i=0 ; i<=N ; i++)
			viaList.add(new ArrayList<>());

		Q.add(new P20(s, dist[s]));

		while(!Q.isEmpty()) {
			P20 P = Q.poll();
			int p = P.dest;

			//p 에서 갈수 있는 지점을 하나씩 찾는다 
			for(P20 V : LIST.get(p)) {
				int v = V.dest;

				ArrayList<Integer> Via = viaList.get(v);

				int alt = V.cost + dist[p];

				if(alt < dist[v]){
					dist[v] = alt;
					Via.clear();

					if(s != p) { 
						Via.add(p);
						//System.out.println("Insert : " + p);
					}

					Q.add(new P20(v, dist[v]));
				} else if(alt == dist[v]){
					//System.out.println(alt + " , " + dist[v] + " : " + v + " , " + p);
					Via.add(p);
					Via.clear();
				}
			}
		}
		for(ArrayList<Integer> temp : viaList) {	
			for(Integer i : temp) {
				if(i != s) {
					VIA[i] = true;
				}
			}
		}
	}
}

class P20 implements Comparable<P20> {
	int dest, cost;

	P20(int dest, int cost) {
		this.dest = dest;
		this.cost = cost;
	}

	@Override
	public int compareTo(P20 o) {
		return this.cost - o.cost;
	}
}
