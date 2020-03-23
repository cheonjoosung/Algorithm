package samsung.sw_expert.test_sample;

import java.util.Scanner;


//홈 방범 서비스
public class P2117 {
	static int N, M, ans;
	
	static int [][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][N];
			
			for(int i=0 ; i<N ; i++)
				for(int j=0 ; j<N ; j++)
					map[i][j] = sc.nextInt();
			
			/*
			 * 운용 비용 = k*k + (k-1) * (k-1);
			 * 손해를 보지 않고 이득을 볼 수 있을 때 집 최대 커버 영역
			 * 집하나당 M 만큼의 돈을 걷음(영역에 포함시) 
			 * 
			 * 해결방안 
			 * 1. K 에 증감 
			 * 2. 영역을 이동시키며 포함되는 집 갯 수 구하기 (방범 서비스 영역은 배열 밖을 나갈 수 있다)
			 * 3. (M*갯수 - 운용비용) > 0 이면 집의 갯수 포함
			 * *. 집으로 나오는 최대 비용이 = m*3 이고 운용비용이 이것보다 작은 한도에서 K 의 가능한 최대값 설정 
			 */
			

			System.out.println("#" + test_case + " " + ans + " ");
		}

		sc.close();
	}
}
