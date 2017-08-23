package codeground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sol30 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 1;

			int xMax = sc.nextInt();
			int yMax = sc.nextInt();
			
			int n = sc.nextInt();
			
			ArrayList<P30> list = new ArrayList<>();
			
			for(int i = 0 ; i < n ; i++) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				
				list.add(new P30(x1, y1, x2, y2));
			}
			
			Collections.sort(list);
			
			for(P30 p : list)
				System.out.print(p.x1 + " , " + p.y1 + " , " + p.x2 + " , " + p.y2 + "\n");
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}

class P30 implements Comparable<P30>{
	long x1;
	long y1;
	
	long x2;
	long y2;
	
	public P30(long x1, long y1, long x2, long y2){
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public int compareTo(P30 o) {
		if((this.x2-this.x1) < (o.x2 - o.x1) ){
			return 1;
		}else if((this.x2-this.x1) < (o.x2 - o.x1) && (this.y2 - this.y1) > (o.y2 - o.y1)){
			return 1;
		}
		return -1;
	}
}
