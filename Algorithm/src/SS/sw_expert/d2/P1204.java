package SS.sw_expert.d2;

import java.util.Scanner;

//최빈수 구하기
public class P1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();
			int maxVal = -1;
			int maxIdx = -1;
			
			int [] arr = new int[101];
			
			for(int i=0 ; i<1000 ; i++) {
				int idx = sc.nextInt();
				arr[idx]++;
			}
			
			for(int i=0 ; i<=100 ; i++) {
				if(arr[i] >= maxVal) {
					maxVal = arr[i];
					maxIdx = i;
				}
			}
				
			
			System.out.println("#" + t + " " + maxIdx);
		}
		
		sc.close();
	}
}
