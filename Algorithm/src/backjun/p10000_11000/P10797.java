package backjun.p10000_11000;

import java.util.Scanner;

public class P10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 0;
		for(int i=0 ; i<5 ; i++) {
			int val = sc.nextInt();
			if(val == n) count++;
		}
		
		System.out.println(count);
		
		sc.close();
	}
}
