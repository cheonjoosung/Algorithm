package SS.sw_expert.test_sample;

import java.util.Scanner;

//원자 소멸 시뮬레이션
public class P5648 {
	static int [][] map;
	static boolean [] visited;
	static int ans;
	static int n, row, col;

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
				for(int j=0 ; j<col ; j++)
					map[i][j] = sc.nextInt();
			
			dfs();
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	public static void dfs() {
		
	}

}
