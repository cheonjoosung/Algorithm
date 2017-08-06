package codeground;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
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
			int[][][] dist = new int[row + 1][col + 1][10 + 1]; // 지점을 이동할 때마다 물 필요
			// 수마다 최소 거리를 저장

			/*
			 * 주어진 인풋값을 배열에 할당
			 */
			for (int i = 0; i < (col + 1); i++) {
				for (int j = 0; j < (row + 1); j++) {
					arr[j][i] = sc.nextInt();
				}
			}

			// 초기화
			for (int[][] first : dist) {
				for (int[] second : first)
					Arrays.fill(second, 0);
			}

			/*
			 * [x][y][water수]=고도차의합최소를 이동하면서 구한다. 0,0 -> 1,0 -> 2,0 -> 3,0 물의
			 * 들어가는 수와 최소의 고도차의 합 1,0 -> 1,1 -> 2,1 -> 3,1 i,j 일때는 i-1, j or i,
			 * j-1 하여 각 계산한 값을 집어넣는다. 물론 0보다 작으면 안되고 row or col 사이즈보다 크지 않도록
			 * 설정한다.
			 */

			for (int i = 0; i < (col + 1); i++) {
				for (int j = 0; j < (row + 1); j++) {

					if (i == 0 && j == 0) continue;

					if (i < 1 && j >= 1) {
						int distance = getDistance(arr[j][i], arr[j-1][i]);

						if(j == 1) {

							if(minWater == 0) {
								dist[j][0][0] = distance;
							} else {
								if(isNagative(arr[j][i])) dist[j][0][1] = distance;
								else dist[j][0][0] = distance;
							}

						} else {

							for(int k = minWater ; k >= 0 ; k--){
								if( dist[j-1][i][k] == 0 ) continue;

								dist[j][i][k] = dist[j-1][i][k] + distance;

								if(isNagative(arr[j][i])) {
									if(k < minWater){
										dist[j][i][k+1] = dist[j][i][k];										
										dist[j][i][k] = 0;
									}
								}
							}

						}

					} else if (i >= 1 && j < 1) {

						int distance = getDistance(arr[j][i], arr[j][i-1]);

						if(i == 1) {

							if(minWater == 0) {
								dist[0][i][0] = distance;
							} else {
								if(isNagative(arr[j][i])) dist[0][i][1] = distance;
								else dist[0][i][0] = distance;
							}

						} else {

							for(int k=minWater ; k>=0 ; k--){

								if( dist[j][i-1][k] == 0 ) continue;

								dist[j][i][k] = dist[j][i-1][k] + distance;

								if(isNagative(arr[j][i])) {
									if(k < minWater){
										dist[j][i][k+1] = dist[j][i][k];
										dist[j][i][k] = 0;
									}         
								}

							}
						}

					} else {

						int leftDistance = getDistance(arr[j][i], arr[j-1][i]);
						int downDistance = getDistance(arr[j][i], arr[j][i-1]);

						for(int k = minWater ; k >= 0 ; k--){
							if( dist[j][i-1][k] == 0 && dist[j-1][i][k] == 0) continue;

							if( dist[j][i-1][k] == 0 && dist[j-1][i][k] != 0 ) {
								//왼쪽에서 오는 경우 

								if(isNagative(arr[j][i])) {
									if(k < minWater) {
										if(dist[j][i][k+1] == 0) {
											dist[j][i][k+1] = dist[j-1][i][k] + leftDistance;
										} else {
											dist[j][i][k+1] = Math.min(dist[j][i][k+1], dist[j-1][i][k] + leftDistance);
										}
									} else {
										if(dist[j][i][k] != 0) {
											dist[j][i][k] = Math.min(dist[j][i][k], dist[j-1][i][k] + leftDistance);												
										} else {
											dist[j][i][k] = dist[j-1][i][k] + leftDistance;
										}
									}
								} else {
									if(dist[j][i][k] != 0) {
										dist[j][i][k] = Math.min(dist[j][i][k], dist[j-1][i][k] + leftDistance);
									} else {
										dist[j][i][k] = dist[j-1][i][k] + leftDistance;
									}
								}

							} else if( dist[j][i-1][k] != 0 && dist[j-1][i][k] == 0 ) {
								//아래에서 오는 경우 

								if(isNagative(arr[j][i])) {
									if(k < minWater) {
										if(dist[j][i][k+1] == 0) {
											dist[j][i][k+1] = dist[j][i-1][k] + downDistance;
										} else {
											dist[j][i][k+1] = Math.min(dist[j][i][k+1], dist[j][i-1][k] + downDistance);
										}
									} else {
										if(dist[j][i][k] != 0) {
											dist[j][i][k] = Math.min(dist[j][i][k], dist[j][i-1][k] + downDistance);												
										} else {
											dist[j][i][k] = dist[j][i-1][k] + downDistance;
										}
									}
								} else {
									if(dist[j][i][k] != 0) {
										dist[j][i][k] = Math.min(dist[j][i][k], dist[j][i-1][k] + downDistance);
									} else {
										dist[j][i][k] = dist[j][i-1][k] + downDistance;
									}
								}

							} else {
								//왼쪽과 아래 중 작은걸로 저장해야 함

								if(isNagative(arr[j][i])) {
									if(k < minWater) {
										if(dist[j][i][k+1] == 0) {
											dist[j][i][k+1] = Math.min(dist[j][i-1][k] + downDistance, dist[j-1][i][k] + leftDistance);
										} else {
											int val = Math.min(dist[j][i-1][k] + downDistance, dist[j-1][i][k] + leftDistance);
											dist[j][i][k+1] = Math.min(dist[j][i][k+1], val);
										}
									} else {
										if(dist[j][i][k] != 0) {
											int val = Math.min(dist[j][i-1][k] + downDistance, dist[j-1][i][k] + leftDistance);
											dist[j][i][k] = Math.min(dist[j][i][k], val);												
										} else {
											dist[j][i][k] = Math.min(dist[j][i-1][k] + downDistance, dist[j-1][i][k] + leftDistance);
										}
									}
								} else {
									if(dist[j][i][k] != 0) {
										int val = Math.min(dist[j][i-1][k] + downDistance, dist[j-1][i][k] + leftDistance);
										dist[j][i][k] = Math.min(dist[j][i][k], val);
									} else {
										dist[j][i][k] = Math.min(dist[j][i-1][k] + downDistance, dist[j-1][i][k] + leftDistance);
									}
								}
							}
						}

					}

				}
			}

			Answer = dist[row][col][minWater];

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
