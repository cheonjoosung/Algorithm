package samsung.sw_expert.d3;

import java.util.Arrays;
import java.util.Scanner;

//최대 성적표 만들기
public class P4466 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int [] arr = new int[n];
			
			for(int i=0 ; i<n ; i++)
				arr[i] = sc.nextInt();
			
			int ans =0;
			Arrays.sort(arr);
			int idx = arr.length-1;
			
			for(int i=0 ; i<k ; i++)
				ans += arr[idx--];
						
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
}