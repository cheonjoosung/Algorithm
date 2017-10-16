package backjun.lecture;

import java.util.Scanner;

public class Star {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i=0 ; i<n-1; i++) {
			for(int j=0 ; j < n-i ; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		for(int i=0 ; i<n ; i++) System.out.print("*");
		System.out.println();
		
		sc.close();
	}
}
