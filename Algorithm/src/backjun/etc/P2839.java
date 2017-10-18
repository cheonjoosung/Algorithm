package backjun.etc;

import java.util.Scanner;

public class P2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ans5 = 0;
		int ans3 = 0;
		
		int start = n / 5;
		
		int temp = n;
		for(int i = start ; i >= 0 ; i--) {
			temp = n;
			
			temp = temp - i*5;
			if(temp % 3 != 0) continue;
			else {
				ans5 = i;
				ans3 = temp/3;
				break;
			}
		}
		if(ans3 + ans5 == 0) System.out.println(-1);
		else System.out.println(ans5 + ans3);
		
		sc.close();
	}
}
