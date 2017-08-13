package codeground;

import java.util.Scanner;

public class Sol50 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int numOfPeople = sc.nextInt();
			int numOfCoffee = sc.nextInt();
			int money = sc.nextInt();
			int sum = 0;
			
			int [] like = new int[numOfPeople];
			int [] price = new int[numOfCoffee]; 
			
			for(int i=0 ; i<numOfPeople ; i++) {
				like[i] = sc.nextInt();
			}
			
			for(int i=0; i <numOfCoffee ; i++) {
				price[i] = sc.nextInt();
			}
			
			for(int k : like)
				sum += price[k-1];
			
			//System.out.println(sum + " , " + money);
			
			System.out.println("Case #"+(test_case+1));
			
			if(sum <= money) System.out.println("Y");
			else System.out.println("N");
		}
	}

}
