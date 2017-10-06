package codeground;

import java.util.ArrayList;
import java.util.Scanner;

//CodeGround 64번 Divisor 
public class Sol64 {
	static int Answer;
	static ArrayList<Integer> List;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int [] num = new int[n];
			
			int [] q = new int[m];
			int [] start = new int[m];
			int [] end = new int[m];
			
			for(int i=0; i<n ; i++) {
				num[i] = sc.nextInt();
			}
			
			for(int i=0; i<m ; i++) {
				q[i] = sc.nextInt();
				start[i] = sc.nextInt()-1;
				end[i] = sc.nextInt()-1;
			}
			
			for(int i=0 ; i<m ; i++) {
				int div = q[i];
				int s = start[i];
				int e = end[i];
				
				cal(div);
				
				for(int j=s ; j <= e ; j++) {
					int k = gcd(num[j] , div);
					//System.out.println(k + " ->  " + num[j] + " , " + div);
					
					
				}
				//System.out.println(List.size());
				Answer += List.size();
			}			
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
	public static void cal(int a) {
		//제곱해서 넘는 지점을 구하고 
		List = new ArrayList<>();
		for(int i=2 ; i <= a/2 ; i++) {
			if(a % i == 0) {
				List.add(i);
			}
		}
		List.add(a);
	}
}
