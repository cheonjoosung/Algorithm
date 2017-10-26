package SS.sw_expert.d1;

import java.util.Scanner;

//1대1 가위바위보
public class P1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		//가위 1, 주먹 2, 보 3
		
		if(a == 1 && b == 2) System.out.println("B");
		else if(a == 1 && b == 3) System.out.println("A");
		if(a == 2 && b == 1) System.out.println("A");
		else if(a == 2 && b == 3) System.out.println("B");
		if(a == 3 && b == 1) System.out.println("B");
		else if(a == 3 && b == 2) System.out.println("A");
		
		sc.close();
	}
}