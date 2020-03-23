package samsung.sw_expert.d2;

import java.util.Arrays;
import java.util.Scanner;

//숫자를 정렬하자
public class P1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();

			int [] a = new int[n];

			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();

			Arrays.sort(a);

			System.out.print("#" + t + " ");
			for(int val : a) System.out.print(val + " ");
			System.out.println();

		}

		sc.close();
	}
}
