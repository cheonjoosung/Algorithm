package backjun.p2000_3000;

import java.util.Scanner;

public class P2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i=0 ; i<3 ; i++) {
			int oneCount = 0;
			
			for(int j=0 ; j<4 ; j++) {
				int val = sc.nextInt();
				if(val == 1) oneCount++;
			}

			if(oneCount == 0) System.out.println("D");
			else if(oneCount == 1) System.out.println("C");
			else if(oneCount == 2) System.out.println("B");
			else if(oneCount == 3) System.out.println("A");
			else System.out.println("E");

		}

		sc.close();
	}
}

