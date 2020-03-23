package samsung.sw_expert.d3;

import java.util.Scanner;

//파도반 수열
public class P3376 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			
			long [] a = new long[101];
			a[0] = 0; a[1] = 1; a[2] = 1;
			
			for(int i=3 ; i<=100 ; i++)
				a[i] = a[i-2] + a[i-3];
			
			System.out.println("#" + t + " " + a[n]);
		}
		
		sc.close();
	}
}
