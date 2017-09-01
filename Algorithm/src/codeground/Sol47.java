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
			
			for(int j=0 ; j<n ; j++) {
				for(int i=0 ; i<n ; i++) {
					if(i == 0 && j == 0) {
						int two = val[0][0][0];
						int three = val[0][0][1];
						
						res[i][j][three] = two;
						
						System.out.print(i + " , " + j + "  -- >>  " + res[i][j][three]+"\n");
					} else if(i != 0 && j == 0) {
						
						for(int k = 6; k >=0 ; k--) {
							if(res[i-1][j][k] == -1) continue;
							else {
								int three = val[i][j][1];
								int two = val[i][j][0];
								
								System.out.print(i + " , " + j + " , " + k + " , two : " + two + " , three : " + three);
								
								if(k + three <= 6) {
									res[i][j][k+three] = two + res[i-1][j][k];
								} else {
									res[i][j][6] = two + res[i-1][j][k];
								}
							}
						}
						System.out.println();
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
							System.out.print(i + " , " + j + "  -- >>  " + res[i][j][k]);
						}
						System.out.println();
					} else {
						
					}
				}
			}

			Answer = Math.min(res[n-1][n-1][0], res[n-1][n-1][1]);

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);	
		}
	}

	public static void check(int [][][] val, int x, int y, int temp) {
		
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
