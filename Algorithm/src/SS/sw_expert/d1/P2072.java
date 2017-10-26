package SS.sw_expert.d1;

import java.util.Scanner;

//홀수만 더하기
public class P2072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int t=1; t<=n ; t++) {
			int sum = 0;
			for(int i=0 ; i<10 ; i++) {
				int val = sc.nextInt();
				if(val % 2 != 0) sum += val;
			}
			System.out.println("#"+t+" "+sum);
		}

		sc.close();
	}
}
