package SS.sw_expert.d3;

import java.util.Scanner;

//거듭제곱
public class P1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();

			int num = sc.nextInt();
			int pow = sc.nextInt();

			System.out.println("#"+t+ " " + getPow(num, num, pow, 1));
		}

		sc.close();
	}
	
	public static int getPow(int num, int val, int pow, int start) {
		if(pow == start) return num;
		else {
			num *= val;
			return getPow(num, val, pow, start+1);
		}
	}
}