package backjun.lecture.p2000_3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[9];
		int [] arr2 = new int[9];
		for(int i=1 ; i<9 ; i++) {
			int val = sc.nextInt();
			arr[i] = val;
			arr2[i] = val;
		}
		
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		
		int sum = 0;
		for(int i=8 ; i>=4 ; i--) sum += arr[i];
		for(int i=4 ; i<=8 ; i++) {
			int val = arr[i];
			for(int j=1 ; j<9 ; j++) {
				if(val == arr2[j])
					list.add(j);
			}
		}
		Collections.sort(list);
		System.out.println(sum);
		for(int temp : list) System.out.print(temp + " ");
		System.out.println();
		
		sc.close();
	}
}
