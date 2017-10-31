package backjun.p2000_3000;

import java.util.Scanner;

public class P2156 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();		
			int [] a = new int[n+1];
			int [][] d = new int[n+1][3];
			
			for(int i=1 ; i<= n ; i++)
				a[i] = sc.nextInt();
			
			for(int i=1; i<= n ; i++) {
				d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
				d[i][1] = d[i-1][0] + a[i];
				d[i][2] = d[i-1][1] + a[i];
			}
			
			long ans = 0;
			ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
			System.out.println(ans);
		

		sc.close();
	}
}

