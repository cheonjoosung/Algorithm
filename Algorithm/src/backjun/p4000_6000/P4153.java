package backjun.p4000_6000;

import java.util.Arrays;
import java.util.Scanner;

//직각삼각형 
public class P4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] a = new int[3];
		while(true) {
			a[0] = sc.nextInt(); a[1] = sc.nextInt(); a[2] = sc.nextInt();
			Arrays.sort(a);
			
			if(a[0] == 0 && a[1] == 0 && a[2] ==0) break;
			
			if( ( Math.pow(a[0], 2) + Math.pow(a[1], 2) ) == Math.pow(a[2], 2)) System.out.println("right");
			else System.out.println("wrong");
		}

		sc.close();
	}
}
