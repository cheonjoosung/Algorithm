package backjun.p1000_2000;

import java.util.Arrays;
import java.util.Scanner;

//농구 경기
public class P1159 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [] name = new int[26];
		Arrays.fill(name, 0);
		
		
		for(int i=0 ; i<n ; i++) {
			String s = sc.next();
			char f = s.charAt(0);
			
			name[(int)f-(int)'a']++;
		}
		
		boolean isNo = false;
		for(int i=0 ; i<name.length ; i++) {
			if(name[i] >= 5) {
				isNo = true;
				System.out.print((char)(i+'a'));				
			}
		}
		if(!isNo) System.out.println("PREDAJA");

		sc.close();
	}
}
