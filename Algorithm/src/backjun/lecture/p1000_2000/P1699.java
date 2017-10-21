package backjun.lecture.p1000_2000;

import java.util.Scanner;

public class P1699 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();	
			
			int [] a = new int[n+1];
			long [] d = new long[n+1];
			
			for(int i=1 ; i<= n ; i++)
				a[i] = sc.nextInt();
			
			for(int i=1; i<=n ; i++) {
				d[i] = i;
				for(int j=1; j*j <= i ; j++) {
					if(d[i] > d[i-j*j] + 1) d[i] = d[i-j*j] + 1;
				}
			}
			
			System.out.println(d[n]);
		
		sc.close();
	}
}

