package samsung.sw_expert.d3;

import java.util.Scanner;

//5603번 [Professional] 건초더미
public class P5603 {
	static int ans, n;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			
			ans = 0;
			int sum = 0;
			int avg = 0;
			arr = new int[n];
			
			for(int i=0 ; i<n ; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			avg = sum/n;
			
			for(int i=0 ; i<n ; i++) {
				if(arr[i] > avg) {
					ans += (arr[i] - avg);
				}
			}			
			
			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}
}