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
			int count = 0;
			int len1 = 0, len2 = 0;

			int [][] a = new int[n][n];

			for(int i=0 ; i<n ; i++)
				for(int j=0; j<n ; j++)
					a[j][i] = sc.nextInt();

			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(a[j][i] == 1) {
						len1++;
						if(j == n-1) {
							if(len1 == k) count++;
							len1 = 0;
						}
					} else {
						if(len1 == k) count++;
						len1 = 0;
					}

					if(a[i][j] == 1) {
						len2++;
						if(j == n-1) {
							if(len2 == k) count++;
							len2 = 0;
						}
					} else {
						if(len2 == k) count++;
						len2 = 0;
					}
				}
			}

			System.out.println("#" + t + " " + count);
		}

		sc.close();
	}
}
