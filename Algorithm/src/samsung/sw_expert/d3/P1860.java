package samsung.sw_expert.d3;

import java.util.Arrays;
import java.util.Scanner;

public class P1860 {
	static int ans, n;
	static int [] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			int people = sc.nextInt();
			int fishTime = sc.nextInt();
			int fishCount = sc.nextInt();
	
			arr = new int[11112];
			Arrays.fill(arr, 0);
			for(int i=0 ; i<people ; i++) {
				int val = sc.nextInt();
				arr[val]++; 
			}
			
			int time = 0;
			int nowFish = 0;
			boolean ok = true;
			
			while(true) {
				if(time >= 11111) break;
				if(time !=0 && time % fishTime == 0) nowFish += fishCount;
				
				nowFish -= arr[time];
				
				if(nowFish < 0) {
					ok = false;
					break;
				}
				time++;
			}
			
			if(ok) System.out.println("#" + tc + " Possible");
			else System.out.println("#" + tc + " Impossible");
		}

		sc.close();
	}
}

