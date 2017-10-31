package backjun.p2000_3000;

import java.util.Scanner;

public class P2133 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();	
			
			//int [] a = new int[n+1];
			long [] d = new long[n+1];
			
			//for(int i=1 ; i<= n ; i++)
			//	a[i] = sc.nextInt();
			
			d[0] = 1; 
			
			for(int i=2; i<=n ; i++) {
				d[i] = d[i-2] * 3;
				
				for(int j=i-4; j >= 0 ; j-=2) {
					d[i] += 2*d[j];
				}
			}
			
			System.out.println(d[n]);
		
		sc.close();
	}
}

