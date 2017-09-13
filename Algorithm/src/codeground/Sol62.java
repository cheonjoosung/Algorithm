package codeground;

import java.util.Scanner;

//Codegrund 62번 Hanoi
public class Sol62 {
	static String Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = "NO";

			int n = sc.nextInt();
			String s = sc.next();

			if(s.charAt(n-1) == 'A' || s.charAt(n-1) == 'B') {
				if(n < 3 ) {
					Answer = "YES";
				} else if(n >= 3) {
					String first = s.charAt(n-1)+"";
					String second = s.charAt(n-2)+"";
					String third = s.charAt(n-3)+"";

					if(first.equals("A") && second.equals("B") && third.equals("B") 
							|| first.equals("B") && second.equals("A") && third.equals("A")) {
						Answer = "NO";
					} else {
						Answer = "YES";
					}

					String temp = first;
					first = second;
					second = third;

					if(n > 3) {
						for(int i=n-4 ; i>=0 ; i--) {
							third = s.charAt(i)+"";

							if(temp.equals("A")){
								if(first.equals("A") && second.equals("B") && third.equals("B") 
										|| first.equals("B") && second.equals("A") && third.equals("A")
										|| first.equals("C") && second.equals("B") && third.equals("B") ) {
									Answer = "NO";
									break;
								} else {
									Answer = "YES";
								}
							} else {
								if(first.equals("A") && second.equals("A")
										|| first.equals("B") && second.equals("A") && third.equals("A")
										|| first.equals("C") && second.equals("A") && third.equals("A") ) {
									Answer = "NO";
									break;
								} else {
									Answer = "YES";
								}
							}


							first = second;
							second = third;
						}
					}
				} 
			} 

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
