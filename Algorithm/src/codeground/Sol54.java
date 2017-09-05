package codeground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sol54 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int n = sc.nextInt();
			int sum = 0;
			
			ArrayList<P54> list = new ArrayList<>();
			
			for(int i=0; i<n ; i++) {
				int island = sc.nextInt();
				int bridge = sc.nextInt();
				
				list.add(new P54(island, bridge));
				sum += bridge;
			}
			
			Collections.sort(list);
			
			if( (n-1) * 2 > sum) {
				//2 - 2개, 3 - 4개, 4 - 6개, 5 - 8개의 최소 연결지점이 필요
				System.out.println("Case #"+(test_case+1));
				System.out.println(-1);
			} else {
				
				/*
				 * 예외 케이스 1 8 9 14 15 - 4 3 1 1 1 일 때 dp 를 활용야 할 수도 있을 
				 */
				for(int i=0; i<n ; i++) {
					P54 p = list.get(i);
					
					if(p.getBridgeCount() <= 0) continue;
					
					for(int j=i+1 ; j < n ; j++) {
						P54 nextP = list.get(j);
						
						if(nextP.getBridgeCount() <= 0) continue;
						else {
							if(nextP.getBridgeCount() == 1 && p.getBridgeCount() == 1) {
								if(j == n-1) {
									int temp = nextP.getBridgeCount();
									list.get(j).setBridgeCount(temp-1);
									list.get(i).setBridgeCount(p.getBridgeCount()-1);
									Answer += (nextP.getIsland() - p.getIsland());
								} else {
									continue;
								}
							} else {
								int temp = nextP.getBridgeCount();
								list.get(j).setBridgeCount(temp - 1);
								list.get(i).setBridgeCount(p.getBridgeCount() - 1);
								Answer += (nextP.getIsland() - p.getIsland());
								
								if(list.get(j).getBridgeCount() > 1) break;
							}
							
							if(p.getBridgeCount() == 0) break;
						}
					}
				}
				
				System.out.println("Case #"+(test_case+1));
				System.out.println(Answer);
			}

			
		}
	}


}

class P54 implements Comparable<P54>{
	int island;
	int bridgeCount;
	
	P54(int island, int bridgeCount) {
		this.island = island;
		this.bridgeCount = bridgeCount;
	}

	public int getIsland() {
		return island;
	}

	public void setIsland(int island) {
		this.island = island;
	}

	public int getBridgeCount() {
		return bridgeCount;
	}

	public void setBridgeCount(int bridgeCount) {
		this.bridgeCount = bridgeCount;
	}

	@Override
	public int compareTo(P54 o) {
		return this.island < o.island ? -1 : 1;
	}
}
