package samsung.sw_expert.test_sample;

import java.util.Scanner;


//차량 정비소
public class P2477 {
	static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			

			System.out.println("#" + test_case + " " + ans + " ");
		}

		sc.close();
	}
}
