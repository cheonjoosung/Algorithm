package SS.sw_expert.d1;

import java.util.Scanner;

//자릿수 더하기 
public class P2058 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int sum = 0;
		while(num != 0) {
			sum += num%10;
			num /= 10;
		}
		System.out.println(sum);
		sc.close();
	}
}