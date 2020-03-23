package samsung.sw_expert.d4;

import java.util.Scanner;

//3347번 올림픽 종목 투표
public class P3347 {
	static int n, m, ans;
	static int [] a, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();

			a = new int[n];
			res = new int[n];
			
			ans = 0;
			
			for(int i=0 ; i<n ; i++)
				a[i] = sc.nextInt();
			
			for(int i=0 ; i<m ; i++) {
				int val = sc.nextInt();
				for(int j=0 ; j<n ; j++) {
					if(a[j] <= val) { 
						res[j]++;
						break;
					}
				}
			}
			
			int max = -1;
			for(int i=0 ; i<n ; i++) {
				if(max < res[i]) {
					max = res[i];
					ans = i+1;
				}
			}
			

			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}
}