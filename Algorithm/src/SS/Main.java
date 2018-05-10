package SS;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int row, col, Ans, Block;
	static int [][] arr;
	static boolean [][] visited;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();
		
		Ans = 0;
		Block = 0;
		
		arr = new int[row][col];
		visited = new boolean[row][col];
		
		for(boolean [] temp : visited) 
			Arrays.fill(temp, false);
		
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 6) {
					visited[i][j] = false;
					Block++;
				}
			}
		}
		
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				if(arr[i][j] == 0 || arr[i][j] == 6) continue;
				check(arr[i][j], i, j);
			}
		}
		
		int temp = 0;
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				if(visited[i][j]) temp++;
			}
		}
		
		Ans = row*col - temp - Block; 
		System.out.println(Ans);
		
		sc.close();
	}
	
	public static void check(int cctv, int x, int y) {
		if(cctv == 1) {
			// -> 한방향만
			int res0 = count(0, x, y);
			int res1 = count(1, x, y);
			int res2 = count(2, x, y);
			int res3 = count(3, x, y);
			
			int max = Math.max(res0, Math.max(res1, Math.max(res2, res3)));
			
			if(max == res0) {
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			} else if(max == res1) {
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
			} else if(max == res2) {
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			} else if(max == res3) {
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
			}
			
		} else if(cctv == 2) {
			// 일자 모양
			int res0 = count(0,x,y) + count(2,x,y);
			int res1 = count(1,x,y) + count(3,x,y);
			
			if(res0 > res1) {
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}	
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			} else {
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
			}
			
		} else if(cctv == 3) {
			//ㄴ 모양
			int res0 = count(0,x,y) + count(1,x,y);
			int res1 = count(1,x,y) + count(2,x,y);
			int res2 = count(2,x,y) + count(3,x,y);
			int res3 = count(3,x,y) + count(0,x,y);
			
			int max = Math.max(res0, Math.max(res1, Math.max(res2, res3)));
			
			if(max == res0) {
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}			
			} else if(max == res1) {
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			} else if(max == res2) {
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
				
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
			} else if(max == res3) {
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			}
			
		} else if(cctv == 4) {
			//ㅜ 모양
			int res0 = count(0, x, y) +count(1, x, y) + count(2, x, y);
			int res1 = count(1, x, y) +count(2, x, y) + count(3, x, y);
			int res2 = count(2, x, y) +count(3, x, y) + count(0, x, y);
			int res3 = count(3, x, y) +count(0, x, y) + count(1, x, y);
			
			int max = Math.max(res0, Math.max(res1, Math.max(res2, res3)));
			
			if(max == res0) {
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
				
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			} else if(max == res1) {
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
				
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}			
			} else if(max == res2) {
				for(int j=y ; j >= 0 ; j--) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
				
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
			} else if(max == res3) {
				for(int i=x ; i <row ; i++) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
				for(int j=y ; j < col ; j++) {
					if(arr[x][j] == 6) break;
					if(!visited[x][j]) visited[x][j] = true;
				}
				
				for(int i=x ; i >= 0 ; i--) {
					if(arr[i][y] == 6) break;
					if(!visited[i][y]) visited[i][y] = true;
				}
			}
			
		} else if(cctv == 5) {
			//사방 0, 1, 2, 3 t순
			for(int j=y ; j < col ; j++) {
				if(arr[x][j] == 6) break;
				if(!visited[x][j]) visited[x][j] = true;
			}
			
			for(int i=x ; i >= 0 ; i--) {
				if(arr[i][y] == 6) break;
				if(!visited[i][y]) visited[i][y] = true;
			}
			
			for(int j=y ; j >= 0 ; j--) {
				if(arr[x][j] == 6) break;
				if(!visited[x][j]) visited[x][j] = true;
			}
			
			for(int i=x ; i <row ; i++) {
				if(arr[i][y] == 6) break;
				if(!visited[i][y]) visited[i][y] = true;
			}
		}
	}
	
	public static int count(int dir, int x, int y) {
		int cnt = 0;
		
		// 우, 하, 좌, 상 = 0,1,2,3
		switch(dir) {
		case 0:
			for(int j=y ; j<col ; j++) {
				if(arr[x][j] == 6) break;
				if(!visited[x][j]) cnt++;
			}
			break;
		case 1:
			for(int i=x ; i >= 0 ; i--) {
				if(arr[i][y] == 6) break;
				if(!visited[i][y]) cnt++;
			}
			break;
		case 2:
			for(int j=y ; j >= 0 ; j--) {
				if(arr[x][j] == 6) break;
				if(!visited[x][j]) cnt++;
			}
			break;
		case 3:
			for(int i=x ; i < row ; i++) {
				if(arr[i][y] == 6) break;
				if(!visited[i][y]) cnt++;
			}
			break;
		}
		
		return cnt;
	}
}
