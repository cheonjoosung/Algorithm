package samsung.sw_expert.d2;

import java.util.Scanner;

//가랏 RC카 
public class P1940 {
	static int speed = 0;
	static int speedUp = 1;
	static int speedDown = 2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();
			int cur = 0;
			int dist = 0;
			
			for(int i=0 ; i<n ; i++) {
				int mode = sc.nextInt();
				if(mode == 0) {
					dist += cur;
				} else if(mode == 1) {
					int v = sc.nextInt();
					cur += v;
					dist += cur;
				} else {
					int v = sc.nextInt();
					cur -= v;
					if(cur <= 0) cur = 0;
					dist += cur;
				}
			}
			
			System.out.println("#" + t + " " + dist);
		}
		
		sc.close();
	}
}
