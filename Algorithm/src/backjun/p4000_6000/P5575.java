package backjun.p4000_6000;

import java.util.Scanner;

public class P5575 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0 ; i<3 ; i++) {
			int st = sc.nextInt();
			int sm = sc.nextInt();
			int ss = sc.nextInt();
			
			int et = sc.nextInt();
			int em = sc.nextInt();
			int es = sc.nextInt();
			
			int sum = (et*60*60 + em*60 + es) - (st*60*60 + sm*60 + ss);
			int hour = sum/3600;
			sum %= 3600;
			int minute = sum/60;
			sum %= 60;
			int second = sum;
			System.out.println(hour + " " + minute + " " + second);
		}
		
		sc.close();
	}
}
