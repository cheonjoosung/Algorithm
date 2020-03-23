package samsung.sw_expert.d2;

import java.util.Scanner;

//날짜 계산기
public class P1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {
			int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int sMonth = sc.nextInt();
			int sDay = sc.nextInt();
			int eMonth = sc.nextInt();
			int eDay = sc.nextInt();
			int wDay=month[sMonth]-sDay+1;
			
			for(int i=sMonth+1; i<eMonth; i++) wDay += month[i];
			
			if(sMonth != eMonth) wDay+=eDay;
			
			System.out.println("#" + t + " " + wDay);		
		}

		sc.close();
	}
}
