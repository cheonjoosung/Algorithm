package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Test {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int [][] a = new int[n][n];
			
			for(int i=0; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					//a[i][j] = sc.nextInt();
					int val = sc.nextInt();
					
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}