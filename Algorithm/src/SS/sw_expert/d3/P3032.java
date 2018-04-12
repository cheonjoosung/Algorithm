package SS.sw_expert.d3;

import java.util.Scanner;

//홍준이의 숫자 놀이
public class P3032 {
	static int ans, a, b;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;
			
			a = sc.nextInt();
			b = sc.nextInt();
			
			int x = 0;
			int y = 0;
			
			//n*x + b*y = 1; y = (1 - n*x ) / b
			if(a == 1 || b== 1)
			for(int i=1 ; ; i*=-1) {
				
				if( (1 - a*i) % b == 0) {
					System.out.println(1 - a*i);
					x = i;
					y = (1-a*i)/b;
					break;
				}
			}
			
			
			
			if(x ==0 && y==0) 
				System.out.println("#" + tc + " " + -1);
			else 
				System.out.println("#" + tc + " " + x + " " +  y);
		}
	}
}
