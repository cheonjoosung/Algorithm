package codeground;

import java.util.Scanner;

public class Sol58 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int n = sc.nextInt();
			long [] price = new long[n];
			
			for(int i=0; i<n ; i++)
				price[i] = sc.nextLong();
			
			for(int i=1 ; i<n ; i++) {
				if(price[i-1] < price[i]) {
					
					while((i+1) < n && price[i] < price[i+1]) {
						i++;
					}
					
					Answer += 2;
				} 
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
