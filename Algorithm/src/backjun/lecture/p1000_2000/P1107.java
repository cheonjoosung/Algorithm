package backjun.lecture.p1000_2000;

import java.util.ArrayList;
import java.util.Scanner;

public class P1107 {
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int broke = sc.nextInt();
		int answer = 0;

		list = new ArrayList<>();

		for(int i=0 ; i<broke ; i++) {
			list.add(sc.nextInt());
		}
		
		answer = Math.abs(n-100);

		if(n == 100) {
			System.out.println(0);
		} else {
			for(int i=0 ; i<= 1000000 ; i++) {
				int c = i;
				int len = possible(c);
				
				if(len > 0) {
					int press = Math.abs(c - n);
					answer = Math.min(answer, len+press);	
				}
			}
			System.out.println(answer);
		}

		sc.close();
	}
	
	public static int possible(int num) {
		if(num == 0) {
			if(list.contains(0)) return 0;
			else return 1;
		}
		
		int len = 0;
		while(num > 0) {
			if(list.contains(num%10)) return 0;
			len++;
			num /= 10;
		}
		return len;
	}
}
