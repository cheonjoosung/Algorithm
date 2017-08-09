package codeground;

import java.util.Scanner;

//49번 안녕 
public class Sol49 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			int hCount = 0, eCount = 0, lCount = 0, oCount = 0;
			String line = sc.next();
			
			for(int i = 0 ; i < line.length() ; i++) {
				 Character s = line.charAt(i);
				if(s.equals('h')){
					hCount++;
				} else if(s.equals('e')){
					eCount++;
				} else if(s.equals('l')){
					lCount++;
				} else if(s.equals('o')){
					oCount++;
				}
			}
			
			int minCount = Math.min(Math.min(hCount, eCount), oCount);
			
			while(minCount > 0 && lCount > 1) {
				minCount--;
				lCount -= 2;
				Answer++;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
