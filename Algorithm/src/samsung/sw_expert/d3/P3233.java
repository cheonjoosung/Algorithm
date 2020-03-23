package samsung.sw_expert.d3;

import java.util.Scanner;

//정삼각형 분할 놀이
public class P3233 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			//삼각형 넓이 공식 (루트3 / 4) * 한변의 제곱
			
			long ans = (long) Math.pow(a/b, 2); //Int 의 범위를 넘어가는 경우 생기는거 주의!!! 
			
			System.out.println("#" + test_case + " " + ans);
		}
		
		sc.close();
	}
}
