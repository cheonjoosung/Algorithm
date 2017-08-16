package codeground;

import java.util.ArrayList;
import java.util.Scanner;

class Sol16 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int seqSize = sc.nextInt();
			long [] seq = new long[seqSize];
			
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=0 ; i<seqSize ; i++) 
				seq[i] = sc.nextLong();
			
			long d = seq[1] - seq[0];
			
			if(d == 0) {
				for(int i= 1; i< seqSize ; i++) {
					if(seq[i-1] + d == seq[i]) {
						Answer = 1;
					} else {
						Answer = 0;
						break;
					}
				}
			} else {
				//약수를 구해야 함
				//마지막까지 검증
				long minVal = 99999999;
				
				for(int i=1; i< seqSize ; i++) {
					if(seq[i] - seq[i-1] < minVal) {
						minVal = seq[i] - seq[i-1];
					}
				}
				
				for(int i=1; i <= minVal ; i++) {
					if(minVal % i == 0) 
						list.add(i);
				}
				Answer = list.size();
			}
			
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
