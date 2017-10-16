package backjun.etc;

import java.util.Scanner;

public class P10026 {
	static int Red = 0;
	static int Blue = 1;
	static int Green = 2;

	static int [][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		map = new int[n][n];
		String [] s = new String[n];

		for(int i=0 ; i<n ; i++)
			s[i] = sc.next();

		for(int i=0 ; i<n ; i++) {
			String temp = s[i];
			for(int j=0 ; j<n ; j++) {
				if( (temp.charAt(j) + "").equals("R") ) map[j][i] = Red;
				else if( (temp.charAt(j) + "").equals("B") ) map[j][i] = Blue;
				else map[j][i] = Green;
			}
		}

		for(int i=0 ; i<n ; i++) 
			for(int j=0; j<n ; j++) {
				System.out.print(map[j][i] + " ");
				if(j == n-1) System.out.println();
			}


		sc.close();
	}
}
