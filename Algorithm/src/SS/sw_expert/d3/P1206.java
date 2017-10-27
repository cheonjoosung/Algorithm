package SS.sw_expert.d3;

import java.util.Scanner;

//View
public class P1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();
			int ans = 0;
			int [] a = new int[n];
			
			for(int i=0 ; i<n ; i++) a[i] = sc.nextInt(); 
			
			for(int i=0 ; i<n ; i++) {
				int base = a[i];
				int max = 0;
				for(int j=i-2 ; j<=i+2 ; j++) {
					if(j < 0 || j > n-1 || j==i) continue;
					else {
						max = Math.max(max, a[j]);
					}
				}
				if(base - max > 0) ans += (base-max);
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}
