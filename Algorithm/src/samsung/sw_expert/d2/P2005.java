package samsung.sw_expert.d2;

import java.util.Scanner;

//파스칼의 삼각형
public class P2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {	
			int n = sc.nextInt();
			
			int [][] a = new int[n+1][n+1];
			a[1][1] = 1;
			
			for(int i=1; i<= n ; i++) {
				for(int j=1 ; j<=n ; j++) {
					if(j ==1 || j == i) a[j][i] = 1;
					else a[j][i] = a[j][i-1] + a[j-1][i-1];
				}
			}
			
			System.out.println("#" + t);
			for(int i=1; i<=n ; i++) {
				for(int j=1 ; j<=i ; j++) {
					System.out.print(a[j][i] + " ");
				}
				System.out.println();
			}
		}

		sc.close();
	}
}
