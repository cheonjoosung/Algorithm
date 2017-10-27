package SS.sw_expert.d3;

import java.util.Arrays;
import java.util.Scanner;

//Flatten
public class P1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		for(int t=1 ; t<=10 ; t++) {
			int count = sc.nextInt();
			int [] arr = new int[100];
			for(int i=0; i<100 ; i++) arr[i] = sc.nextInt();

			Arrays.sort(arr);
			
			for(int i=0 ; i < count ; i++) {
				arr[99] = arr[99] -1;
				arr[0] = arr[0] + 1;
				Arrays.sort(arr);
			}
			
			System.out.println("#"+t+ " " + (arr[99] - arr[0]));
		}
		
		sc.close();
	}
}