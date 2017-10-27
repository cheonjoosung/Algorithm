package SS.sw_expert.d2;

import java.util.Arrays;
import java.util.Scanner;

//스도쿠 검증
public class P1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int [][] a = new int[9][9];

			for(int i=0 ; i<9 ; i++)
				for(int j=0; j<9 ; j++) 
					a[j][i] = sc.nextInt();

			if(isPossible(a)) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);

		}

		sc.close();
	}

	public static boolean isPossible(int [][] a) {
		boolean [] visited;

		for(int i=0; i<9 ; i++) {
			//가로줄 체크
			visited = new boolean[10];
			Arrays.fill(visited, false);
			for(int j=0 ; j<9 ; j++) {
				if(visited[a[j][i]]) return false;
				else visited[a[j][i]] = true;
			}

			//세로줄 체크
			visited = new boolean[10];
			Arrays.fill(visited, false);
			for(int j=0; j<9 ; j++) {
				if(visited[a[i][j]]) return false;
				else visited[a[i][j]] = true;
			}
		}


		for(int m=0 ; m<3 ; m++) {
			for(int k=0 ; k<3 ; k++){
				visited = new boolean[10];
				Arrays.fill(visited, false);
				for(int i=0; i<3 ; i++) {
					for(int j=0 ;j<3 ; j++) {
						if(visited[a[j+3*k][i+3*m]]) return false;
						else visited[a[j+3*k][i+3*m]] = true;
					}
				}
			}
		}

		return true;
	}
}
