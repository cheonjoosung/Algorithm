package backjun.lecture.p10000_11000;

import java.util.Scanner;

public class P10709 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int col = sc.nextInt();
		int row = sc.nextInt();

		int [][] arr = new int[row][col];

		for(int i=0 ; i<col ; i++) {
			String s = sc.next();
			for(int j=0 ; j<s.length() ; j++) 
				arr[j][i] = s.charAt(j) == 'c' ? 0 : -1;
		}

		for(int i=0 ; i<col ; i++) 
			for(int j=1 ; j<row ; j++) {
				if(arr[j][i] == 0) continue;
				else {
					if(arr[j-1][i] == -1) arr[j][i] = -1;
					else arr[j][i] = arr[j-1][i] + 1;
				}
			}

		for(int i=0 ; i<col ; i++) {
			for(int j=0 ; j<row ; j++)
				System.out.print(arr[j][i] + " ");
			System.out.println();
		}

		sc.close();
	}
}
