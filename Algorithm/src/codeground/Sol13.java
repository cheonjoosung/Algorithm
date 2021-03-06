package codeground;

import java.util.Scanner;

//Codeground 13번 균일수 
public class Sol13 {
	static int Answer;


	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int number = sc.nextInt();

			//균일수가 n=3 자리 이 N = a(1+b+b^2+b^3+.......) 일
			for(int b=2 ; b*b <= number ; b++) {
				int temp = number % b;
				int newNumber = number;
				boolean isDetect = true;
				
				while(newNumber > 0) {
					if(newNumber % b != temp) {
						isDetect = false;
						break;
					}
					newNumber /= b;
				}
				
				if(isDetect) {
					Answer = b;
					break;
				}
			}
			
			//균일수가 n=2 자리 N = a(1+b)
			if(Answer == 0) {
				for(int a=1; a*a<= number ; a++) {
					if(number % a != 0) continue;
					
					int b = number/a - 1;
					if(b > a) Answer = b;
					
				}
			}
			
			//균일수가 n=1 자리 N = a 이므로 한자리 큰 모든 수 가 균일
			if(Answer == 0) Answer = number+1;

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
