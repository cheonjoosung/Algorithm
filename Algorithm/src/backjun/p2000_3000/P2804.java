package backjun.p2000_3000;

import java.util.Arrays;
import java.util.Scanner;

//크로스워드 만들기
public class P2804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String horizontal = sc.next();
		String vertical = sc.next();
		
		int row = horizontal.length();
		int col = vertical.length();
		
		String [][] arr = new String[row][col];
		for(String [] temp : arr) Arrays.fill(temp, ".");
		
		//BANANA PIDZAMA
		int idx = -1;
		int idy = -1;
		
		for(int i=0 ; i<horizontal.length() ; i++) {
			String temp = horizontal.charAt(i)+"";
			if(vertical.contains(temp)) {
				idx = i;
				idy = vertical.indexOf(temp);
				break;
			}
		}
		
		System.out.println(idx + " " + idy);
		
		for(int i=0 ; i<col ; i++) arr[idx][i] = vertical.charAt(i)+"";
		for(int i=0 ; i<row ; i++) arr[i][idy] = horizontal.charAt(i)+"";
		
		for(int i=0 ; i<col ; i++) {
			for(int j=0 ; j<row ; j++) {
				System.out.print(arr[j][i]);
			}
			System.out.println();
		}
		sc.close();
	}
}
