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

			int [][][] val = new int[n][n][2];
			int [][][] res = new int[n][n][7];

			for(int [][] k : res) {
				for(int [] m : k)
					Arrays.fill(m, -1);
			}

			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					int temp = sc.nextInt();
					check(val, i, j, temp);
				}
			}			
			
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					if(i == 0 && j == 0) {
						int two = val[0][0][0];
						int three = val[0][0][1];
						
						res[i][j][three] = two;
					} else if(i != 0 && j == 0) {
						for(int k = 6; k >=0 ; k--) {
							if(res[i-1][j][k] == -1) continue;
							else {
								int three = val[i][j][1];
								int two = val[i][j][0];
								
								if(k + three <= 6) {
									res[i][j][k+three] = two + res[i-1][j][k];
								} else {
									res[i][j][6] = two + res[i-1][j][k];
								}
							}
						}
					} else if(i == 0 && j != 0) {
						for(int k = 6; k >=0 ; k--) {
							if(res[i][j-1][k] == -1) continue;
							else {
								int three = val[i][j][1];
								int two = val[i][j][0];
								
								if(k + three <= 6) {
									res[i][j][k+three] = two + res[i][j-1][k];
								} else {
									res[i][j][6] = two + res[i][j-1][k];
								}
							}
						}
					} else {
						
					}
				}
			}

			Answer = Math.min(res[n-1][n-1][0], res[n-1][n-1][1]);

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);	
			
			/*
			 * 3 
			 * 5 3 1
			 * 18 6 6
			 * 5 12 5
			 * 왼쪽은 3의 갯수 표시, 오른쪽은 3이 최대일 때의 2 표시
			 * 0 1 0   0 0 0
			 * 2 1 1   1 1 1
			 * 0 1 1   0 2 0
			 */
		}
	}

	public static void check(int [][][] val, int temp, int x, int y) {
		
		while(temp != 0 && (temp%3 == 0) ) {
			val[x][y][1]++;
			temp = temp/3;
		}
		while(temp != 0 && (temp%2 == 0) ) {
			val[x][y][0]++;
			temp = temp/2;
		}

		//System.out.println(x + " " + y + "  ->  " + res[x][y][0] + " , " + res[x][y][1]  + " , ");
	}

}
