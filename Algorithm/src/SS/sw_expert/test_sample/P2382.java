package SS.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//미생물 격리 
public class P2382 {
	static int ans, m, k, n;
	static int [][] map;
	static int [] dx = {0, -1, 0 , 1};
	static int [] dy = {1, 0, -1, 0};
	static boolean [][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();

			ans = 0;

			map = new int[n][n];
			visited = new boolean[n][n];

			for(boolean [] temp : visited)
				Arrays.fill(temp, false);

			for(int [] temp : map)
				Arrays.fill(temp, 0); //x == 0, y == 0, x == size-1, y == size-1 벽 위치

			ArrayList<Micro> list = new ArrayList<>();

			for(int i=0 ; i<k ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt(); // 1상, 2하, 3좌, 4우

				list.add(new Micro(x, y, cnt, dir));
			}
			
			for(int i=0 ; i<m ; i++) {
				for(int j=0 ; j<m ; j++) {
					//계산
				}
			}

			//구하는 건 M시간 후 남아있는 미생물 수의 총 합

			System.out.println("#" + test_case + " " + ans + " ");
		}

		sc.close();
	}
}

class Micro {
	int x; int y; int cnt; int dir;
	Micro(int x, int y, int cnt, int dir) {
		this.x=x; 
		this.y=y; 
		this.cnt = cnt; 
		this.dir = dir;
	}
}
