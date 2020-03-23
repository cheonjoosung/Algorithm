package samsung.sw_expert.d1;

import java.util.Scanner;

//N줄 덧셈
public class P2027 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println((n*(n+1))/2);
		
		sc.close();
	}
}