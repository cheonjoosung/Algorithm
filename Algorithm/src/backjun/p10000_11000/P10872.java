package backjun.p10000_11000;

import java.util.Scanner;

//팩토리얼 
public class P10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [] fact = new int[n+1];

		if(n==0 || n==1) System.out.println(1);
		else {
			fact[0] = 1; fact[1] = 1;
			
			for(int i=2 ; i<=n ; i++) {
				fact[i] = i * fact[i-1];
			}
			System.out.println(fact[n]);
		}

		sc.close();
	}
}
