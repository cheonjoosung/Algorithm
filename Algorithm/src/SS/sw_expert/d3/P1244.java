package SS.sw_expert.d3;

import java.util.Scanner;

//최대 상금  
public class P1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<=testCase ; t++) {
			int num = sc.nextInt();
			int exchange = sc.nextInt();

			for(int i=0 ; i<exchange ; i++) {
				String s = num + "";
				
				int startNum = Integer.parseInt(s.charAt(0)+"");
				
				for(int j=1 ; j<s.length() ; j++) {
				}
			}

			//System.out.println("#" + t + " " + sum);
		}

		sc.close();
	}
}