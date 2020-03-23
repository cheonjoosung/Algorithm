package samsung.sw_expert.d4;

import java.util.Scanner;

//3349번 최솟값으로 이동하기
public class P3349 {
	static int w, h, n, ans, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			w = sc.nextInt();
			h = sc.nextInt();
			n = sc.nextInt();
			
			ans = 0;
			
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			
			for(int i=0 ; i<n-1 ; i++) { //x1,y1 -> x2,y2 -> x3,y3 가능 방식으로
				int nx = sc.nextInt();
				int ny = sc.nextInt();
				
				int cnt = 0;
				
				if(nx >= sx && ny <= sy) {//지름길 없음
					cnt = (nx-sx) + (sy-ny);
				} else if(nx <= sx && ny>= sy) {//지름길 없음
					cnt = (sx-nx) + (ny-sy);
				} else if(nx > sx && ny > sy) { //지름길
					int min = Math.min(Math.abs(sx-nx), Math.abs(sy-ny));
					cnt = nx - (sx+min) + ny - (sy+min) + min;
				} else { //지름길
					int min = Math.min(Math.abs(sx-nx), Math.abs(sy-ny));
					cnt = sx - (nx+min) + sy - (ny+min) + min;
				}
				
				sx = nx;
				sy = ny;
				ans += cnt;
			}			

			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}
}