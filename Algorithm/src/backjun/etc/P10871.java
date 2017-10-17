package backjun.etc;

import java.util.Scanner;

public class P10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) {
			int val = sc.nextInt();
			if(val < x ) System.out.print(val + " ");
		}
		System.out.println();
		
		sc.close();
	}
}
