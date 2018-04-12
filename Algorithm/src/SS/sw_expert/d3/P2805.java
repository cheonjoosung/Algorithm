package SS.sw_expert.d3;

import java.util.Scanner;

public class P2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			int n = sc.nextInt();
			int sum = 0;

			int [][] arr = new int[n][n];

			for(int i=0; i <n ; i++) {
				String s = sc.next();
				for(int j=0; j<s.length() ; j++) {
					arr[i][j] = Integer.parseInt(s.charAt(j)+"");
				}
			}
			
			for(int j=0 ; j<n ; j++) sum += arr[n/2][j];
			for(int i=0 ; i<n/2 ; i++) {
				for(int j=(n/2-i) ; j<=(n/2+i) ; j++) {
					sum += arr[i][j];
					sum += arr[(n-1) - i][j];
				}
			}
			
			
			if(n == 1) {
				System.out.println("#" + tc + " " + arr[0][0]);
			} else {
				System.out.println("#" + tc + " " + sum);
			}
		}

		sc.close();
	}
}
