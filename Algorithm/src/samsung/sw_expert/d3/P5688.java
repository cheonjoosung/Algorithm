package samsung.sw_expert.d3;

import java.util.Scanner;

//세제곱근을 찾아라
public class P5688 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(long t=1 ; t<=tc ; t++) {
			long n = sc.nextLong();
			long a = (long) Math.cbrt(n);
			System.out.print("#" + t + " ");
			System.out.println(a*a*a == n? a:"-1");
		}

		sc.close();
	}
}