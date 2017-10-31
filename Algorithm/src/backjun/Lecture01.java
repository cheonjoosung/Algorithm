package backjun;

import java.util.Scanner;

public class Lecture01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int mon = sc.nextInt();
		int day = sc.nextInt();
		int sum = 0;

		int [] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if(mon != 1) {
			for(int i=0 ; i< mon-1 ; i++) {
				sum += arr[i];
			}
			sum += day - 1;
		} else {
			sum += day - 1;
		}
		
		switch(sum % 7) {
		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		}
		
		sc.close();
	}
}
