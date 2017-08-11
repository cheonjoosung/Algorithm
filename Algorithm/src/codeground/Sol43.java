package codeground;

import java.util.Scanner;

//43번 2개의 네비게이션
/*
 * 3->4 갈때 p는 7,q는 1
 * 1->3 갈때 p는 2,q는 20
 * ... 최단경로는 P : 1->3->5 = 6, Q : 1->2->4->5 = 9 
 */
public class Sol43 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			
			int home = sc.nextInt();
			int roadCount = sc.nextInt();
			
			for(int i=0 ; i<roadCount ; i++) {
				
			}

			Answer = 0;
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
