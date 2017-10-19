package backjun.etc;

import java.util.Scanner;

public class P5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i=0 ; i<4 ; i++) 
			sum += sc.nextInt();
		
		int minute = sum/60;
		int second = sum%60;
		
		System.out.println(minute);
		System.out.println(second);
		
		sc.close();
	}
}
