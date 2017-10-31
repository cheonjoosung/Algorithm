package backjun.p1000_2000;

import java.math.BigInteger;
import java.util.Scanner;

public class P1010 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int Ans;
		
		for(int i=0 ; i<testCase ; i++) {
			Ans = 0;
			
			int west = sc.nextInt();
			int east = sc.nextInt();
			
			
			if(west == east) {
				System.out.println(1);
			} else {
				BigInteger num = new BigInteger("1");
				for(int j=east ; j> east-west ; j--) {
					System.out.println(j);
					num = num.multiply(BigInteger.valueOf(j));
				}
				
				for(int k=west ; k>0 ; k--) {
					num = num.divide(BigInteger.valueOf(k));
				}
				System.out.println(num);
			}
		}
		
		sc.close();
	}	
}
