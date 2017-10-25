package SS.sw_expert.d1;

import java.util.Scanner;

//몫과 나머지 출력하기
public class P2029 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<=testCase ; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#"+t + " " + (a/b) + " " + (a%b));
		}
		
		sc.close();
	}
}