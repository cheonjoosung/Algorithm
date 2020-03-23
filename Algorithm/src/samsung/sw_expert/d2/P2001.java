package samsung.sw_expert.d2;

import java.util.Scanner;

//파리 퇴치 
public class P2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {	
			int n = sc.nextInt();
			int m = sc.nextInt();

			int [][] a = new int[n][n];

			int sum = 0;

			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++)
					a[j][i] = sc.nextInt();

			for(int l=0 ; l<n-m+1 ; l++) {
				for(int k=0 ; k<n-m+1 ; k++){
					int temp = 0;
					
					for(int i=0 ; i<m ; i++) {
						for(int j=0 ; j<m ; j++) {
							temp+= a[j+k][i+l];
						}
					}

					sum = Math.max(sum, temp);
				}
			}



			System.out.println("#" + t + " " + sum);
		}

		sc.close();
	}
}
