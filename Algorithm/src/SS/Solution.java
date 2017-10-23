package SS;

import java.util.Scanner;

public class Solution {
	static int Max;
	static int Min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [] arr = new int[n];
		int [] cal = new int[4];

		Max = Integer.MIN_VALUE;
		Min = Integer.MAX_VALUE;

		for(int i=0; i<4 ; i++) cal[i] = sc.nextInt();
		for(int i=0; i<n ; i++) arr[i] = sc.nextInt();



		System.out.println(Max - Min);

		perm(cal, 0, n-1, 4);
		sc.close();
	}

	public static void perm(int[] arr, int depth, int n, int k) { 
		if (depth == k) {
			// 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함. 
			print(arr,k); 
			return; 
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth); 
			perm(arr, depth + 1, n, k); 
			swap(arr, i, depth); 
		} 
	}
	// 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

	public static void swap(int[] arr, int i, int j) { 
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	}
	
	public static void print(int [] arr , int k) {
		for(int val : arr) System.out.println(val);
	}
}