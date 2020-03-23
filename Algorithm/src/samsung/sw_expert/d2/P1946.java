package samsung.sw_expert.d2;

import java.util.Scanner;

//간단한 압축풀기
public class P1946 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();
			System.out.println("#" + t);

			int val = 0;
			for(int i=0 ; i<n ; i++) {
				String s = sc.next();
				int count = sc.nextInt();

				while(count-- > 0) { 
					System.out.print(s);
					val++;
					if(val % 10 == 0) {
						System.out.println();
						val = 0;
					}
				}
			}
			System.out.println();			

		}

		sc.close();
	}
}
