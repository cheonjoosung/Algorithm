package samsung.sw_expert.d1;

import java.util.Scanner;

//대각선 출력하기
public class P2025 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//int n = sc.nextInt();
		
		for(int i=0; i<5 ; i++) {
			for(int j=0; j<5 ; j++) {
				if(i == j) System.out.print("#");
				else System.out.print("+");
			}
			System.out.println();
		}
		
		sc.close();
	}
}