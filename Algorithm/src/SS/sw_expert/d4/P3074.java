package SS.sw_expert.d4;

import java.util.Scanner;

//3074번 입국심사 
public class P3074 {
	static int n, num, ans;
	static long [] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			arr = new long[n];
			
			for(int i=0 ; i<n ; i++)
				arr[i] = sc.nextLong();

			long ans = 10000000000000000l;
			long l = 1;
			long r = 10000000000000000l;

			while(l <= r) {
				long mid = (l+r)/2;
				long cnt = 0;

				for(int i=0 ; i<n ; i++) cnt += mid/arr[i];

				if(cnt >= m) {
					System.out.println(cnt + " " + mid + " " + ans + " " + mid);
					r = mid-1;
					ans = Math.min(ans, mid);
				} else {
					l = mid + 1;
				}
			}
			System.out.println("#" + tc + " " + ans);
			
		}
		sc.close();
	}
}