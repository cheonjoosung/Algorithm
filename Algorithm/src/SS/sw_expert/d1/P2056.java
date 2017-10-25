package SS.sw_expert.d1;

import java.util.Scanner;

//연월일 달력
public class P2056 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1; t<=testCase ; t++) {
			String s = sc.next();

			String year = s.substring(0, 4);
			String mon = s.substring(4, 6);
			String day = s.substring(6, s.length());

			switch(Integer.parseInt(mon)) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(Integer.parseInt(day) <= 31 && Integer.parseInt(day) > 0) 
					System.out.println("#"+t+ " " + year + "/" + mon + "/" + day);
				else
					System.out.println("#"+t + " " + -1);
				break;
			case 2:
				if(Integer.parseInt(day) <= 28 && Integer.parseInt(day) > 0) 
					System.out.println("#"+t+ " " + year + "/" + mon + "/" + day);
				else
					System.out.println("#"+t + " " + -1);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(Integer.parseInt(day) <= 30 && Integer.parseInt(day) > 0) 
					System.out.println("#"+t+ " " + year + "/" + mon + "/" + day);
				else
					System.out.println("#"+t + " " + -1);
				break;
			default :
				System.out.println("#"+t + " " + -1);
			}
		}

		sc.close();
	}
}