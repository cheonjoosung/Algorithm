package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test { 
	static int N, ROAD;
	static boolean [] isVia;
	static int MAX = 987_987_987;
	static ArrayList<ArrayList<P15>> List;

	public static void main(String args[]) throws Exception    {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			N = sc.nextInt();
			ROAD = sc.nextInt();
			
			isVia = new boolean[N+1];
			List = new ArrayList<>(N+1);
			
			for(int i=0 ; i<=N ; i++)
				List.add(new ArrayList<P15>());

			for(int i=0 ; i< ROAD ; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int dist = sc.nextInt();
				
				List.get(start).add(new P15(end, dist));
				List.get(end).add(new P15(start, dist));
			}
			
			for(int i = 1 ; i <= N ; i++)
				find(i);
			
			int count = 0;
			
			for(int i = 1 ; i <= N ; i++)
				if(!isVia[i]) count++;
			
			System.out.println("Case #"+(test_case+1));
			System.out.print(count);
			for(int i = 1 ; i <= N ; i++)
				if(!isVia[i]) System.out.print(" " + i);
			System.out.println();
				

		}
	}
	
	public static void find(int start) {
		PriorityQueue<P15> q = new PriorityQueue<>();
		ArrayList<ArrayList<Integer>> viaList = new ArrayList<>();
		
		int [] d = new int[N+1]; //최소거리 저장
		Arrays.fill(d, MAX);
		d[start] = 0; //자신의 시작점은 0
		
		for(int i = 0 ; i<= N ; i++)
			viaList.add(new ArrayList<Integer>()); //시작점부터 어느지점까지 최단경로를 저장하기 위한 목록
		
		q.add(new P15(start, d[start])); //시작점 큐에 삽입
		
		while(!q.isEmpty()) {
			P15 P = q.poll();
			int p = P.dest;
			
			for(P15 V : List.get(p)) {
				int v = V.dest;
				ArrayList<Integer> Via = viaList.get(v);
				
				int alt = d[p] + V.cost;
				
				if(alt < d[v]) { // 새로운 최단거리 발견하면 d[v] 업데이트. Via 경로를클리어하고 p경로 추가
					d[v] = alt;
					Via.clear();
					if(start != p) Via.add(p);
					q.add(new P15(v, d[v]));
				} else if(alt == d[v]) { // 기존의 최단 거리왁 ㅏㅌ은 경로 발견하면 Via 에 u를 추가
					Via.add(p);
				}
			}
		}
		
		//중복된 길을 포함해서 경로에 있는 대학 번호를 추가
		System.out.println("Start : " + start);
		int count = 1;
		for(ArrayList<Integer> temp : viaList) {
			System.out.print("Count : " + count++ + "  :  ");
			for(Integer i : temp) {
				System.out.print(i + " -> ");
				isVia[i] = true;
			}
			System.out.println();
		}
		
	}
}