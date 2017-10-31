package backjun.p4000_6000;

import java.util.Scanner;

//상근날드 
public class P5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int coke = sc.nextInt();
		int coke2 = sc.nextInt();
		
		int min = Math.min(Math.min(a1, a2), a3);
		min += Math.min(coke, coke2);
		
		System.out.println(min-50);
		
		
		sc.close();
	}
}
