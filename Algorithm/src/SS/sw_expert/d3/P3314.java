package SS.sw_expert.d3;

import java.util.Scanner;

//보충학습과 평
public class P3314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int ans = 0;
			for(int i=0 ; i<5 ; i++) {
				int val = sc.nextInt();
				if(val <  40) val = 40;
					ans += val;
			}
			System.out.println("#" + t + " " + ans/5);
		}
		
		sc.close();
	}
}
