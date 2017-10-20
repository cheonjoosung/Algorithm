package backjun.lecture.p10000_11000;

import java.util.Scanner;

public class P10539 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int val = 0;
		int temp = 0;
		
		for(int i=0 ; i<n ; i++) {
			if(i == 0) val = sc.nextInt();
			else val = sc.nextInt() * (i+1) - temp;
			//QWRSuPYgmgQrcf2KvgEqmdNQyfXs5jttvx
			temp += val;
			
			System.out.print(val + " ");
		}
		System.out.println();
		sc.close();
	}
}
