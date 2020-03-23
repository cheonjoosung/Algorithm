package samsung.sw_expert.d1;

import java.util.Scanner;

//큰 놈, 작은 놈, 같은 놈
public class P2070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int t=1; t<=n ; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a < b) System.out.println("#"+t+" "+"<");
			else if(a == b) System.out.println("#"+t+" "+"=");
			else System.out.println("#"+t+" "+">");
		}

		sc.close();
	}
}
