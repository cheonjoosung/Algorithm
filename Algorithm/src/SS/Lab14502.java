package SS;

import java.util.Scanner;

public class Lab14502 {
	public static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//완전탐색 예상
		int col = sc.nextInt();
		int row = sc.nextInt();
		
		map = new int[row][col];
		
		int firstWallX = 0;
		int firstWallY = 0;
		int secondWallX = 0;
		int secondWallY = 0;
		int thirdWallX = 0;
		int thirdWallY = 0;
		
		for(int i=0; i<col ; i++) {
			for(int j=0; j<row ; j++) {
				map[j][i] = sc.nextInt();
			}
		}
		
		while(firstWallX != (row-3) || firstWallY != (col-1)) {
			if(firstWallX + 1 == row) {
				secondWallX = 0;
				secondWallY = firstWallY + 1;;
			} else {
				secondWallX = firstWallX + 1;
				secondWallY = firstWallY;
			}
			
			while(secondWallX != (row-2) || secondWallY != (col-1)) {
				if(secondWallX + 1 == row) {
					thirdWallX = 0;
					thirdWallY = secondWallY + 1;;
				} else {
					thirdWallX = secondWallX + 1;
					thirdWallY = secondWallY;
				}
				
				while(thirdWallX != (row-1) || thirdWallY != (col-1)) {	
					
					if(thirdWallX + 1 == row) {
						thirdWallX = 0;
						thirdWallY++;
					} else {
						thirdWallX++;
					}
				}
				
				
				
				if(secondWallX + 1 == row) {
					secondWallX = 0;
					secondWallY++;
				} else {
					secondWallX++;
				}
			}
			
			if(firstWallX + 1 == row) {
				firstWallX = 0;
				firstWallY++;
			} else {
				firstWallX++;
			}
		}
		
		

		System.out.println(firstWallX + " : " + firstWallY + "  ,  " 
				+ secondWallX + " : " + secondWallY + "  ,  "
				+ thirdWallX + " : " + thirdWallY + "  ,  ");
		
		sc.close();
	}
	
	public static void virus(int [][] map){
	}
}
