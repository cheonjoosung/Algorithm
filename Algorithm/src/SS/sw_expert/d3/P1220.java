package SS.sw_expert.d3;

import java.util.Scanner;

//Magnetic 
public class P1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();
			int [][] a = new int[n][n];
			int count = 0;
			
			for(int i=0; i<n ; i++) 
				for(int j=0; j<n ; j++)
					a[j][i] = sc.nextInt();			
			
			//1이 N, 2가 S 위쪽이 N 극 아래가 S극
			
			for(int i=0; i<n ; i++)  {
				for(int j=0; j<n ; j++) {
					if(a[i][j] == 1) {
						for(int k=j+1 ; k<n ; k++) {
							if(a[i][k] == 2) {
								count++;
								j=k;
								break;
							}
						}
					}
				}
			}

			System.out.println("#"+t+ " " + count);
		}

		sc.close();
	}
}