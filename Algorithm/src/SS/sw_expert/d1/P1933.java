package SS.sw_expert.d1;

import java.util.Scanner;

//간단한 N의 약수
public class P1933 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.print(1 + " ");
		
		for(int i=2; i<= n ; i++)
			if(n % i == 0) System.out.print(i + " ");
		
		sc.close();
	}
}