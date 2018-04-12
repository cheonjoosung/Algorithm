package SS.sw_expert.d3;

import java.util.Scanner;

//수의 새로운 연산
public class P1493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1; t<=tc; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int val = 1;
			
			for(int i=0 ;  ; i++) {
				
				System.out.println(i + " " + val);
				val += (i+1);
				if(i == 8) break;
			}
						
			System.out.println("#" + t + " " + 0);
		}

		sc.close();
	}
}