package backjun.p10000_11000;

import java.util.Scanner;

public class P10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] arr = new String[5];
		
		for(int i=0 ; i<5 ; i++) arr[i] = sc.next();
		int len = arr[0].length();
		
		for(int i=0 ; i<len ; i++) {			
			for(int j=0 ; j<5 ; j++) {
//				System.out.println(j + " " + i);
				if(arr[j].length() <= i) continue;
				System.out.print(arr[j].charAt(i));
			}
		}
		
		System.out.println();
		
		sc.close();
	}
}
