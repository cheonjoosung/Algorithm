package codeground;

import java.util.Scanner;

//CodeGround 11번 개구리 점프
public class Sol11 {
	static int Answer;

	public static void main(String args[]) throws Exception	{Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();

	for (int test_case = 0; test_case < T; test_case++) {
		Answer = 0;
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		int jump = 0;

		for (int i = 0; i < arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		jump = sc.nextInt();

		int state = 0;

		for (int i = 0; i < arrSize; i++) {
			if (arr[i] - state < jump) {
				if(i == arrSize-1) {
					Answer++;
				}
				continue;
			} else if (arr[i] - state > jump) {
				if(arr[i] - arr[i-1] > jump) {
					Answer = -1;
					break;
				} else if(arr[i] - arr[i-1] == jump) {
					Answer += 2;
					state = arr[i];
					continue;
				} else {
					state = arr[i-1];
					Answer += 1;
					i--;
					continue;
				}
			} else {
				Answer += 1;
				state = arr[i];
				continue;
			} 
		}

		System.out.println("Case #" + (test_case + 1));
		System.out.println(Answer);
	}
	}
}
