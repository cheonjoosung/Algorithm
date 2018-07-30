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
		
		/*dir 0 북, 1 동, 2 남, 3 서 
		 * (r,c) r을 북쪽에서 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 개수 
		 * 1. 현재 자리 청소. (기본은 0 청소하면 1로 표시) 
		 * 2. 왼쪽 방향으로 탐색
		 * 2-1. 왼쪽에 청소할 공간있으면 한칸 전진후 1로 돌아간다.
		 * 2-2. 왼쪽에 청소할 공간없으면 2번으로 돌아간다.
		 * 2-3. 다 청소되어있으면 기존방향을 유지한채로 한칸 후진. 
		 * 3. 네 방향 청소되고 후진도 불가능한 상태인 경우 작동 중지
		 */
		
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
