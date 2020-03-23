package samsung.sw_expert.d3;

import java.util.Scanner;

//준환이의 운동관리
public class P3431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			long under = sc.nextLong();
			long up = sc.nextLong();
			long now = sc.nextLong();
			
			long ans = 0;
			
			if(now > under && now <= up) ans = 0;	
			else if(now < under) ans = under-now;
			else ans = -1;
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}