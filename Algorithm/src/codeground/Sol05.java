package codeground;

import java.util.Scanner;

//CodeGround 5번 이항계수의합
public class Sol05 {
	static int Answer;

	static final long MOD = 1000000007;
	static long[] fact = new long[2000003];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * 주어진 문제를 정리하면 n+m+2 Combination n+1 이 되어 버린다. (n+m+2)! / ( (n+1)! * (m+1)! ) 의 값을 구해야 함 !!! 그리고 mod P까지 해야 하는 상
		 * 페르마의 정리를 활용(=== 의 의미는 양변을 mod p 했을 때 값이 값다는 의미 원래는 세개짜리 등가기호를 써야함). a^p === a (mod p) / a^(p-1) === 1 (mod p)
		 * fact[n], fact[n-r], fact[r] 이 다 구해지는 상태임, A/B mod p 는 ( A mod p ) * ( B^(p-2) mod p )
		 * 1. B^(P-1) === 1 (mod P)
		 * 2. A * B^(P-1) === A (mod P)
		 * 3. A * B^(P-1) * B^(-1) === A/B (mod P) -> A *B^(P-2) === A/B (mod P)  즉, A*B^(P-2) mod P 를 구하는 공식이 된다.
		 * 4. 양변에 %P 를 하고 분배를 적용하면 (A % P) * (( B^(P-2))  % P) === A/B % P ( mod P )
		 * 여기서 A : n+m+2 팩토리얼 ,  B : n+1 팩토리얼 이라고 생각하면 됨 
		 */
		
		fact[0] = 1;
		for(int i = 1; i < 2000003; i++)
			fact[i] = i * fact[i-1] % MOD;

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			
			Answer = 0;

			int n = sc.nextInt();
			int m = sc.nextInt();
			
			/*
			 * 1. a*b mod p  = ( ( a mod p)  * (b mod p ) ) mod p
			 */
			
			long up = fact[n+m+2];
			long down1 = fact[n+1];
			long down2 = fact[m+1];
			long down = (down1*down2) % MOD;
			
			long result = combination(down, MOD-2); // B^(p-2) 제곱을 구하기 위해
			
			result %= MOD;
			result *= up;
			result %= MOD;
			
			Answer = (int) result;
			
			
			// Print the answer to standard output(screen).
			System.out.println("Case #" + (test_case+1));
			System.out.println(Answer - 1);
		}
	}
	
	public static long combination(long val, long p) {
		if(p == 0) return 1;
		if(p == 1) return val;
		
		
		long half = combination(val, p/2);   
		
		/*
		 *  p/2 에서 
		 *  1) p=2k (짝수)  b^(p/2) -> b^k 가 된다. b^k * b^k = b^p 가 나오기 때문에... half*half % MOD 를 쓰면 된다.
		 *  2) p=2k+1 (홀수) b^(p/2) -> b^k 이 된다. b^k * b^k = b^2k != b^p 이므로 좌변에 b 를 곱해줘야 함. 즉, ( (half * half) % MOD * val(홀수이기에 추가 곱) ) % MOD 다시 나누는 이유는 ab mod p = (a mod p * b mod p) mod p
		 */
		if(p%2 == 0) return (half*half) % MOD;
		else return ( ( (half*half) % MOD ) * val) % MOD;  
	}
}