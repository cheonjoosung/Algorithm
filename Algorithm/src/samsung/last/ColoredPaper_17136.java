package samsung.last;

import java.util.Scanner;

public class ColoredPaper_17136 {
	static int [][] map;
	static int ans, n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[n][n];
		ans = 0;
		n = 10;
		
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				map[i][j] = sc.nextInt();
		
		/*
		 * 1. 색종이 1*1, 2*2, 3*3, 4*4, 5*5 각 5종류씩 가지고 있다. 
		 * 2. 붙일 때 경계밖으로 나가서면 안됨. 겹쳐도 안됨. 1이 적힌 칸만 덮을 수 있음
		 */
		
		
		//불가능하면 -1, 최소 색종이의 수
		System.out.println(ans);		
		sc.close();
	}
}