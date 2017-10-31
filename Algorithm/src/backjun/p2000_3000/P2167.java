package backjun.p2000_3000;

import java.util.Scanner;

public class P2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();

		int [][] arr = new int[row+1][col+1];
		long [][] dp = new long[row+1][col+1];

		for(int j=1 ; j<=row ; j++)
			for(int i=1; i<=col ; i++) 
				arr[j][i] = sc.nextInt();

		int val = 0;
		for(int j=1 ; j<=col ; j++)
			for(int i=1; i<=row ; i++) {
				val += arr[i][j];
				dp[i][j] = val;
			}


		int count = sc.nextInt();

		for(int i=0 ; i<count ; i++) {
			int sx= sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();

			int sum = 0;
			for(int j=sy ; j<=ey ; j++) {
				sum += dp[ex][j] - dp[sx][j] + arr[sx][j];
			}
			System.out.println(sum);
		}

		sc.close();
	}
}
