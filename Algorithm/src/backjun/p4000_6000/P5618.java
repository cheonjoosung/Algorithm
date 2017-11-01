package backjun.p4000_6000;

import java.util.Scanner;

//공약수 
public class P5618 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] a = new int[n];
		int min = Integer.MAX_VALUE;
		
		for(int i=0 ; i<n ; i++) {
			int val = sc.nextInt();
			a[i] = val;
			min = Math.min(min, val);
		}
		
		for(int i=1 ; i<=min ; i++) {
			boolean isDivide = true;
			
			for(int j=0 ; j<n ; j++) {
				if(a[j] % i != 0) {
					isDivide = false;
					break;
				}
			}
			
			if(isDivide) System.out.println(i);
		}
		
		sc.close();
	}
}
