package backjun.lecture.p4000_6000;

import java.util.Scanner;

public class P5596 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		for(int i=0 ; i<4 ; i++) a += sc.nextInt();
		int b = 0;
		for(int i=0 ; i<4 ; i++) b += sc.nextInt();
		System.out.println(Math.max(a, b));
		
		sc.close();
	}
}
