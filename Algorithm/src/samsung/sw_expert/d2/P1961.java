package samsung.sw_expert.d2;

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

			rotate(a, a1, n);
			rotate(a1, a2, n);
			rotate(a2, a3, n);

			System.out.println("#" + t);	

			for(int i=0; i<n; i++) {
				for(int j=0; j<n ; j++) System.out.print(a1[j][i]);
				System.out.print(" ");
				for(int j=0; j<n ; j++) System.out.print(a2[j][i]);
				System.out.print(" ");
				for(int j=0; j<n ; j++) System.out.print(a3[j][i]);	
				System.out.println();
			}
		}

		sc.close();
	}

	public static void rotate(int [][] arr, int [][] temp, int n) {
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				temp[j][i] = arr[i][n-j-1];
	}
}
