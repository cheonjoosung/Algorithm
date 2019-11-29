package exam;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=2 ; i<=9 ; i++) {
			System.out.println(i + " " + changeNum(14, i));
		}
		sc.close();
	}
	
	public static int changeNum(int N, int i) {
		
		StringBuilder sb = new StringBuilder();
		
		while(N >= i) {
			sb.append(N % i);
			N /= i;
		}
		sb.append(N);
			
		int sum = 1;
		String s = sb.toString();
		
		for(int x=0 ; x<s.length() ; x++) {
			int val = Integer.parseInt(s.charAt(x)+"");
			if(val != 0) sum *= val;
		}
		
		return sum;
	}
}
