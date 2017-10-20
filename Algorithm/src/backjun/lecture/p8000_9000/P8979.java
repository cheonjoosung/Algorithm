package backjun.lecture.p8000_9000;

import java.util.Scanner;

public class P8979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int [][] arr = new int[n][3];

		for(int i=0 ; i<n ; i++) {
			int num = sc.nextInt();

			arr[num-1][0] = sc.nextInt();
			arr[num-1][1] = sc.nextInt();
			arr[num-1][2] = sc.nextInt();
		}

		k--;

		int cnt = 0;

		for(int i=0 ; i<n ; i++) {
			if(arr[i][0] > arr[k][0]) {
				cnt++;
				continue;
			} else if(arr[i][0] == arr[k][0]) {
				if(arr[i][1] > arr[k][1]) {
					cnt++;
					continue;
				} else if(arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) {
					cnt++;
					continue;
				}
			}
		}

		System.out.println(cnt+1);

		sc.close();
	}
}
