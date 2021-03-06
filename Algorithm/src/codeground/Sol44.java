package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sol44 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 1;

			ArrayList<Pass> list = new ArrayList<>();

			int numTown = sc.nextInt();
			int count = sc.nextInt();

			int [] arr = new int[numTown];

			Arrays.fill(arr, -1);

			for(int i=0 ; i<count ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				list.add(new Pass(a, b));
			}

			for(Pass a : list) {
				int s = a.s;
				int e = a.e;

				if(arr[s-1] == -1 && arr[e-1] == -1) {
					arr[s-1] = 1; 
					arr[e-1] = 0;
				} else if(arr[s-1] != -1 && arr[e-1] == -1) {
					int k = arr[s-1];

					if(k == 1) {
						arr[e-1] = 0;
					} else {
						arr[e-1] = 1;
					}
				} else if(arr[s-1] == -1 && arr[e-1] != -1) {
					int k = arr[e-1];

					if(k == 1) {
						arr[s-1] = 0;
					} else {
						arr[s-1] = 1;
					}
				} else {
					int m = arr[s-1];
					int n = arr[e-1];
					
					if(m == n) {
						Answer = 0;
						break;
					}
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}

class Pass {
	int s;
	int e;

	public Pass(int s, int e){
		this.s = s;
		this.e = e;
	}

}
