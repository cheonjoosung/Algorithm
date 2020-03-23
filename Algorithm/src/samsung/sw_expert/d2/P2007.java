package samsung.sw_expert.d2;

import java.util.Scanner;

//패턴 마디의 길이
public class P2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {	
			String s = sc.next();
			int index = 0;
			
			
			for(int i=1 ; i<=10 ; i++) {
				String sub = s.substring(0, i);
				
				if(sub.equals(s.substring(i, 2*i))) {
	                index = i; break;
	            }
			}
			
			System.out.println("#" + t + " " + index);
		}

		sc.close();
	}
}
