package SS.sw_expert.d3;

import java.util.Scanner;

//정삼각형 분할 놀이
public class P3282 {
	static int num, weight;
	static int [] W;
	static int [] C;
	static boolean [] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = sc.nextInt();
			weight = sc.nextInt();
			
			W = new int[num+1];
			C = new int[num+1];
			
			int [][] dp = new int[num+1][weight+1];
			
			for(int i=1 ; i<=num ; i++) {
				int weight = sc.nextInt();
				int cost = sc.nextInt();
				
				W[i] = weight;
				C[i] = cost;				
			}
			
			for(int i=1 ; i<=num ; i++) { //item
				for(int j=1 ; j<=weight ; j++) { //weight
					if(W[i] > j) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j-W[i]] + C[i], dp[i-1][j]);
					}
				}
			}
			
			//dp 를 활용해야 함 dp[i][j] i는 남은 무게, 현재 쳐다보는 보석의 번호 = 최대이득
			//D[i][j] = max(D[i][j + 1], D[i - w[j]][j + 1] + v[j])
			
			System.out.println("#" + test_case + " " + dp[num][weight]);
		}
		
		sc.close();
	}
}
