package backjun.lecture.p1000_2000;

import java.util.Scanner;

public class P1912 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();	
			
			int [] a = new int[n];
			long [] d = new long[n];
			
			for(int i=0 ; i< n ; i++)
				a[i] = sc.nextInt();
			
			for(int i=0; i<n ; i++) {
				d[i] = a[i];
				if(i == 0) continue;
				if(d[i] < d[i-1] + a[i]) d[i] = d[i-1] + a[i];
			}
			
			long ans = d[0];
			for(long val : d) ans = Math.max(val, ans);
			System.out.println(ans);
		
		sc.close();
	}
}

