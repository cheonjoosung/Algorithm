package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//CodeGround 15번 캠퍼스와 도로(1)
public class Sol15 {
	static int N;
	static int R;
	static int MAX = 987_654_321;
	static boolean [] VIA;
	static ArrayList<ArrayList<P15>> LIST;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			N = sc.nextInt();
			R = sc.nextInt();

			VIA = new boolean[N+1];
			LIST = new ArrayList<>(N+1);

			for(int i=0 ; i<=N ; i++)
				LIST.add(new ArrayList<P15>());

			for(int i=0 ; i<R ; i++) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				int cost = sc.nextInt();

				LIST.get(s).add(new P15(d, cost));
				LIST.get(d).add(new P15(s, cost));
			}

			for(int i=1 ; i<= N ; i++)
				find(i);

			int count = 0;

			for(int i=1 ; i <= N ; i++)
				if(!VIA[i]) count++;

			System.out.println("Case #"+(test_case+1));
			System.out.print(count);

			for(int i=1 ; i <= N ; i++)
				if(!VIA[i]) System.out.print(" " + i);
			System.out.println();
		}
	}

	public static void find(int s) {
		PriorityQueue<P15> Q = new PriorityQueue<>();
		int [] dist = new int[N+1];
		ArrayList<ArrayList<Integer>> viaList = new ArrayList<>();
		Arrays.fill(dist, MAX);
		dist[s] = 0;

		for(int i=0 ; i<=N ; i++)
			viaList.add(new ArrayList<Integer>()); //시작점부터 어느지점까지 최단경로를 저장하기 위한 목록

		Q.add(new P15(s, dist[s]));  //시작점 큐에 삽입

		while(!Q.isEmpty()) {
			P15 P = Q.poll();
			int p = P.dest;

			//p 에서 갈수 있는 지점을 하나씩 찾는다 
			for(P15 V : LIST.get(p)) {
				int v = V.dest;

				ArrayList<Integer> Via = viaList.get(v);

				int alt = V.cost + dist[p];

				if(alt < dist[v]){// 새로운 최단거리 발견하면 d[v] 업데이트. Via 경로를클리어하고 p경로 추가
					dist[v] = alt;
					Via.clear();
					if(s != p) Via.add(p);
					Q.add(new P15(v, dist[v]));
				} else if(alt == dist[v]){// 기존의 최단 거리왁 ㅏㅌ은 경로 발견하면 Via 에 u를 추가
					Via.add(p);
				}
			}
		}

		//중복된 길을 포함해서 경로에 있는 대학 번호를 추가
		System.out.println("\nStart : " + s);
		int count = 1;
		for(ArrayList<Integer> temp : viaList) {
			System.out.print(count + " ");
			for(Integer i : temp) {
				System.out.print(i + " -> ");
				VIA[i] = true;
			}
			count++;
			System.out.println();
		}
		
		System.out.println("#################");
		for(int i=1 ; i < dist.length ; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println("#################");
	}
}

class P15 implements Comparable<P15> {
	int dest, cost;

	P15(int dest, int cost) {
		this.dest = dest;
		this.cost = cost;
	}

	@Override
	public int compareTo(P15 o) {
		return this.cost - o.cost;
	}

}
