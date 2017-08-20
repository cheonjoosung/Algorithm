package codeground;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Test {
	static long[] fact = new long[2000005];
	static int[] fact2 = new int[2000005];
	static long[] reverseFact = new long[2000005];
	static int MOD = 1_000_000_007;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		fact[0] = 1;
		fact2[0] = 1;
		reverseFact[0] = 1;

		for(int i = 1; i < 200001; i++)
			fact[i] = i * fact[i-1] % MOD;
		
		for(int i = 1; i < 200001; i++)
			fact2[i] = (i * fact2[i-1])% MOD;
		
		long z = fact[10];
		z = (z * fact[9] ) % MOD;
		z = (z * fact[8] ) % MOD;
		
		long x = fact2[10];
		x = (x * fact2[9] ) % MOD;
		x = (x * fact2[8] ) % MOD;
		
		long y = (fact2[10] *fact2[9] ) % MOD;
		y = (y * fact2[8]) % MOD;
		
		int a = Integer.MAX_VALUE;
		short b = 32000;
		long c = a + (long)b;
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		System.out.println(x + " , " + y + " " + z );
		
	}
	
	
}