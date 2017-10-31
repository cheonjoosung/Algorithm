package backjun.p4000_6000;

import java.util.Scanner;

public class P5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int day = sc.nextInt();
		
		int kor = sc.nextInt();
		int math = sc.nextInt();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(kor % a == 0) kor /= a;
		else kor = kor/a + 1;
		if(math % b == 0) math /= b;
		else math = math/b + 1;
		
		System.out.println(day - Math.max(kor, math));
		
		sc.close();
	}
}
