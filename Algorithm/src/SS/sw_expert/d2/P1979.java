package SS.sw_expert.d2;

import java.util.Scanner;

//어디에 단어가 들어갈 수 있을까 
public class P1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int [][] a = new int[n][n];
			int count = 0;
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0; j<n ; j++) {
					a[j][i] = sc.nextInt();
				}
			}
			
			System.out.println("#" + t + " ");
		}

		sc.close();
	}
}
