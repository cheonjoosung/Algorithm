package SS.sw_expert.d1;

import java.util.Scanner;

//알파벳을 숫자로 변환
public class P2050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//int a = sc.nextInt();
		String s = sc.next();
		for(int i=0 ; i<s.length() ; i++) System.out.print((s.charAt(i)-'A'+1) + " ");
		
		sc.close();
	}
}