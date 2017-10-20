package backjun.etc;

import java.util.Scanner;

public class P3034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int box1 = sc.nextInt();
		int box2 = sc.nextInt();
		int max = box1*box1 + box2*box2;
		
		for(int i=0 ; i<n ; i++) {
			int val = sc.nextInt();
			if(val*val <= max) System.out.println("DA");
			else System.out.println("NE");
		}
		
		sc.close();
	}
}
