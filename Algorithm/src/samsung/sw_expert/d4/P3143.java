package samsung.sw_expert.d4;

import java.util.Scanner;

//3143번 가장 빠른 문자열 타이핑 
public class P3143 {
	static int n, num, ans;
	static long [] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			String str = sc.next();
			String fast = sc.next();
			
			str = str.replaceAll(fast, "K");
			ans = str.length();
			
			System.out.println("#" + tc + " " + ans);
			
		}
		sc.close();
	}
}