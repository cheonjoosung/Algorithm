package samsung.sw_expert.d3;

import java.util.Scanner;

//영준이와 신비한 뿔의 숲
public class P3142 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1 ; tc<=t ; tc++) {
			int n = sc.nextInt(); //n개의 뿔 
			int m = sc.nextInt(); //m마리
			
			/*
			 * 2x + y = n , x+y = m 이므로 x = (n-m) , x:트윈혼,y:유니콘
			 */
			
			System.out.println("#" + tc + " " + (2*m - n) + " " + (n-m));
		}
		
		sc.close();
	}
}
