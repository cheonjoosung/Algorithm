package backjun.lecture.p10000_11000;

import java.util.Arrays;
import java.util.Scanner;

public class P10971 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [][] arr = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				arr[j][i] = sc.nextInt();
			}
		}
		sc.close();
	}
	
	public static boolean isNext(int [] arr, int n) {
		int index = -1;
		for(int i=1 ; i<n ; i++) {
			if(arr[i-1] < arr[i]) {
				index = Math.max(index, i);
			}
		}
		if(index <= 0) return false;

		int index2 = -1;
		for(int j=index ; j < n ; j++) {
			if(arr[index-1] < arr[j]) {
				index2 = Math.max(index2, j);
			}
		}
		
		int temp = arr[index-1];
		arr[index-1] = arr[index2];
		arr[index2] = temp;
		
		Arrays.sort(arr, index , n);
		
		return true;
	}
}
