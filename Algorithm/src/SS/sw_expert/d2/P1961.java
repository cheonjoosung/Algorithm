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
			int [][] a1 = new int[n][n];
			int [][] a2 = new int[n][n];
			int [][] a3 = new int[n][n];
			
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
	
	public static void rotate(int [][] arr, int n) {
		// 00 10 20
		// 01 11 21
		// 02 12 22
		for(int i=0 ; i<n ; i++) {
			for(int j=n-1 ; j>=0 ; j--) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
