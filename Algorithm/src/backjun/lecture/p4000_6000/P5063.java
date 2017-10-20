package backjun.lecture.p4000_6000;

import java.util.Scanner;

public class P5063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) {
			int basic = sc.nextInt();
			int adProfit = sc.nextInt();
			int adCost = sc.nextInt();
			
			if(basic < (adProfit - adCost)) System.out.println("advertise");
			else if(basic == (adProfit - adCost)) System.out.println("does not matter");
			else System.out.println("do not advertise");
		}
		
		sc.close();
	}
}
