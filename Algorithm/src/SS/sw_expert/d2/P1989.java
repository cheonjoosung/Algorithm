package SS.sw_expert.d2;

import java.util.Scanner;

//초심자의 회문 검사
public class P1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {	
			String s = sc.next();
			boolean check = true;
			
			for(int i=0 ; i<= s.length()/2 ; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					check = false;
				}
			}
			
			if(check) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}

		sc.close();
	}
}
