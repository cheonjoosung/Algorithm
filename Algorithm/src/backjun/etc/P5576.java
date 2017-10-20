package backjun.etc;

import java.util.Arrays;
import java.util.Scanner;

public class P5576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[10];
		int [] arr2 = new int[10];
		
		for(int i=0 ; i<10 ; i++) arr[i] = sc.nextInt();
		for(int i=0 ; i<10 ; i++) arr2[i] = sc.nextInt();
		
		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		System.out.println((arr[9]+arr[8]+arr[7] + " " + (arr2[9]+arr2[8]+arr2[7])));
		
		sc.close();
	}
}
