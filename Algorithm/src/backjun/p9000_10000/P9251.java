package backjun.p9000_10000;

import java.util.Scanner;

public class P9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		sc.close();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int x = 1; x <= str1.length(); x++) {
			char c1 = str1.charAt(x - 1);

			for (int y = 1; y <= str2.length(); y++) {
				char c2 = str2.charAt(y - 1);

				if (c1 == c2) {
					// 값이 같으면 좌측 대각선 위의 값 + 1
					dp[x][y] = dp[x - 1][y - 1] + 1;
				} else {
					// 값이 다르면 좌측(x-1), 상단(y-1)의 값중 더 큰 값
					dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
				}
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
