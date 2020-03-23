package samsung.last;

import java.util.ArrayList;
import java.util.Scanner;

//백준 15683 감시 
class CCTV {
	public int x, y, type, dir;
	public CCTV(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.dir = 0;
	}
}

public class CCTV_15683 {
	static int row, col, Ans, wallCount;

	static int [][] map;
	static ArrayList<CCTV> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();

		Ans = Integer.MAX_VALUE;
		wallCount = 0;
		list = new ArrayList<>();
		map = new int[row][col];

		/*
		 * CCTV : 1,2,3,4,5  /  벽 : 6  /  빈칸 : 0 
		 */
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				int val =  sc.nextInt();
				map[i][j] = val;
				if(val == 6) wallCount++;
				else {
					if(val != 0)
						list.add(new CCTV(i, j, val));
				}
			}
		}

		dfs(0);

		System.out.println(Ans);

		sc.close();
	}

	public static void dfs(int idx) {
		/*
		 * 1번 : 방향[0-우, 1-하, 2-좌, 3-상]
		 * 2번 : 방향[0-좌우, 1-상하]
		 * 3번 : 방향[0-우하, 1-하좌, 2-좌상, 3-상우]
		 * 4번 : 방향[0-우하좌, 1-하좌상, 2-좌상우, 3-상우하]
		 * 5번 : 방향[0-상하좌우]
		 */
		if(idx == list.size()) {
			//계산하기
			int [][] copyArr = new int[row][col];
			for(int i=0 ; i<map.length ; i++) 
				copyArr[i] = map[i].clone();

			int temp = check(copyArr); //감시영역
			int res = (row*col) - (temp + wallCount + list.size()); //전체 - (영역 + 벽수 + CCTV 갯수)
			
			Ans = Math.min(Ans, res);

			return;
		}

		switch(list.get(idx).type) {
		case 1:
			for(int d=0 ; d<4 ; d++) {
				list.get(idx).dir = d;
				dfs(idx+1);
			}
			break;
		case 2:
			for(int d=0 ; d<2 ; d++) {
				list.get(idx).dir = d;
				dfs(idx+1);
			}
			break;
		case 3:
			for(int d=0 ; d<4 ; d++) {
				list.get(idx).dir = d;
				dfs(idx+1);
			}
			break;
		case 4:
			for(int d=0 ; d<4 ; d++) {
				list.get(idx).dir = d;
				dfs(idx+1);
			}
			break;
		case 5:
			dfs(idx+1);
			break;
		}
	}

	public static int check(int [][] copyArr) { //CCTV 감시하는 영역
		/*
		 * 1번 : 방향[0-우, 1-하, 2-좌, 3-상]
		 * 2번 : 방향[0-좌우, 1-상하]
		 * 3번 : 방향[0-우하, 1-하좌, 2-좌상, 3-상우]
		 * 4번 : 방향[0-우하좌, 1-하좌상, 2-좌상우, 3-상우하]
		 * 5번 : 방향[0-상하좌우]
		 */
		int cnt = 0;

		for(int i=0 ; i<list.size() ; i++) {
			CCTV tv = list.get(i);
			int type = tv.type;
			int dir = tv.dir;
			int x = tv.x;
			int y = tv.y;

			//영역으로 표시되면 -1로 표시
			switch(type) {
			case 1:
				if(dir == 0) 
					cnt += search(x, y, 0, copyArr);
				else if(dir == 1) 
					cnt += search(x, y, 1, copyArr);
				else if(dir == 2) 
					cnt += search(x, y, 2, copyArr);
				else
					cnt += search(x, y, 3, copyArr);
				break;
			case 2:
				if(dir == 0) {
					cnt += search(x, y, 0, copyArr);
					cnt += search(x, y, 2, copyArr);
				} else {
					cnt += search(x, y, 1, copyArr);
					cnt += search(x, y, 3, copyArr);
				}
				break;
			case 3:
				if(dir == 0) {
					cnt += search(x, y, 0, copyArr);
					cnt += search(x, y, 1, copyArr);
				} else if(dir == 1) {
					cnt += search(x, y, 1, copyArr);
					cnt += search(x, y, 2, copyArr);
				} else if(dir == 2) {
					cnt += search(x, y, 2, copyArr);
					cnt += search(x, y, 3, copyArr);
				} else {
					cnt += search(x, y, 0, copyArr);
					cnt += search(x, y, 3, copyArr);
				}
				break;
			case 4:
				if(dir == 0) {
					cnt += search(x, y, 0, copyArr);
					cnt += search(x, y, 1, copyArr);
					cnt += search(x, y, 2, copyArr);
				} else if(dir == 1) {
					cnt += search(x, y, 1, copyArr);
					cnt += search(x, y, 2, copyArr);
					cnt += search(x, y, 3, copyArr);
				} else if(dir == 2) {
					cnt += search(x, y, 2, copyArr);
					cnt += search(x, y, 3, copyArr);
					cnt += search(x, y, 0, copyArr);
				} else {
					cnt += search(x, y, 3, copyArr);
					cnt += search(x, y, 0, copyArr);
					cnt += search(x, y, 1, copyArr);
				}
				break;
			case 5:
				cnt += search(x, y, 0, copyArr);
				cnt += search(x, y, 1, copyArr);
				cnt += search(x, y, 2, copyArr);
				cnt += search(x, y, 3, copyArr);
				break;
			}
		}

		return cnt;
	}

	public static int search(int x, int y, int dir, int [][] arr) { // 0-우, 1-하, 2-좌, 3-상 
		int cnt = 0;

		if(dir == 0) {
			for(int i=y+1 ; i<col ; i++) {
				if(arr[x][i] == 6) break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					cnt++;
				}
			}
		} else if(dir == 1) {
			for(int i=x-1 ; i>=0 ; i--) {
				if(arr[i][y] == 6) break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					cnt++;
				}
			}
		} else if(dir == 2) {
			for(int i=y-1 ; i>=0 ; i--) {
				if(arr[x][i] == 6) break;
				if(arr[x][i] == 0) {
					arr[x][i] = -1;
					cnt++;
				}
			}
		} else {
			for(int i=x+1 ; i<row ; i++) {
				if(arr[i][y] == 6) break;
				if(arr[i][y] == 0) {
					arr[i][y] = -1;
					cnt++;
				}
			}
		}

		return cnt;
	}
}