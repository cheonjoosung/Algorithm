package samsung.sw_expert.d3;

import java.util.Scanner;

//Digit sum
public class P3750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			long num = sc.nextLong();
			
			while(num >= 10) {
				String s = String.valueOf(num);
				
				long value = 0;
				char [] temp = s.toCharArray();
				
				for(char c : temp)
					value += Integer.parseInt(c+"");
				
				num = value;
			}
			
			
			System.out.println("#" + t + " " + num);
		}
		
		sc.close();
	}
}