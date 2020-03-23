package samsung.sw_expert.d3;

import java.util.Scanner;

//홀수일까 짝수일까
public class P5549 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			String s = sc.next();
			String ans = "Odd";
			
			int val = Integer.parseInt(s.charAt(s.length()-1)+"");
			if(val % 2 == 0) ans = "Even";
			
			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
}