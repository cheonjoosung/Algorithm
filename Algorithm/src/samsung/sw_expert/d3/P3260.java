package samsung.sw_expert.d3;

import java.math.BigInteger;
import java.util.Scanner;

//두 수의 덧셈
public class P3260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			String aStr = sc.next();
			String bStr = sc.next();
			
			BigInteger a = new BigInteger(aStr); 
			BigInteger b = new BigInteger(bStr);
		
			BigInteger c = a.add(b);
			
			System.out.println("#" + t + " " + c);
		}
		
		sc.close();
	}
}
