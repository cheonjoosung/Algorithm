package SS.sw_expert.d2;

import java.util.Scanner;

//간단한 369게임
public class P1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int k=1 ; k<=n ; k++) {
			String s = k + "";

			for(int i=0 ; i<s.length() ; i++) {
				if(s.charAt(i) == '3' || s.charAt(i) == '6' || s.charAt(i) == '9') System.out.print("-");
			}

			if(!s.contains("3") && !s.contains("6") && !s.contains("9")) System.out.print(k);

			System.out.print(" ");
		}

		sc.close();
	}
}
