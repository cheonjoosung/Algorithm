package backjun.p2000_3000;

import java.util.Scanner;

//저작권
public class P2914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int minVal = a*(b-1);
		
		System.out.println(minVal+1);
		
		sc.close();
	}
}
