package SS;

import java.util.Scanner;

public class Lab14502 {
	public static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//완전탐색 예상
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		map = new int[n][m];
		
		for(int i=0; i<m ; i++) {
			for(int j=0; j<n ; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		
		sc.close();
	}
}
