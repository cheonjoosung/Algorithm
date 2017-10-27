package SS.sw_expert.d2;

import java.util.Arrays;
import java.util.Scanner;

//쉬운 거스름돈
public class P1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int money = sc.nextInt();

			int [] a = new int[8];
			Arrays.fill(a, 0);
			//{50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10};

			a[0] = money/50_000;
			money %= 50_000;
			a[1] = money/10_000;
			money %= 10_000;
			a[2] = money/5_000;
			money %= 5_000;
			a[3] = money/1_000;
			money %= 1_000;
			a[4] = money/500;
			money %= 500;
			a[5] = money/100;
			money %= 100;
			a[6] = money/50;
			money %= 50;
			a[7] = money/10;

			System.out.println("#" + t);
			for(int val : a) System.out.print(val + " ");
			System.out.println();

		}

		sc.close();
	}
}
