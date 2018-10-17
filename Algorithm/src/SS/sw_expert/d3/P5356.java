package SS.sw_expert.d3;

import java.util.Scanner;

//의석이의 세로로 말해요
public class P5356 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			int n = 5;
			String ans = "";

			int max = 0;
			
			String a = sc.next();
			String b = sc.next();
			max = Math.max(a.length(), b.length());
			String c = sc.next();
			max = Math.max(max, c.length());
			String d = sc.next();
			max = Math.max(max, d.length());
			String e = sc.next();
			max = Math.max(max, e.length());
			
			for(int i=0 ; i<max ; i++) {
				if(i < a.length()) ans += a.charAt(i);
				if(i < b.length()) ans += b.charAt(i);
				if(i < c.length()) ans += c.charAt(i);
				if(i < d.length()) ans += d.charAt(i);
				if(i < e.length()) ans += e.charAt(i);
			}
			
			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
}