package SS.sw_expert.d2;

import java.util.Scanner;

//지그재그 숫자
public class P1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {	
			int n = sc.nextInt();
			
			int sum = 0;
			
			for(int i=1 ; i<=n ; i++) {
				if(i % 2 == 0) sum -= i;
				else sum += i;
			}
			
			System.out.println("#" + t + " " + sum);
		}

		sc.close();
	}
}
