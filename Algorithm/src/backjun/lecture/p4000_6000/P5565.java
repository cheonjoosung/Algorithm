package backjun.lecture.p4000_6000;

import java.util.Scanner;

public class P5565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = sc.nextInt();
		
		int sum = 0;
		for(int i=0 ; i<9 ; i++)
			sum += sc.nextInt();
		
		System.out.println(total - sum);
		
		sc.close();
	}
}
