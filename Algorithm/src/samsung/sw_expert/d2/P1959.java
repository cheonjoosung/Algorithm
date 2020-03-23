package samsung.sw_expert.d2;

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
				for(int j=0 ; j<(n2-n1)+1 ; j++) {
					int temp = 0;
					for(int i=0; i<n1 ; i++) {
						temp += a[i] * b[i+j];
					}
					sum = Math.max(sum, temp);
				}
			} else if(n1 > n2){
				for(int j=0 ; j<(n1-n2)+1 ; j++) {
					int temp = 0;
					for(int i=0; i<n2 ; i++) {
						temp += b[i] * a[i+j];
					}
					sum = Math.max(sum, temp);
				}
			} else
				for(int i=0 ; i<n1 ; i++) sum += a[i] * b[i];

			System.out.println("#" + t + " " + sum);

		}

		sc.close();
	}
}
