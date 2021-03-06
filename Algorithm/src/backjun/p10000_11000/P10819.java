package backjun.p10000_11000;

import java.util.Arrays;
import java.util.Scanner;

public class P10819 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		int ans = 0;
		
		for(int i=0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		do {
			int temp = calculate(arr);
			ans = Math.max(ans, temp);
		} while(isNext(arr, arr.length));
		
		System.out.println(ans);
		
		sc.close();
	}
	
	public static int calculate(int [] arr) {
		int sum = 0;
		
		for(int i=1; i<arr.length ; i++) {
			sum += Math.abs((arr[i] - arr[i-1]));
		}
		
		return sum;
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
