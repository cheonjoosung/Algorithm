package codeground;

import java.util.Scanner;

//Codeground 1번 숫자 골라내기
public class Sol01 {
	static int Answer;

	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) { 
			Answer = 0;
			int bit = sc.nextInt();

			for(int i=0 ; i<bit ; i++) {
				int k = sc.nextInt();
				Answer ^= k; 
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);

		}
	}
}