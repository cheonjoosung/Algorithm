package SS.sw_expert.test_sample;

import java.util.Scanner;

//벽돌 깨기
public class P5656 {
	static int [][] map;
	static boolean [] visited;
	static int ans;
	static int n, row, col, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt(); //시작 칼럼 위치
			col = sc.nextInt();
			row = sc.nextInt();
			
			ans = 0;
			map = new int[row][col];
			
			for(int i=row-1 ; i>=0 ; i--)
				for(int j=0 ; j<col ; j++) {
					int val = sc.nextInt();
					map[i][j] = sc.nextInt();
					if(val != 0) cnt++; //기존의 벽돌인 것 수 체크
				}
			
			/*
			 * 0. 맵 초기화
			 * 1. 떨어질 공의 위치 선택 (0,0,0) -> (0,0,1) ... 완전 탐색해야함 배열생성한후
			 * 2. 떨어진 그 지점으로부터 맵 변화시키기
			 * 2-1. 해당 위치가 3이고 퍼져나갈 경우 1이면 그냥 0으로 변화시키고. 그게 아닐경우는 다시 큐에 집어 넣는다?
			 * 2-2. 큐가 0이 될때까지 반복하면서 다 지운다
			 * 3. 
			 */
			
			dfs();
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	public static void dfs() {
		
	}

}
