package codeground;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol32 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			
			ArrayList<P32> list = new ArrayList<>(); 
			
			for(int i=0; i<n ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int type = sc.nextInt();
				
				list.add(new P32(x, y, type));
			}
			
			
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}

class P32{
	int x, y, type;
	
	P32(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
