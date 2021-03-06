package codeground;

import java.util.Scanner;

//CodeGround 3번 시험공부
public class Sol03 {
	static int Answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int numOfTest = sc.nextInt();
			int numOfChoice = sc.nextInt();
			
			int [] arr = new int[numOfTest];
			int [] res = new int[numOfTest];

			for(int i=0 ; i< numOfTest ; i++){
				arr[i] = sc.nextInt();
			}

			merge_sort(arr,res, 0, numOfTest-1);
			
			for(int i=arr.length-1 ; i >= 0 ; i--) {
				Answer += arr[i];
				if(--numOfChoice == 0) break;
			}

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}


	public static void merge_sort (int[] arr, int[] res,int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			merge_sort(arr, res, left, mid);
			merge_sort(arr, res, mid+1, right);
			merge(arr, res, left, mid+1, right);
		}
	}

	public static void merge (int[] arr, int[] res, int left, int mid, int right) {
		int temp_pos = 0;
		
		int l_end = mid-1;
		int l = left;
		int m = mid;
		int r = right;
		
		while(l <= l_end && m <= r) {
			if(arr[l] <= arr[m]) {
				res[temp_pos++] = arr[l++];
			} else {
				res[temp_pos++] = arr[m++];
			}
		}
	
		while(l <= l_end) {
			res[temp_pos++] = arr[l++]; 
		}
		
		while(m <= r) {
			res[temp_pos++] = arr[m++];
		}
		
		temp_pos = 0;
		for(int i= left ; i<= right ; i++){
			arr[i] = res[temp_pos++];
		}
		
	}

	
}
