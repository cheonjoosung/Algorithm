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
			} else {
				a = Integer.parseInt(input.substring(0, input.length()));
			}

			int decimal = (int) Math.pow(10, floatSize);

			if(b!=0 && decimal % b == 0) number = decimal/b;
			else number = decimal;

			sum = a*number + (b*number) / decimal;

			System.out.println(sum + "  ,  " + number);

			if(gcd((int) sum, number) != 0) {
				sum /= gcd((int) sum, number);
				number /= gcd((int) sum, number);
			}

			cal(sum, number);


			System.out.println("#testcase"+(test_case+1));
			System.out.println(Answer);

		}
	}

	public static void cal(long sum, int number) {
		// 1 - a, 2 - b, 3 - c, 4 - d, 5 - e 
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
