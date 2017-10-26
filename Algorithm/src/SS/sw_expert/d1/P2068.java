package SS.sw_expert.d1;

import java.util.Arrays;
import java.util.Scanner;

//중간값 찾기
public class P2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int t=1; t<=n ; t++) {
			int arr [] = new int[10];
			for(int i=0; i<10 ; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr);
			System.out.println("#"+t+" " + arr[9]);
		}

		sc.close();
	}
}
