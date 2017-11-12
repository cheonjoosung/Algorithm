package backjun.p2000_3000;

import java.util.Scanner;

//5와 6의 차이 
public class P2864 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		String temp = a;
		String temp2 = b;
		
		temp = temp.replaceAll("5", "6");
		temp2 = temp2.replaceAll("5", "6");
		
		int max = Integer.parseInt(temp) + Integer.parseInt(temp2);
		
		temp = a;
		temp2 = b;
		
		temp = temp.replaceAll("6", "5");
		temp2 = temp2.replaceAll("6", "5");
		
		int min = Integer.parseInt(temp) + Integer.parseInt(temp2);
		
		System.out.println(min + " " + max);
		
		sc.close();
	}
}
