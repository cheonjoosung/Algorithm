package backjun.p10000_11000;

import java.util.Arrays;

public class P10973 {
	public static void main(String[] args) {
		int [] arr = {1, 2 , 3 };

		do{
			for(int k : arr)
				System.out.print(k + " ");
			System.out.println();
		} while(isNext(arr, arr.length));
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
