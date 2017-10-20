package backjun.lecture.p9000_10000;

import java.util.Scanner;

public class P9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i=0 ; i<testCase ; i++) {
			int goal = sc.nextInt();
			int Ans = go(0, 0, goal);
			System.out.println(Ans);
		}
		
		sc.close();
	}
	
	public static int go(int count , int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now = 0;
		
		for(int i=1; i<=3 ; i++) {
			now+= go(count+1, sum+i, goal);
		}
		return now;
	}
}
