package SS.sw_expert.d3;

import java.util.Scanner;

//승률 비교하기
public class P3975 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int a = sc.nextInt();
			int aT = sc.nextInt();
			int b = sc.nextInt();
			int bT = sc.nextInt();
			
			double aRes = (double)a/aT;
			double bRes = (double)b/bT;
			
			String ans = "";
			
			if(aRes < bRes) ans = "BOB";
			else if(aRes > bRes) ans = "ALICE";
			else ans = "DRAW";
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}