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

			long totalCount = ( fact[row+col-2] / (fact[row-1] * fact[col-1]) ) % MOD ;

			List<Point> list = new ArrayList<>();

			for(int i=0 ; i<block ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				if(x>=1 && y>=1 && x <= row && y<= col)
					list.add(new Point(x-1, y-1));
				else { //장애물 체스판 바깥에 존재
					continue;
				}
			}

			Collections.sort(list);
			
			long sum = getVal(list.get(0).x, list.get(0).y, (row-1), (col-1));
			
			for(int i = 1 ; i < list.size() ; i++) {
				for(int j = 0 ; j < i ; j++) {
					// 0 부터 i 번째까지 중복이 있나 체크
					if(list.get(i).x >= list.get(j).x 
							&& list.get(i).y >= list.get(j).y) {
						//중복되므로 제거 필요
					} else {
						//중복이 되지 않으므로 따로 계산
					}
				}
			}
			
			for(Point c : list) {
				System.out.println(c.x + " , " + c.y);
			}

			Answer = totalCount - 0;

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer % MOD);
		}
		sc.close();
	}
	
	public static long getVal(int x, int y, int xSize, int ySize) {
		long distOne = fact[x+y] / (fact[x]*fact[y]);
		long distTwo = fact[xSize+ySize-(x+y)] / (fact[xSize-x]*fact[ySize-y]);
		
		return distOne * distTwo;
	}
}

class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x > o.x){
			return 1;
		}else if(this.x == o.x && this.y > o.y){
			return 1;
		}
		return -1;
	}
	
}
