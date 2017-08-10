package codeground;

import java.util.Scanner;

//41번 윤목
public class Sol41 {

	static int Answer;
	static int Sum;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

			String input = sc.next();

			int a = 0, b = 0, floatSize = 0, number = 0;
			long sum = 0;

			if(input.indexOf('.') != -1) {
				a = Integer.parseInt(input.substring(0, input.indexOf('.')));
				b = Integer.parseInt(input.substring(input.indexOf('.')+1, input.length()));
				floatSize = input.length() - input.indexOf('.') - 1;

				int decimal = (int) Math.pow(10, floatSize);

				if(b == 0) {
					number = 1;
				} else {
					number = decimal;
				}

				sum = a*number + b;

			} else {
				a = Integer.parseInt(input.substring(0, input.length()));
				sum = a;
				number = 1;
			}

			if(gcd((int) sum, number) != 0) {
				int gcd = gcd((int) sum, number);
				sum = sum/gcd;
				number = number/gcd;
			}

			int one=0, two=0, three=0, four=0, five=0;

			long result = sum-number;
			if(sum < number) result *= -1;
			//sum 보다 number 가 클 경우도 존재하네...

			/* 1 - a, 2 - b, 3 - c, 4 - d, 5 - e 
			 a+b+c+d+e = number / a+2*b+3*c+4*d+5*e = sum
			 sum - number = b + 2*c + 3*d + 4*e
			 */

			five = (int) (result/4);
			result %= 4;
			four = (int) (result/3);
			result %= 3;
			three = (int) (result/2);
			result %= 2;
			two = (int) (result);
			
			one = number - (two + three + four + five);

			System.out.println("#testcase"+(test_case+1));
			System.out.println(one + " " + two + " " + three + " " + four + " " + five);

		}
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}
