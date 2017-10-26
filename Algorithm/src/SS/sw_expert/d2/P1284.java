package SS.sw_expert.d2;

import java.util.Scanner;

//수도 요금 경쟁
public class P1284 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int bL = sc.nextInt();
			int bLS = sc.nextInt();
			int totalWater = sc.nextInt();
			
			int min = 0;
			if(totalWater > bL) min = Math.min(b+(totalWater-bL)*bLS,a*totalWater);
			else min = Math.min(a*totalWater, b);
			
			System.out.println("#" + t + " " + min);
		}
		
		sc.close();
	}
}
