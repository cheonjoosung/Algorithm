package SS.sw_expert.d2;

import java.util.Scanner;

//시각 덧셈
public class P1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {			
			int total = 0;
			
			for(int i=0 ; i<4 ; i++) {
				if(i %  2 == 0) total += sc.nextInt()*60;
				else total += sc.nextInt();
			}

			int time = (total/60)%12;
			int min = total%60;
			
			if(time == 0) time = 12;
			System.out.println("#" + t + " " + time + " " + min);
		}

		sc.close();
	}
}
