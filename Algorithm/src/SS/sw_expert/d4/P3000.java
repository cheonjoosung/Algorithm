package SS.sw_expert.d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//3000번 중간값 구하기
public class P3000 {
	static long n, num, ans;
	static long [] arr;
	static int mod = 20171109;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			long n = sc.nextLong();
			long s = sc.nextLong();
			
			ArrayList<Long> list = new ArrayList<>();
			list.add(s);
			
			for(int i=0 ; i<n ; i++) {
				long v1 = sc.nextLong();
				long v2 = sc.nextLong();
				
				list.add(v1);
				list.add(v2);
				Collections.sort(list);
				
				ans += list.get((list.size()-1)/2);
				ans %= mod;
			}
			
			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}
}