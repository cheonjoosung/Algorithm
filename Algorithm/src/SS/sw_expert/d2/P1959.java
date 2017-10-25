package SS.sw_expert.d2;

import java.util.Scanner;

//두개의 숫자열
public class P1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			int [] a = new int[n1];
			int [] b = new int[n2];

			for(int i=0 ; i<n1 ; i++) a[i] = sc.nextInt();
			for(int i=0 ; i<n2 ; i++) b[i] = sc.nextInt();

			int sum = 0;
			if(n1 < n2) {
				int temp = n2-1;
				for(int i=a.length-1 ; i>=0 ; i--) {
					sum += a[i] * b[temp--];
				}
			} else {
				int temp = n1-1;
				for(int i=b.length-1 ; i>=0 ; i--) {
					sum += b[i] * a[temp--];
				}
			}

			System.out.println("#" + t + " " + sum);

		}

		sc.close();
	}
}
