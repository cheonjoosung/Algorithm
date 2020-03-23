package samsung.sw_expert.d2;

import java.util.Arrays;
import java.util.Scanner;

//아름이의 돌 던지기
public class P1285 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			int people = sc.nextInt();
			int [] arr = new int[people];
			
			for(int i=0 ; i<people ; i++) arr[i] = Math.abs(sc.nextInt());
			
			Arrays.sort(arr);
			
			int min = arr[0];
			int count = 1;
			
			for(int i=1; i<people ; i++) {
				if(min == arr[i]) count++;
			}
			
			System.out.println("#" + t + " " + arr[0] + " " + count);
		}
		
		sc.close();
	}
}
