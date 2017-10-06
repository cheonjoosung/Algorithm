package kakao;

import java.util.ArrayList;
import java.util.Collections;

public class Medium2 {
	public static int expressions(int num) {
		int answer = 0;

		for(int i=1 ; i<num ; i++) {
			int sum = 0;
			for(int j=i ; j<num ; j++) {
				sum += j;
				if(sum == num) {
					answer++;
				}
				else if(sum > num) break;
			}
		}

		return answer+1;
	}

	public static int[] bestSet(int n, int s){
		if(n > s) {
			int[] answer = new int[1];
			answer[0] = -1;
			return answer;
		} else {
			int[] answer = new int[n];

			int avg = s / n;
			int div = s - avg*n;

			for(int i=0; i<n ; i++) {
				if(i >= (n-div)) {
					answer[i] = avg+1;
				} else {
					answer[i] = avg;        			
				}
			}

			return answer;
		}
	}

	public static int chooseCity(int n, int [][]city) {
		int minIndex = Integer.MAX_VALUE;
		long minSum = Long.MAX_VALUE;

		ArrayList<M> list = new ArrayList<>();

		for(int [] m : city) {
			list.add(new M(m[0], m[1]));
		}

		Collections.sort(list);

		for(M m : list)
			System.out.println(m.lo + " " + m.p);


		/*
        for(int i=0 ; i<n ; i++) {
        	long temp = 0;
        	for(int j=0; j<n ; j++) {
        		if(city[i][0] == city[j][0]) continue;
        		else {
        			temp += Math.abs((j-i)) * city[j][1];
        			if(temp > minSum) break;
        		}
        	}

        	if(minSum >= temp) {
        		minSum = temp;
        		minIndex = Math.min(minIndex, city[i][0]);
        	}
        }
		 */

		return minIndex;
	}

	public static int hopscotch(int[][] board, int size) {
		int result = 0;
		// 함수를 완성하세요.

		int [][] dp = new int[size][4];

		dp[0][0] = board[0][0];
		dp[0][1] = board[0][1];
		dp[0][2] = board[0][2];
		dp[0][3] = board[0][3];

		for(int i=1 ; i< size ; i++) {
			dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]) + board[i][0];
			dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]) + board[i][1];
			dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]) + board[i][2];
			dp[i][3] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + board[i][3];
		}

		result = Math.max(Math.max(dp[size-1][0], dp[size-1][1]) , Math.max(dp[size-1][2], dp[size-1][3]));

		return result;
	}

	public static int findLargestSquare(char [][]board) {
		int answer = 0;
		int [][] dp = new int[board.length+1][board[0].length+1];


		for(int i=1; i<dp.length ; i++) {
			for(int j=1; j<dp[0].length ; j++){
				if(board[i-1][j-1] == 'O')
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]) ) + 1;
				
				if(dp[i][j] > answer) 
					answer = dp[i][j];
			}
		}

		return answer*answer;
	}

	public static void main(String[] args) {
		System.out.println(expressions(15));
		System.out.println(bestSet(3, 13));
		System.out.println(chooseCity(3, new int[][]{{2,2},{1,5},{3,3}}));
		int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(hopscotch(test, 3));
		char [][]board ={
				{'X','O','O','O','X'},
				{'X','O','O','O','O'},
				{'X','X','O','O','O'},
				{'X','X','O','O','O'},
				{'X','X','X','X','X'}};
		System.out.println(findLargestSquare(board));
	}
}

class M implements Comparable<M> {
	int lo;
	int p;

	M(int lo, int p) {
		this.lo = lo;
		this.p = p;
	}

	@Override
	public int compareTo(M o) {
		// TODO Auto-generated method stub
		return this.lo - o.lo;
	}
}