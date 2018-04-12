package SS.sw_expert.d3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2948 {
	static int ans, n, m;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			
			Set<String> a = new HashSet<>();
			Set<String> b = new HashSet<>();
			
			for(int i=0 ; i<n ; i++) {
				String s = sc.next();
				a.add(s);
			}
			
			for(int i=0 ; i<m ; i++) {
				String s = sc.next();
				b.add(s);
			}
			
			a.retainAll(b);
			
			System.out.println("#" + tc + " " + a.size());
		}
	}
}
