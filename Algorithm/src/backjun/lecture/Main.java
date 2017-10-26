package backjun.lecture;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int val = (int)(Math.pow(2, n) ) - 1;
		int sum = (val*(val+1)) / 2;

		System.out.println(Integer.toBinaryString(sum));

		sc.close();
	}
}

