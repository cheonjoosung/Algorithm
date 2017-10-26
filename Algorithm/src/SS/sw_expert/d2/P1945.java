package SS.sw_expert.d2;

import java.util.Arrays;
import java.util.Scanner;

//간단한 소인수분해 
public class P1945 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();
			int [] arr = new int[12];
			Arrays.fill(arr, 0);
			
			for(int i=2 ; i<=11 ; i++) {
				while(n % i != 0) {
					arr[i]++;
					n /= i;
				}
			}

			System.out.println("#" + t + " " + arr[2] + " " + arr[3] +
					" " + arr[5] + " " + arr[7] + " " + arr[11]);

		}

		sc.close();
	}
}
