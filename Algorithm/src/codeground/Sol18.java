package codeground;
import java.util.Scanner;
import java.util.Arrays;

// 18번 마라톤 경로
class Sol18 {
	static int Answer;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int row = sc.nextInt();
			int col = sc.nextInt();
			int minWater = sc.nextInt();

			int[][] arr = new int[row + 1][col + 1];
			int[][][] dist = new int[row + 1][col + 1][10 + 1]; // 지점을 이동할 때마다 물 필요+거리

			for (int i = 0; i < (col + 1); i++) 
				for (int j = 0; j < (row + 1); j++) 
					arr[j][i] = sc.nextInt();

			// 초기화
			for (int[][] first : dist) 
				for (int[] second : first)
					Arrays.fill(second, -1 );

			/*
			 * [x][y][water수]=고도차의합최소를 이동하면서 구한다. 0,0 -> 1,0 -> 2,0 -> 3,0 물의
			 * 들어가는 수와 최소의 고도차의 합 1,0 -> 1,1 -> 2,1 -> 3,1 i,j 일때는 i-1, j or i,
			 * j-1 하여 각 계산한 값을 집어넣는다. 물론 0보다 작으면 안되고 row or col 사이즈보다 크지 않도록
			 * 설정한다.
			 */

			dist[0][0][0] = 0;

			for (int i = 0; i < (col + 1); i++) {
				for (int j = 0; j < (row + 1); j++) {
					if(i==0 && j==0) continue;

					int left = -1;
					int down = -1;

					if(j >= 1) {
						left = getDistance(arr[j][i], arr[j-1][i]);
					}

					if(i >= 1) {
						down = getDistance(arr[j][i], arr[j][i-1]);
					}

					if(left != -1 && down == -1) { // j=0 일때
						for(int k=10; k>=0 ; k--) {
							if(dist[j-1][i][k] == -1) continue;

							if( isNagative(arr[j][i]) ) {
								if(k != 10) {
									dist[j][i][k+1] = dist[j-1][i][k] + left;
								} else {
									dist[j][i][k] = dist[j-1][i][k] + left;
								}
							} else {
								dist[j][i][k] = dist[j-1][i][k] + left;
							}
						}
					} else if(left == -1 && down != -1) { // i=0 일때
						for(int k=10; k>=0 ; k--) {
							if(dist[j][i-1][k] == -1) continue;

							if( isNagative(arr[j][i]) ) {
								if(k != 10) {
									dist[j][i][k+1] = dist[j][i-1][k] + down;
								} else {
									dist[j][i][k] = dist[j][i-1][k] + down;
								}
							} else {
								dist[j][i][k] = dist[j][i-1][k] + down;
							}
						}
					} else { // j >= 1 && j >= 1일 때 
						for(int k=10; k>=0 ; k--) {
							if(dist[j-1][i][k] == -1 && dist[j][i-1][k] == -1) continue;

							if(dist[j-1][i][k] != -1 && dist[j][i-1][k] == -1) { // 왼쪽으로만 오는 길만 존재
								if( isNagative(arr[j][i]) ) {
									if(k != 10) {
										if(dist[j][i][k+1] == -1) {
											dist[j][i][k+1] = dist[j-1][i][k] + left;
										} else {
											dist[j][i][k+1] = Math.min(dist[j][i][k+1], dist[j-1][i][k] + left);
										}
									} else {
										if(dist[j][i][k] == -1) {
											dist[j][i][k] = dist[j-1][i][k] + left;
										} else {
											dist[j][i][k] = Math.min(dist[j][i][k], dist[j-1][i][k] + left);
										}
									}
								} else {
									if(dist[j][i][k] == -1) {
										dist[j][i][k] = dist[j-1][i][k] + left;
									} else {
										dist[j][i][k] = Math.min(dist[j][i][k], dist[j-1][i][k] + left);
									}
								}
							} else if(dist[j-1][i][k] == -1 && dist[j][i-1][k] != -1) { // 아래로 오는 길만 존재
								if( isNagative(arr[j][i]) ) {
									if(k != 10) {
										if(dist[j][i][k+1] == -1) {
											dist[j][i][k+1] = dist[j][i-1][k] + down;
										} else {
											dist[j][i][k+1] = Math.min(dist[j][i][k+1], dist[j][i-1][k] + down);
										}
									} else {
										if(dist[j][i][k] == -1) {
											dist[j][i][k] = dist[j][i-1][k] + down;
										} else {
											dist[j][i][k] = Math.min(dist[j][i][k], dist[j][i-1][k] + down);
										}
									}
								} else {
									if(dist[j][i][k] == -1) {
										dist[j][i][k] = dist[j][i-1][k] + down;
									} else {
										dist[j][i][k] = Math.min(dist[j][i][k], dist[j][i-1][k] + down);
									}
								}
							} else { // 양쪽으로 오는 길이 존재
								if( isNagative(arr[j][i]) ) {
									if(k != 10) {
										if(dist[j][i][k+1] == -1) {
											dist[j][i][k+1] = Math.min(dist[j-1][i][k] + left, dist[j][i-1][k] + down);
										} else {
											int val = Math.min(dist[j-1][i][k] + left, dist[j][i-1][k] + down);
											dist[j][i][k+1] = Math.min(dist[j][i][k+1], val);
										}
									} else {
										if(dist[j][i][k] == -1) {
											dist[j][i][k] = Math.min(dist[j-1][i][k] + left, dist[j][i-1][k] + down);
										} else {
											int val = Math.min(dist[j-1][i][k] + left, dist[j][i-1][k] + down);
											dist[j][i][k] = Math.min(dist[j][i][k], val);
										}
									}
								} else {
									if(dist[j][i][k] == -1) {
										dist[j][i][k] = Math.min(dist[j-1][i][k] + left, dist[j][i-1][k] + down);
									} else {
										int val = Math.min(dist[j-1][i][k] + left, dist[j][i-1][k] + down);
										dist[j][i][k] = Math.min(dist[j][i][k], val);
									}
								}
							}
						}
					}
				}
			}

			for(int k=minWater ; k <= 10 ; k++) {
				if(dist[row][col][k] == -1) continue;
				
				if(Answer == 0) {
					Answer = dist[row][col][k];
					continue;
				}
				
				Answer = Math.min(Answer, dist[row][col][k]);
			}

			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}

	public static int getDistance(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);

		if (a > b) {
			return (a - b);
		} else {	
			return (b - a);
		}
	}

	public static boolean isNagative(int a) {
		if(a < 0) return true;
		else return false;
	}
}