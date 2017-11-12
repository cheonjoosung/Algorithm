package backjun.p2000_3000;

import java.util.Scanner;

//캥거루 세마리
public class P2965 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int max = Math.max(b-a, c-b);
		
		System.out.println(max-1);
		
		sc.close();
	}
}
