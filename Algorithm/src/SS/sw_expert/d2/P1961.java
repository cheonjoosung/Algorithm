package SS.sw_expert.d2;

import java.util.Scanner;

//숫자 배열 회전
public class P1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();

			int [][] a = new int[n][n];
			
			for(int i=0; i<n; i++)
				for(int j=0; j<n ; j++)
					a[j][i] = sc.nextInt();

			
			//시계 방향으로 90도, 180도, 270도
			
			
			System.out.println("#" + t);	
			for(int i=0; i<n; i++) {
				for(int j=0; j<n ; j++) {
					System.out.print(a[j][i] + " ");					
				}
				System.out.println();
			}
		}

		sc.close();
	}
}
