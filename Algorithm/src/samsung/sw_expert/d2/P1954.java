package samsung.sw_expert.d2;

import java.util.Arrays;
import java.util.Scanner;

//달팽이 숫자
public class P1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();

			int [][] arr = new int[n][n];

			for(int [] temp : arr) Arrays.fill(temp, 0);

			fillMap(arr, n);

			System.out.println("#" + t);
			for(int j=0 ; j<n ; j++) {
				for(int i=0 ; i<n ; i++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}		
		}

		sc.close();
	}

	public static void fillMap(int [][] map, int size) {
		int val = 1;
		int dir = 1;
		int x = 0, y =0;
		
		while( val != size*size) {				
			if(dir == 1) {
				if(x == size-1) dir = 2;
				else {
					if(map[x+1][y] != 0) dir = 2;
					else map[x++][y] = val++;
				}
			} else if(dir == 2) {
				if(y >= size-1) dir = 3;
				else {
					if(map[x][y+1] != 0) dir = 3;
					else map[x][y++] = val++;
				}
			} else if(dir == 3) {
				if(x <= 0) dir = 4;
				else {
					if(map[x-1][y] != 0) dir = 4;
					else map[x--][y] = val++;
				}
			} else if(dir == 4) {
				if(y <= 0) dir = 1;
				else {
					if(map[x][y-1] != 0) dir =1;
					else map[x][y--] = val++;
				}
			}
		}
		
		map[x][y] = val;
	}
}
