package samsung.sw_expert.d3;

import java.util.Scanner;

//세상의 모든 팰린드롬
public class P4522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			String s = sc.next();
			
			boolean isPossible = true;
			for(int i=0 ; i<s.length()/2 ; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					if(s.charAt(i) == '?' || s.charAt(s.length()-1-i) == '?') {
					} else {
						isPossible = false;
					}
				}
			}
			
			if(isPossible) System.out.println("#" + t + " " + "Exist");
			else System.out.println("#" + t + " " + "Not exist");
		}
		
		sc.close();
	}
}