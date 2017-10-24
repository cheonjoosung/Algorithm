package SS.Winter2017;

import java.util.Scanner;

/*
4
0 1 3 2
3 0 2 2
2 2 0 4
4 4 2 0

6
0 1 2 3 4 5
100 0 60 70 80 900
150 200 0 100 1100 120
250 350 450 0 155 550
555 344 211 100 0 400
4665 3666 2987 1000 999 0

8
0 1 3 2 3 3 4 4 
3 0 2 2 3 2 2 2
2 2 0 4 2 1 1 1

4 4 2 0 1 5 3 3 
5 3 2 1 0 4 2 3 
4 3 2 1 9 0 1 5
1 5 6 7 8 9 0 9
1 1 1 2 2 2 2 0
첫째는 선수 총 인간수, 2개의 팀을 만들고 그 시너지 차이가 최소가 되는 값을 출력해라
1행 2열은 1번과 2번이 같은 팀했을 때 시너지  1번입장에서의 2와 2번 입장에서의 1은 다름
2
 */
public class Sol_2 {
	static int Min;
	static int [][] input; //입력값 
	static int [][] score; //입력값을 바탕으로 점수화 1,4 1번과4번이 합쳤을때 시너지 총합
	static int [] combi;
	static int [] sum;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Min = Integer.MAX_VALUE-1;
		input = new int[n+1][n+1];
		score = new int[n+1][n+1];
		combi = new int[n];
		
		int up = 1, down = 1;
		for(int i=n ; i>n/2 ; i--) up *= i;
		for(int i=n/2 ; i>0 ; i--) down *= i;
		sum = new int[up/down];

		for(int i=0; i<n ; i++) combi[i] = i+1; //순열을 위해서 사용

		for(int i=1; i<=n ; i++)
			for(int j=1; j<=n ; j++)
				input[j][i] = sc.nextInt();

		for(int i=1; i<=n ; i++) {
			for(int j=1; j<i ; j++) {
				if(i==j) score[j][i] = 0;
				else {
					score[j][i] = input[j][i] + input[i][j];;
					score[i][j] = input[j][i] + input[i][j];;
				}
			}
		}

		/*
		 * 0. 완전탐색
		 * 1. 순열 알고리즘 nCm (m = n/2);
		 * 2. 나온 순열의 합을 이용하여 차를 구한다.
		 */
		
		combination(combi, 0, n, n/2, 1);
		for(int i=0 ; i< (up/down)/2 ; i++) {
			//System.out.println((up/down) + " " + i + " " + ((up/down) - i - 1));
			int val = Math.abs(sum[i] - sum[(up/down) - i -1]);
			Min = Math.min(Min, val);
		}
		System.out.println(Min);

		sc.close();
	}

    /*
     * Index : arr Index, n : n개 원소, 뽑아야할 원소 수, target : arr 실제 들어가는 값
     */
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0) calculate(arr, index, n); 
		else if (target == n+1) return; 
		else {
			arr[index] = target; 
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1); 
		} 
	}

	public static void calculate(int[] arr, int length, int n) {
		/*for (int i = 0; i < length; i++) 
			System.out.print(arr[i] + " "); */
			
		int temp = 0;
		for(int i=0; i<length; i++)
			for(int j=i+1 ; j< length ; j++)
				temp += score[arr[i]][arr[j]];
		
		sum[count] = temp;
		count++;
	}

}
