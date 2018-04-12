package SS;

import java.util.Scanner;

public class Main {
	static int n;
	static int [] arr;
	static int [] op; // 0 plus, 1 minus, 2 mul, 3 div
	static boolean [] visited;

	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[]{7, 2, 3, 6, 5, 4, 1};
		
		int a = -1;
		int b = -1;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] < arr[i]) {
				a = i;
			}
		}
		
		for(int j= arr.length-1 ; j>=a ; j--) {
			if(arr[j] > arr[a-1]) {
				b = Math.max(b, j);
			}
		}
		
		int temp = arr[b];
		arr[b] = arr[a-1];
		arr[a-1] = temp;
		
		for(int val : arr) System.out.print(val + " ");
		
		
		
		sc.close();
	}
}
