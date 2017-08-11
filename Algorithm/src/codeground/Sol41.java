package codeground;

import java.math.BigDecimal;
import java.util.Scanner;

//41번 윤목
public class Sol41 {
	static BigDecimal MAX = BigDecimal.valueOf(1_000_000_000);

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			
			BigDecimal input = sc.nextBigDecimal();
			int divCount = 0;
			
			input = input.multiply(MAX);
			
			
			while(input.longValue() % 10 == 0) {
				input = input.divide(BigDecimal.TEN);
				divCount++;
			}
			
			long sum = input.longValue();
			long number = (long) (MAX.longValue() / Math.pow(10, divCount));
			long gcdNum = gcd(sum, number);
			
			sum /= gcdNum;
			number /= gcdNum;
			
			/*
			 * 1-a, 2-b, 3-c, 4-d, 5-e
			 * a+b+c+d+e = number 이고 a + 2*b + 3*c + 4*d + 5*e = sum 이다
			 * b + 2*c + 3*d + 4*e = sum - number
			 */
			
			long result = sum - number;
			long a = 0, b = 0, c = 0, d = 0, e = 0;
			
			e = result / 4;
			result %= 4;
			d = result / 3;
			result %= 3;
			c = result / 2;
			result %= 2;
			b = result;
			
			a = number - (b+c+d+e);			

			System.out.println("#testcase"+(test_case+1));
			System.out.println(a + " " + b + " " + c + " " + d + " " + e);
		}
		
		sc.close();
	}
	
	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}
