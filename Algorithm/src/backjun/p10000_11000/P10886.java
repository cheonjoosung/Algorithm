package backjun.p10000_11000;

import java.util.Scanner;

//0=not cute / 1=cute
public class P10886 {
	static int MOD = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int one = 0, zero = 0;
		for(int i=0 ; i<n ; i++) {
			int val = sc.nextInt();
			if(val == 1) one++;
			else zero++;
		}
		
		if(one > zero) System.out.println("Junhee is cute!");
		else System.out.println("Junhee is not cute!");
		
		sc.close();
	}
}
