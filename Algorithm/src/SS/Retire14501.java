package SS;

import java.util.Scanner;

public class Retire14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] day = new int[n];
		int [] pay = new int[n];
		
		int answer = 0;
		
		for(int i=0 ; i<n ; i++) {
			day[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		
		sc.close();
	}
}
