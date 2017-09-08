package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//CodeGround 15번 캠퍼스와 도로(1)
public class Sol15 { 
	static int Answer;
	static int MAX = 100_000_000;
	static ArrayList<Integer> moneyList;

	public static void main(String args[]) throws Exception    {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int num = sc.nextInt();
			int roadSize = sc.nextInt();

			int [][] road = new int[num][num];
			moneyList = new ArrayList<>();

			for(int [] k : road)
				Arrays.fill(k, 99999999);

			for(int i=0 ; i<roadSize ; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int dist = sc.nextInt();

				road[start - 1][end - 1] = dist;
				road[end - 1][start - 1] = dist;
			}

			for(int i=1 ; i<=num ; i++)
				moneyList.add(i);

			/*for(int i=0 ; i < num ; i++)
				findRoad(i, num-1, road, num);*/
			
			for(int i = 0 ; i < num ; i++)
				findRoadQueue(i, road, num);

			System.out.println("Case #"+(test_case+1));
			if(moneyList.size() < 0) {
				System.out.println(Answer);
			} else {
				String s = moneyList.size() + " ";
				for(int k : moneyList) 
					s += k + " ";
				System.out.println(s.trim());
			}

		}
	}
	
	public static void findRoad(int start, int end, int [][] road, int size) {
		int [] dist = new int[size];
		boolean [] check = new boolean[size];
		
		Arrays.fill(dist, MAX);
		Arrays.fill(check, false);
		
		dist[start] = 0;
		
		System.out.println("START : " + start);
		
		for(int i=0; i<size ; i++) {
			int min = MAX + 1;
			int index = -1;
			
			for(int j = 0 ; j < size ; j++) {
				if(check[j] == false && min > dist[j] ) {
					min = dist[j];
					index = j;
				}
			}
			
			check[index] = true;
			
			for(int k = 0 ; k < size ; k++) {
				System.out.println((index+1) + " , " + (k+1));
				if(road[index][k] != 0 && dist[k] > dist[index] + road[index][k]) {
					dist[k] = dist[index] + road[index][k];
					System.out.println((index+1) + " -> " + (k+1) + "  :  " + dist[k]);
					
					if( (start+1) != (index+1) && dist[k] != MAX-1 ) {
						if(moneyList.contains(index+1)) {
							//System.out.println(" Find : " + (index+1));
							int x = moneyList.indexOf(index+1);
							moneyList.remove(x);							
						}
					}
					
				}
			}
		}
		
	}
	
	public static void findRoadQueue(int start, int [][] road, int size) {
		int [] dist = new int[size];
		boolean [] check = new boolean[size];
		
		Arrays.fill(dist, MAX);
		Arrays.fill(check, false);
		
		dist[start] = 0;
		
		PriorityQueue<Element> q = new PriorityQueue<>();
        q.offer(new Element(start, dist[start]));
        
        while(!q.isEmpty()) {
        	int here = q.peek().getEdge();
        	int cost = q.peek().getCost();
        	q.poll();
        	
        	if(cost > dist[here]) continue;
        	
        	for(int i = 0; i < size; i++){
                if(road[here][i] != 0 && dist[i] > dist[here] + road[here][i]){
                    dist[i] = dist[here] + road[here][i];
                    q.offer(new Element(i, dist[i]));
                    
                   if( (start+1) != (here+1) && dist[i] != MAX-1 ) {
						if(moneyList.contains(here+1)) {
							//System.out.println(" Find : " + (index+1));
							int x = moneyList.indexOf(here+1);
							moneyList.remove(x);							
						}
					}
                }
            }
        }
	}
}

class Element implements Comparable<Element> {

	int edge;
	int cost;
	
	Element(int edge, int cost) {
		this.edge = edge;
		this.cost = cost;
	}
	
	public int getEdge() {
		return edge;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Element o) {
		return this.cost <= o.cost ? -1 : 1;
	}
	
}
