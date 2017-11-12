package backjun.p9000_10000;

import java.util.Scanner;

//아이들은 사탕을 좋아해 
public class P9550 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		
		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int sum = 0;
			
			for(int i=0 ; i<n ; i++) {
				int val = sc.nextInt();
				sum += val/k;
			}
			
			System.out.println(sum);
		}
		
		
		sc.close();
	}
}
