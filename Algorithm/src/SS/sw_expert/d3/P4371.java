package SS.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//항구에 들어오는 배
public class P4371 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int start = sc.nextInt();
			for(int i=1 ; i<n ; i++) {
				int day = sc.nextInt();
				
				int diff = day-start;
				
				boolean isPossible = true;
				for(int j=0 ; j<list.size() ; j++)
					if(diff % list.get(j) == 0) isPossible = false;
				
				if(isPossible) list.add(diff);
			}
						
			System.out.println("#" + t + " " + list.size());
		}
		
		sc.close();
	}
}