package SS.sw_expert.d3;

import java.util.Scanner;

public class P2806 {
	static int [] path;
	static int n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int i=1 ; i<=tc ; i++) {

			ans = 0;
			n = sc.nextInt();

			for(int j=1 ; j<=n ; j++) {
				path = new int[n+1];
				path[1] = j;
				// 정점을 행을 기준, i=1 1행, i=2 2행
				nQeen(1);
			}


			System.out.println("#" + i + " " + ans);
		}

		sc.close();
	}

	public static void nQeen(int row) {
		if(row == n) {
			ans++;
		} else {
			for(int i=1 ; i<= n ; i++) {
				path[row + 1] = i;
				if(isPossible(row+1)) {
					nQeen(row+1);
				} else {
					path[row+1] = 0;
				}
			}
		}
		
		path[row] = 0;
	}
	
	public static boolean isPossible(int c) {
		for(int i=1 ; i<c ; i++) {
			//같은행 같은열
			if(path[i] == path[c]) {
				return false;
			}
			
			//대각선 
			if(Math.abs(path[i] - path[c]) == Math.abs(i-c)) {
				return false;
			}
		}
		
		return true;
	}
}
