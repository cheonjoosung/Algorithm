package SS.sw_expert.d3;

import java.util.Scanner;

public class P2930 {
	static int ans, n, m;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
