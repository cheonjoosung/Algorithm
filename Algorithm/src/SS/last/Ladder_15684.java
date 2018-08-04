package SS.last;

import java.util.Scanner;

////백준 15684 사다리 조작
public class Ladder_15684 {
	static int n, m, h, Ans;
	static int [][] map;
	static boolean [][] isVistied;
	static boolean isPossible, temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//n가로선의 갯수(칼럼), m세로선의 갯수(로우), h세로선마다 가로선을 놓을수 있는 갯수
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt(); 

		Ans = -1;
		isPossible = false;
		map = new int[h+1][n+1];
		isVistied = new boolean[h+1][n+1];

		for(int i=1 ; i<=m ; i++) {
			int x = sc.nextInt(); //사다리 가로선 정보
			int y = sc.nextInt(); //사다리 가로선 정보
			map[x][y] = 1; //1은 현재 가로선이 있다는 표시
		}	

		/*
		 * 두개의 가로선은 연속으로 놓을 수 없다. 접해서도 안된다
		 * 사다리 0~3개 까지 선택 가능
		 */
		for(int i=0 ; i<=3 ; i++) { 
			if(i==0) {
				search();
			} else {
				dfs(1, 1, i, 0);
			}

			if(isPossible) {
				Ans = i;
				break;
			}
		}

		//정답이 3보다 크거나 없으면 -1, 그렇지 않다면 최소값 출력
		System.out.println(Ans);

		sc.close();
	}

	public static void dfs(int x, int y, int cnt, int depth) { // cnt - 사다리 갯수 
		if(cnt == depth) {
			search();
			return;
		}
		
		for(int i=1 ; i<=h ; i++) {
			for(int j=1 ; j<n ; j++) {
				if(isVistied[i][j]) continue;
				if(map[i][j-1] == 1 || map[i][j+1] ==1 || map[i][j] == 1) continue; //연속으로 오면 안되므로
				
				isVistied[i][j] = true;
				map[i][j] = 1;
				
				dfs(i, j, cnt, depth+1);
				isVistied[i][j] = false;
				
				map[i][j] = 0;
			}
		}
		
	}

	public static void search() { //(x,y) 현재위치, start 값 val 내려가는 값
		boolean temp = true;
		
		for(int start=1 ; start<n ; start++) { //사다리 시작값
			int end = start; //마지막 도착한값
			int col = start; //col 의 이동을 위해
			int row = 1;

			while(row <= h) { //temp 는 제일 윗칸에서 시작
				//tem.out.println(row + " " + col);
				if(map[row][col] == 1) {
					end++;
					col++;
				} else{
					if(map[row][col-1] == 1) {
						end--;
						col--;
					}
				}

				row++;
			}

			//System.out.println(end + " " + start);
			if(end != start) {
				temp = false;
				break;
			}
		}
		
		if(temp) isPossible = true;
	}
}