package samsung.sw_expert.d3;

import java.util.Scanner;

//원재의 벽 꾸미기
public class P1491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			long ans = Integer.MAX_VALUE;
			
			for(int i=1 ; i<=n; i++) {
				for(int j=i; i<=n/j ; j++) {
					long temp = (long)a*Math.abs(i-j) + (long)b*(n - i*j);
					ans = Math.min(ans, temp);
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
}