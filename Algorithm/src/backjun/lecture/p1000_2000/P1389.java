package backjun.lecture.p1000_2000;

import java.util.Arrays;
import java.util.Scanner;

public class P1389 {
	static int [][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int count = sc.nextInt();

		arr = new int[size+1][size+1];
		for(int [] temp : arr)
			Arrays.fill(temp, 999_999_999);

		for(int i=0 ; i<count ; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			arr[s][e] = 1;
			arr[e][s] = 1;
		}

		for(int i=1 ; i<=size ; i++) 
			for(int j=1; j<=size ; j++) 
				for(int k=1 ; k<= size ; k++) {
					if(arr[j][i] + arr[i][k] < arr[j][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}

		int min = 999_999_999, minIndex = -1;
		for(int i=1; i<= size ; i++) {
			int sum = 0;
			for(int j=1; j <= size ; j++) {
				sum += arr[i][j];
			}
			if(sum < min) {
				min = sum;
				minIndex = i;
			}
		}
		
		System.out.println(minIndex);


		sc.close();
	}
}
