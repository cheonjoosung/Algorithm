package samsung.sw_expert.d3;

import java.util.Scanner;

//민석이의 과제 체크하기
public class P5431 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			
			String ans = "";
			
			int [] arr = new int[n+1];
			for(int i=0 ; i<c ; i++)
				arr[sc.nextInt()] = 1;
			
			for(int i=1 ; i<=n ; i++)
				if(arr[i] == 0) ans += " " + i;
			
			System.out.println("#" + t + ans);
		}

		sc.close();
	}
}