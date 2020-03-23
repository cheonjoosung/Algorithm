package samsung.sw_expert.d2;

import java.util.Scanner;

//백만장자 프로젝트
public class P1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();
			long [] a = new long[n];
			
			for(int i=0 ; i<n ; i++) a[i] = sc.nextInt();
			
			long sum = 0;
			long max = a[n-1];
			
			for(int i=n-2 ; i>=0 ; i--) {
				if(a[i] < max) sum += max - a[i];
				else max = a[i];
			}
			
			System.out.println("#" + t + " " + sum);
		}
		
		sc.close();
	}
}
