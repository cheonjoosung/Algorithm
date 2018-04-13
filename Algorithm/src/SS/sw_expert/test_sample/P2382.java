package SS.sw_expert.test_sample;

import java.util.Scanner;

//미생물 격리 
public class P2382 {
	public static void main(String[] args) {
		int T;
		
		Scanner scan = new Scanner(System.in);
		
		int[][] delta = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		T = scan.nextInt();
		for(int t=1; t<=T; t++)
		{
			int N = scan.nextInt(), M = scan.nextInt(), K = scan.nextInt();
			int[][] originNum = new int[N][N], updateNum = new int[N][N];
			int[][] originDirection = new int[N][N], updateDirection = new int[N][N]; // 1234 UDLR
			for(int k=0; k<K; k++)
			{
				int i = scan.nextInt(), j = scan.nextInt();
				originNum[i][j] = scan.nextInt(); originDirection[i][j] = scan.nextInt();
			}
			for(int m = 0; m < M; m++)
			{
				for(int i=0; i<N; i++)
				{
					for(int j=0; j<N; j++)
					{
						updateNum[i][j] = 0;
						updateDirection[i][j] = 0;
					}
				}
				int[][] maxNum = new int[N][N], maxDirection = new int[N][N];
				for(int i=0; i<N; i++)
				{
					for(int j=0; j<N; j++)
					{
						if(originNum[i][j] != 0)
						{
							int nextI = i + delta[originDirection[i][j]][0], nextJ = j + delta[originDirection[i][j]][1];
							if(nextI == 0 || nextJ == 0 || nextI == N-1 || nextJ == N-1) // 약품
							{
								updateNum[nextI][nextJ] = originNum[i][j] / 2; // 미생물 감소
								updateDirection[nextI][nextJ] = originDirection[i][j] < 3 ? (3 - originDirection[i][j]) : (7 - originDirection[i][j]); // 방향 전환
							}
							else if(updateNum[nextI][nextJ] != 0) // 합쳐지는 경우
							{
								updateNum[nextI][nextJ] += originNum[i][j];
								if(maxNum[nextI][nextJ] < originNum[i][j])
								{
									maxNum[nextI][nextJ] = originNum[i][j];
									maxDirection[nextI][nextJ] = originDirection[i][j];
								}
								updateDirection[nextI][nextJ] = maxDirection[nextI][nextJ];
							}
							else
							{
								maxNum[nextI][nextJ] = updateNum[nextI][nextJ] = originNum[i][j];
								maxDirection[nextI][nextJ] = updateDirection[nextI][nextJ] = originDirection[i][j];
							}
						}
					}
				}
				for(int i=0; i<N; i++)
				{
					for(int j=0; j<N; j++)
					{
						originDirection[i][j] = updateDirection[i][j];
						originNum[i][j] = updateNum[i][j];
					}
				}
			}

			int sum = 0;
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(updateNum[i][j] != 0)
					{
						sum += updateNum[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}
		
		scan.close();
	}
}
