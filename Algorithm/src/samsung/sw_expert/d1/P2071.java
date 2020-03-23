package samsung.sw_expert.d1;

import java.util.Scanner;

//평균값 구하기
public class P2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int t=1; t<=n ; t++) {
			double sum = 0;
			for(int i=0 ; i<10 ; i++) sum += sc.nextInt();
			System.out.println("#"+t+" "+Math.round((sum)/10.0));
		}

		sc.close();
	}
}
