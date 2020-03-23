package samsung.sw_expert.d3;

import java.util.Scanner;

//직사각형 길이 찾기 
public class P3456 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
		
			int ans = a;
			
			if(a == b) ans = c;
			else if(a == c) ans = b;
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}