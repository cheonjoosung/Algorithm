package SS;

import java.util.Scanner;

public class Tetris14500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int [][] map = new int[n][m];
		
		for(int i=0; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		sc.close();
	}
}
