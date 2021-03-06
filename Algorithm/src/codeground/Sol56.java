package codeground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//56번 극단적인 수
public class Sol56 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int exNum = sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int temp = exNum;
			
			while(temp != 0) {
				list.add(temp);
				temp = (temp-1) / 2;
			}
			
			Collections.sort(list);
			
			String result = "";

			temp = 0;
			
			for(int k : list) {
				if(k == temp*2 +1) {
					result += "4";
					temp = temp*2 + 1;
				} else {
					result += "7";
					temp = temp*2 + 2;
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(result);
		}
	}


}
