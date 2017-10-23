package SS.sw_expert;

import java.util.Scanner;

//부분수열의 합
public class P2817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int Ans = 0;
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int [] arr = new int[n];
			
			int temp = 0;
			for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt();
			
			System.out.println("#"+t+ " " + Ans);
		}
		
		sc.close();
	}
}
