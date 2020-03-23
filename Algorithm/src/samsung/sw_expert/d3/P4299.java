package samsung.sw_expert.d3;

import java.util.Scanner;

//태혁이의 사랑은 타이밍
public class P4299 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int d = sc.nextInt();
			int h = sc.nextInt();
			int m = sc.nextInt();
			
			int ans = 0;
			
			ans = (d-11)*24*60 + (h-11)*60 + (m-11);
			
			if(ans < 0) ans = -1;
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}