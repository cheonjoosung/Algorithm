package samsung.sw_expert.d3;

import java.util.Scanner;

//화섭이의 정수 나열
public class P3809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			
			String s = "";
			int ans = 0;
			
			for(int i=0 ; i<n ; i++)
				s += sc.nextInt() + "";
			
			int idx = 0;
			while(true) {
				if(s.contains(idx+"")) idx++;
				else {
					ans = idx;
					break;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}