package codeground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sol10 {
	static long Answer;
	static int MOD = 1_000_000_007;
	
	static long[] fact = new long[2000005];
	static long[] reverseFact = new long[2000005];

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		fact[0] = 1;
		reverseFact[0] = 1;

		for(int i = 1; i < 200001; i++)
			fact[i] = i * fact[i-1] % MOD;

		/*
		 * 페르마 소정리에 따르면 a^(p-1) = 1 ( MOD p )
		 * a * a^(p-2) = 1 ( MOD p ) 이므로 a 의 MOD p 연산에 대한 역원은 a^(p-2) 
		 * 그러므로 역원을 구한다.
		 * ex) reverse 는 (i)! 의 역원, reverse = 1 / (i) ! 과 동일 분모분자에 (i)! 의 역원을 곱 
		 */
		long reverse = getPow(fact[200000], MOD-2);

		for(int i = 200000 ; i > 0 ; i--) {
			reverseFact[i] = reverse;
			reverse = (reverse * i) % MOD;
		}
		
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int row = sc.nextInt();
			int col = sc.nextInt();
			int block = sc.nextInt();

			/*
			 * nCr = n! / (n-r)! * r!= n! * (n-r)!의 역원 * (r!) 의 역원 과 같다. 
			 */
			long up = fact[row+col-2];
			long down = (reverseFact[row-1] * reverseFact[col-1] ) % MOD;
			long totalCount = (up * down) % MOD;	

			List<Point> list = new ArrayList<>();
			List<Long> dupList = new ArrayList<>();

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
					
			for(int i = 0 ; i < list.size() ; i++) {
				long dist = getVal2(list.get(i).x, list.get(i).y);
				long temp = 0;
				
				for(int j = 0 ; j < i ; j++) {
					if(list.get(i).x >= list.get(j).x 
							&& list.get(i).y >= list.get(j).y) {
						
						System.out.println("AAAA : " + i + " , " + j);
						long pointDist = getVal2(list.get(i).x - list.get(j).x, list.get(i).y - list.get(j).y);
						long smallDist = dupList.get(j);
						
						temp = ( temp + ( (pointDist * smallDist) % MOD ) )  % MOD;
						
					} else {
						continue;
					}
				}
				
				dist = dist - temp;
				dupList.add(dist);
			}
			
			long sum = 0;
			
			for(int i=0; i< dupList.size() ; i++) {
				int x = (row-1) - list.get(i).x;
				int y = (col-1) - list.get(i).y;
			
				long temp2 = getVal2(x, y);
				
				System.out.println(i + " , " + dupList.get(i) + " , temp : " + temp2);
				
				sum = (sum + ( (dupList.get(i) * temp2) % MOD ) ) % MOD;
			}
			
			System.out.println(totalCount + " , " + sum);
			Answer = (totalCount - sum); 
			/*
			 * 음수의 경우 고민 필요한 로직
			 */
			Answer = (MOD + Answer) % MOD;

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
		sc.close();
	}

	public static long getVal2(int x, int y) {
		long distOne = (fact[x+y] *  ( (reverseFact[x] * reverseFact[y]) % MOD ) ) % MOD;
		
		return distOne;
	}

	public static long getPow(long val, long p) {
		if(p == 0) return 1;
		if(p == 1) return val;

		long half = getPow(val, p/2);

		if(p % 2 == 0) {
			return (half * half) % MOD;
		} else {
			return ( ( (half * half ) % MOD ) * val ) % MOD;
		}
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
