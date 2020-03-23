package samsung.last;

import java.util.HashMap;
import java.util.Scanner;

public class ArrayANDOperator_17140 {
	static int r,c,k,ans, row, col;
	static int [][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;
		k = sc.nextInt();

		/*
		 * R연산 : 모든 행에 대해서 정렬을 수행 행의 수 >= 열의 수
		 * C연산 : 모든 열에 대해서 정렬을 수행 행의 수 <  열의 수
		 */

		ans = -1;
		row = 3; col = 3;
		map = new int[100][100];


		for(int i=0 ; i<3 ; i++)
			for(int j=0 ; j<3 ; j++)
				map[i][j] = sc.nextInt();		

		for(int idx=0 ; idx<=100 ; idx++) {
			if(map[r][c] == k) {
				ans = idx;
				break;
			}

			if(row >= col) {
				for(int i=0 ; i<row ; i++) {
					HashMap<Integer, Integer> hm = new HashMap<>();

					for(int j=0 ; j<col ; j++) {
						if(map[i][j] == 0) break;

						int key = map[i][j];

						if(hm.containsKey(key)) {
							int val = hm.get(key);
							hm.replace(key, val+1);
						} else {
							hm.put(key, 1);
						}
					}

				}


			} else {
				for(int j=0 ; j<col ; j++) {
					for(int i=0 ; i<row ; i++) {

					}
				}
			}
		}

		System.out.println(ans);

		sc.close();
	}
}

class Val {
	int val, cnt;
	Val(int val, int cnt) {
		this.val = val; this.cnt = cnt;
	}
}
