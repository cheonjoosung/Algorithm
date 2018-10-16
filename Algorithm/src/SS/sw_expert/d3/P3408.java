package SS.sw_expert.d3;

import java.util.Scanner;

//세가지 합 구하기
public class P3408 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			long n = sc.nextLong();
			
			long s1 = (n*(n+1))/2;
			long s2 = n*n;
			long s3 = n*n + n;
			
			System.out.println("#" + t + " " + s1 + " " + s2 + " " + s3);
		}
		
		sc.close();
	}
}
