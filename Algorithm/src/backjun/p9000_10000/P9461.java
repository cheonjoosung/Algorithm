package backjun.p9000_10000;

import java.util.Arrays;
import java.util.Scanner;

public class P9461 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		
		long[] d = {0,1,1,1,2,2,3,4,5,7,9};
		d = Arrays.copyOf(d, 101);
		
		for(int i=10; i<=100 ; i++)
			d[i] = d[i-1] + d[i-5];
		
		while(test-- > 0) {
			int n = sc.nextInt();	

			System.out.println(d[n]);
		}

		sc.close();
	}
}

