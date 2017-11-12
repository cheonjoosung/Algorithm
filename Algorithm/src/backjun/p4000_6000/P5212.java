package backjun.p4000_6000;

import java.util.Scanner;

public class P5212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		int row = sc.nextInt();
		
		int [][] map = new int[row+1][col+1];
		
		for(int i=1 ; i<=col ; i++) {
			String s = sc.next();
			for(int j=0 ; j<s.length() ; j++) {
				String temp = s.charAt(j)+"";
				map[j+1][i] = (temp.equals(".") ? 0 : 1 ); //땅은 0, 물은 1 
			}
		}
		
		for(int i=1 ; i<=col ; i++) {
			for(int j=1 ; j<=row; j++) {
				int count = 0;
				
				if(map[j][i-1] == 0) count++;
				if(map[j-1][i] == 0) count++;
				
				if(i != col && map[j][i+1] == 0) count++;
				if(i == col) count++;
				if(j != row && map[j+1][i] == 0) count++;
				if(j == row) count++;
				
				if(count >= 3) map[j][i] = 0;
			}
		}
		
		for(int i=1 ; i<=col ; i++) {
			for(int j=1 ; j<=row; j++) {
				System.out.print(map[j][i] + " ");
			}
			System.out.println();
		}
		
		
		
		sc.close();
	}
}
