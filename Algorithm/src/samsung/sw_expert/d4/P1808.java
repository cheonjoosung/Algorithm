package samsung.sw_expert.d4;

import java.util.Arrays;
import java.util.Scanner;

//1808번 지희의 고장난 계산기
public class P1808 {
	static int n, ans;
	static int [] dp;
	static boolean [] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			check = new boolean[10];

			for(int i=0 ; i<10 ; i++) {
				int val = sc.nextInt();
				if(val == 1) check[i] = true;
				else check[i] = false;
			}

			n = sc.nextInt();

			dp = new int[n+1];
			Arrays.fill(dp, -1);;

			ans = solve(n);
			ans++; //=추가
			/*
			 * ex) 60 을 1,2,5 와 곱으로 만들기 
			 * 1. 소인수 분해 : 1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60
			 * 2. 1 : 1번, 2 : 1번, 3 : 불가, 4 : 3번, 5: 1번, 6 : 3번, 10 : 5번
			 * 12 : 2번(1한번,2한번), 15 : 2번(1한번,5한번), 20 : 5번, 30 : 3번(15*2), 60 : 4번(12*5)
			 * dp[i] = Min (dp[약수 a] + dp[약수 b] 중 하나, 직접 눌러서 나오는 경우) 
			 */
			if(ans >= 100000) ans = -1;
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
	
	public static int solve(int num) {
        if(dp[num] != -1) return dp[num];
        if(num<=9 && check[num]) return 1;
        if(num<=9 && !check[num]) return 100000;
		dp[num] = getCount(num);
        
		int range = (int)Math.sqrt(num);
		for(int i=1 ; i<=range ; i++) {
			if(num % i == 0) 
				dp[num] = Math.min(dp[num],  solve(i) + solve(num/i) + 1);
			//i로 나누어지면 num/i * i = num, +1 은 곱셈누르기
		}

		return dp[num];
	}

	public static int getCount(int num){ 
		int cnt = 0;

		while(num>0){ //12 -> 1, 2확인 직접 만들수 있는 가능성 체크 후 수 리턴
			cnt++;
			int v = num % 10;
			if(!check[v]) {
				return 100000;
			}
			num/=10;
		}
		return cnt;
	}
}