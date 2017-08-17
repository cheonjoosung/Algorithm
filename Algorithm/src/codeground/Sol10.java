package codeground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sol10 {
	static long Answer;
	static int MOD = 1_000_000_007;
	static long[] fact = new long[2000003];

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		fact[0] = 1;
		for(int i = 1; i < 200001; i++)
			fact[i] = i * fact[i-1] % MOD;

		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int row = sc.nextInt();
			int col = sc.nextInt();
			int block = sc.nextInt();

			long up = fact[row+col-2];
			long down = (fact[row-1] * fact[col-1]) % MOD;
			long div = (fact[row-1] * fact[col-1]) / MOD;

			long totalCount = (up + MOD * div) / down;			


			System.out.println("First : " + up + " , " + down + " " + totalCount);

			List<Point2> list = new ArrayList<>();

			for(int i=0 ; i<block ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				if(x>=1 && y>=1 && x <= row && y<= col)
					list.add(new Point2(x-1, y-1));
				else { //장애물 체스판 바깥에 존재
					continue;
				}
			}

			Collections.sort(list);

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer % MOD);
		}
		sc.close();
	}

	public static long getVal(int x, int y, int xSize, int ySize) {
		long distOne = (fact[x+y]) / ( (fact[x]*fact[y]) % MOD ) ;
		long distTwo = (fact[xSize+ySize-(x+y)]) / ( (fact[xSize-x]*fact[ySize-y]) % MOD ) ;

		//System.out.println("getVal : " + fact[x+y] + " , " + fact[x] + " , " + fact[y]);
		//System.out.println("getVal : " + fact[xSize+ySize-(x+y)] + " , " + (fact[xSize-x]*fact[ySize-y]));
		System.out.println("getVal : " + distOne + " , " + distTwo + " , " + ( (distOne * distTwo) % MOD ) );

		return distOne * distTwo;
	}

	public static long getVal2(int x, int y) {
		long distOne = (fact[x+y] % MOD) / ( ( ( (fact[x] % MOD) * (fact[y] % MOD) ) % MOD ) );

		//System.out.println("getVal 2 : " + fact[x+y] + " , " + (fact[x] % MOD) * (fact[y] % MOD));

		return distOne;
	}
}

class Point2 implements Comparable<Point2>{
	int x;
	int y;

	public Point2(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point2 o) {
		if(this.x > o.x){
			return 1;
		}else if(this.x == o.x && this.y > o.y){
			return 1;
		}
		return -1;
	}

}

