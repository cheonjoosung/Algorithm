package codeground;

import java.util.Scanner;

public class Sol55 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			System.out.println("Case #"+(test_case+1));
			hanoi(n, 1, 2, 3);
			/*
			 * 2^n - 1 만큼 이동
			 * 1. 기둥 1에서 n-1 개의 원판을 기둥 3를 이용하여 기둥 2로 옮긴다.
			 * 2. 기둥 1에서 남은 1개의 원판을 기둥 3으로 옮긴다.
			 * 3. 기둥 2에서 n-1 개의 원판을 기둥 1을 이용하여 기둥 3으로 옮긴다.  
			 */
		}
	}
	
	public static void hanoi(int n, int from, int by, int to) {
		if(n == 1) {
			move(from, to);
		} else {
			hanoi(n-1,from,to,by);
			move(from,to);
			hanoi(n-1,by,from,to);        
		}
	}
	
	public static void move(int a, int b) {
		System.out.println(a + " -> " + b);
	}
}
