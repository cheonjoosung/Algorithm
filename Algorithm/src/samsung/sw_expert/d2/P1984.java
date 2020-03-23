package samsung.sw_expert.d2;

import java.util.Scanner;

//중간 평균값 구하기
public class P1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			
			for(int i=0 ; i<10 ; i++) {
				int val = sc.nextInt();
				sum += val;
				if(val > max) max = val;
				if(val < min) min = val;
			}
			
			double ans = (sum - max - min) / 8.0;
			int res = (int)Math.round(ans);
			System.out.println("#" + t + " " + res);
		}

		sc.close();
	}
}
