package codeground;

import java.util.Arrays;
import java.util.Scanner;

public class Sol47 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			long [][] arr = new long[n][n];
			long [][] res = new long[n][n];
			
			for(long [] k : res) {
				Arrays.fill(k, 0);
			}
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			res[0][0] = arr[0][0];
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(i==0 && j==0) continue;
					
					if(i != 0 && j == 0) {
						res[i][j] = res[i-1][j] * arr[i][j];
					} else if(i == 0 && j != 0) {
						res[i][j] = res[i][j-1] * arr[i][j];
					} else {
						long left = res[i-1][j] * arr[i][j];
						long down = res[i][j-1] * arr[i][j];
						
						if(left == down) {
							res[i][j] = left;
						} else {
							if(left % 6 == 0 && down % 6 == 0) {
								res[i][j] = Math.min(left, down);
							} else if(left % 6 == 0 && down % 6 != 0){
								res[i][j] = left;
							} else if(left % 6 != 0 && down % 6 == 0) {
								res[i][j] = down;
							} else {
								boolean isLeft = false;
								boolean isDown = false;
								
								if(left % 2 == 0 || left % 3 == 0) {
									isLeft = true;
								}
								
								if(down % 2 == 0 || down % 3 ==0) {
									isDown = true;
								}
								
								if(isLeft && !isDown) res[i][j] = left;
								else if(isDown && !isLeft) res[i][j] = down;
								else res[i][j] = Math.min(left, down);
							}
						}
					}
				}
			}
			
			long val = res[n-1][n-1];
			
			while(val > 6) {
				if(val % 6 == 0) Answer++;
				val = val / 6;
			}
			//System.out.println(res[n-1][n-1]);
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


}
