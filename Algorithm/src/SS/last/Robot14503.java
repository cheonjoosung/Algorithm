package SS.last;

import java.util.Scanner;

public class Robot14503 {
	public static int Ans;
	public static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Ans = 0;
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int dir = sc.nextInt(); //0 북, 1 동 , 2 남, 3 서 
		
		map = new int[row][col];
		
		for(int i=0 ; i<row ; i++)
			for(int j=0 ; j<col ; j++)
				map[i][j] = sc.nextInt();
		
		while(true) {
			if(map[x][y] == 0) {
				map[x][y] = 2;
				Ans++;
			}
			
			boolean back = true;

			for(int i=0 ; i< 4 ; i++) {
				if(dir == 3) {
					dir = 2;
					if(map[x+1][y] == 0) {
						x++;
						back = false;
						break;
					}
				} else if(dir == 2){
					dir = 1;
					if(map[x][y+1] == 0) {
						y++;
						back = false;
						break;
					}
				} else if(dir == 1) {
					dir = 0;
					if(map[x-1][y] == 0) {
						x--;
						back = false;
						break;
					}
				} else if(dir == 0) {
					dir = 3;
					if(map[x][y-1] == 0) {
						y--;
						back = false;
						break;
					}
				}
			}
			
			if(back) {
				if(dir == 3) {
					if(map[x][y+1] == 1) break;
					else y++;
				} else if(dir == 2) {
					if(map[x-1][y] == 1) break;
					else x--;
				} else if(dir == 1) {
					if(map[x][y-1] == 1) break;
					else y--;
				} else if(dir == 0) {
					if(map[x+1][y] == 1) break;
					else x++;
				}
			}
		}
				
		System.out.println(Ans);

		sc.close();
	}

}
