package samsung.sw_expert.d3;

import java.util.Scanner;

//5789번 현주의 상자 바꾸
public class P5789 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			
			int [] arr = new int[n];
			
			for(int i=1 ; i<=q ; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				
				for(int idx=l ; idx<=r ; idx++)
					arr[idx-1] = i;
			}
			System.out.print("#" + t);
			for(int i=0 ; i<n ; i++)
				System.out.print(" " + arr[i]);
			System.out.println();
		}

		sc.close();
	}
}