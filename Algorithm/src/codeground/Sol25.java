package codeground;

import java.math.BigInteger;
import java.util.Scanner;

//25번 3N+1 
public class Sol25 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int k = sc.nextInt();

			BigInteger max = BigInteger.valueOf(2).pow(k);
			
			long min = 1;
			long num = 0;
			int totalCount = 0;
			
			for(int i=1; ; i++) {
				num = i;
				
				for(int j=0 ; j<k ;j++) {
					if(num % 2 == 0) {
						num = num/2;
						totalCount++;
					} else if(num %2 !=0 && num !=1){
						num = 3*num + 1;
						totalCount++;
					} else if(num == 1) {
						break;
					}
				}
				
				if(totalCount == k && num == 1) {
					min = i;
					break;
				}
				
				totalCount = 0;
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(min + " " + max);
		}
	}


}
