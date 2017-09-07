package codeground;

import java.util.Scanner;
import java.util.Stack;

public class Sol57 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			String line = sc.next();
			
			int [] dp = new int[line.length()];

			for(int i = 0 ; i < line.length() ; i++) {
				Stack<String> s = new Stack<>();
				int temp = 0;
				
				for(int j = i ; j < line.length() ; j++) {
					String c = line.charAt(j)+"";
					
					if(c.equals("(") || c.equals("{") || c.equals("[")) s.push(c);
					else {
						if(s.empty()) break;
						String val = s.pop();
						
						if(val.equals("(") && c.equals(")")) temp+=2;
						else if(val.equals("[") && c.equals("]")) temp+=2;
						else if(val.equals("{") && c.equals("}")) temp+=2;
						else break;
					}
					
					if(s.empty()) {
						dp[j] = temp;
						if(j - temp >= 0) dp[j] += dp[j-temp];
						i = j;
						break;
					}
				}
				
				if(dp[i] > Answer) Answer = dp[i];
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}