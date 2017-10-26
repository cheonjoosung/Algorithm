package SS.sw_expert.d1;

import java.util.Scanner;

//스탬프 찍기
public class P2046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		for(int i=0 ; i<a ; i++) System.out.print("#");
		System.out.println();
		
		sc.close();
	}
}