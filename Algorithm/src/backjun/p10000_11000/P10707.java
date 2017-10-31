package backjun.p10000_11000;

import java.util.Arrays;
import java.util.Scanner;


//과제 안내신분 ?
public class P10707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean [] a = new boolean[31];
		Arrays.fill(a, false);
		
		for(int i = 0 ; i<28 ; i++) {
			int val = sc.nextInt();
			a[val] = true;
		}
		
		for(int i=1 ; i<=30 ; i++) {
			if(!a[i]) System.out.println(i);
		}

		sc.close();
	}
}
