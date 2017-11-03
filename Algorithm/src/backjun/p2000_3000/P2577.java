package backjun.p2000_3000;

import java.util.Arrays;
import java.util.Scanner;

//숫자의 개수
public class P2577 {
	static int MOD = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int a = sc.nextInt();	
			int b = sc.nextInt();
			int c = sc.nextInt();
			c *= a*b;
			int [] arr = new int[10];
			Arrays.fill(arr, 0);
			
			String s = c + "";
			for(int i=0 ; i<s.length() ; i++) {
				arr[Integer.parseInt(s.charAt(i)+"")]++;
			}
			
			for(int i=0; i<10 ; i++) System.out.println(arr[i]);
		
		sc.close();
	}
}

