package backjun.p8000_9000;

import java.util.Scanner;

//직사각형을 만드는 방법
public class P8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int [] cnt = new int[n+1];
		
		for(int i=1;i<=n;i++){
	        int sum=0;
	        for(int j=1;j*j<=i;j++){
	            if(i%j==0) sum++;
	        }
	        cnt[i] = cnt[i-1] + sum;
	    }
		System.out.println(cnt[n]);


		sc.close();
	}
}
