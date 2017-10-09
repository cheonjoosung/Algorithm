package SS;

import java.util.Arrays;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int a = 2, b = 4;
		
		if( (a+b) / 2 == 3) {
			System.out.println("Good");
		}
		
		if( (a+b) >> 1 == 3) {
			System.out.println("Good");
		}
		
		if(a % 2 == 0) {
			System.out.println("HI");	
		}
		
		if( (a&1) == 0) {
			System.out.println("HI");
		}
		
		if( (570 & (2*2*2)) == 1) {
			System.out.println("3번째 비트 1");
		}
		
		if( (570 & (1<<3)) == 1) {
			System.out.println("3번째 비트 1");
		}
		
		if( (570 | (1<<0)) == 1) {
			
		}
		
		int [] arr = {1, 2 , 3 , 4};
		
		int index = -1;
		int max = -1;
		
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i-1] < arr[i]) {
				if(max < Math.abs(arr[i-1] - arr[i])) {
					max = Math.abs(arr[i-1] - arr[i]);
					index = i;
				}
			}
			/*if(arr[i-1] < arr[i]) {
				for(int j=i; j < arr.length ; j++) {
					if(arr[i-1] > arr[j]) {
						int temp = arr[j];
						arr[j] = arr[i-1];
						arr[i-1] = temp;
					}
				}
			}*/
		}
		
		System.out.println(index);
		
		index--;
		if(index <= 0) System.out.println("Last");
		
		for(int i = index ; i<arr.length ; i++) {
			if(arr[index] > arr[i]) {
				int temp = arr[i-1];
				arr[i-1] = arr[index];
				arr[index] = temp;
			}
		}
		
		Arrays.sort(arr, index+1, arr.length);
	
		for(int k : arr)
			System.out.print(k + " ");
	}
}