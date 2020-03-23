package samsung.sw_expert.d4;

import java.util.Scanner;
import java.util.Stack;

//[S/W 문제해결 기본] 6일차 - 계산기 1  
public class P1222 {
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();
			String s = sc.next();
			
			ans = 0;
			
			Stack<Character> stack = new Stack<>();

			for(int i=0 ; i<n ; i++) {
				char c = s.charAt(i);
				
				/*
				 * 연산자가 나올때까지 숫자를 넣고 연산자가 나오면 팝해서 두숫자를 계산
				 */
				if(c == '+') {
					
				} else {
					
				}
			}

			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}