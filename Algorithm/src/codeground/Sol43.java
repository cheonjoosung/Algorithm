package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//43번 2개의 네비게이션
/*
 * 3->4 갈때 p는 7,q는 1
 * 1->3 갈때 p는 2,q는 20
 * ... 최단경로는 P : 1->3->5 = 6, Q : 1->2->4->5 = 9 
 */
public class Sol43 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			
			int home = sc.nextInt();
			int roadCount = sc.nextInt();
			
			ArrayList<ArrayList<P43>> list  = new ArrayList<>();
			
			for(int i=0 ; i < roadCount ; i++)
				list.add(new ArrayList<>());
			
			for(int i=0 ; i<roadCount ; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int p = sc.nextInt();
				int q = sc.nextInt();
				
				list.get(start-1).add(new P43(start, end, p, q));
			}
			
			for(ArrayList<P43> p : list) {
				if(p.size() != -1) {
					for(P43 point : p) {
						System.out.println(point.getStart() + " -> " + point.getEnd() + " : " + point.getP() + " , " + point.getQ());
					}
				}
			}
			
			findRoad(1, home, list);
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static void findRoad(int start, int end, ArrayList<ArrayList<P43>> list) {
		int [] alarmCount = new int[end];
		Queue<Integer> q = new LinkedList(); 
		
		Arrays.fill(alarmCount, 0);
		alarmCount[0] = 0;
		
		q.add(1);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
			
			int k = q.poll();
			
			int minP = Integer.MAX_VALUE;
			int minQ = Integer.MAX_VALUE;
			
			int pIndex  = -1;
			int qIndex  = -1;
			
			for(P43 p : list.get(k)) {
				
				if(minP > p.p){
					minP = p.p;
					pIndex = p.end;
				}
				
				if(minQ > p.q){
					minQ = p.q;
					qIndex = p.end;
				}
				
				if(p.end != end)
					q.offer(p.end);
			}
			
			for(P43 p : list.get(k)) {
				if(p.end != pIndex) {
					alarmCount[end-1]++;
				}
				
				if(p.end != qIndex) {
					alarmCount[end-1]++;
				}
			}
			
		}
		
		for(int i : alarmCount)
			System.out.print("i : " + i + " ");
	}
}

class P43 {
	int start;
	int end;
	int p;
	int q;
	
	P43(int start, int end, int p, int q) {
		this.start = start;
		this.end = end;
		this.p = p;
		this.q = q;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}
}
