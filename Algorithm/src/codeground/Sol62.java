package codeground;

import java.util.Scanner;

//Codegrund 62번 Hanoi
public class Sol62 {
	static String Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int n = sc.nextInt();
			String s = sc.next();
			s = s.toLowerCase();
			
			if((s.charAt(n-1)+"").equals("c")) {
				System.out.println("Case #"+(test_case+1));
				System.out.println("NO");
			} else {
				System.out.println("Case #"+(test_case+1));
				System.out.println("YES");
			}
			
			 




			/*
			if((s.charAt(n-1)+"").equals("C")) {
				System.out.println("Case #"+(test_case+1));
				System.out.println("NO");
			} else {

				if((s.charAt(n-1)+"").equals("A")) {

					for(int i=n-2; i>=0 ; i--) {						
						if((s.charAt(i+1)+"").equals("B") && (s.charAt(i)+"").equals("B")) {
							Answer = "NO";
							break;
						}
					}

				} else {

					for(int i=n-2; i>=0 ; i--) {
						if((s.charAt(i+1)+"").equals("A") && (s.charAt(i)+"").equals("A")) {
							Answer = "NO";
							break;
						}
					}*/

		}


	}
}
