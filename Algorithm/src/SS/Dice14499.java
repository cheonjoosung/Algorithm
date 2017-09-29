package SS;

import java.util.Scanner;

public class Dice14499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int count = sc.nextInt();
		
		int [][] map = new int[n][m];
		int [] direction = new int[count]; 
		
		for(int i=0; i<m ; i++) {
			for(int j=0; j<n ; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		for(int i=0 ; i< count ; i++) {
			direction[i] = sc.nextInt();
		}
		
		
		sc.close();
	}
}
