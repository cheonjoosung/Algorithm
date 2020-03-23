package samsung.sw_expert.d3;

import java.util.Scanner;

//최장 공통 부분 수열
public class P3304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			String aStr = sc.next();
			String bStr = sc.next();
			
			int [][] d = new int[1001][1001];
			
			for(int i=0 ; i<aStr.length() ; i++) {	
				for(int j=0 ; j<bStr.length() ; j++) {
					if(aStr.charAt(i) == bStr.charAt(j))
						d[i+1][j+1] = d[i][j] +1;
					else 
						d[i+1][j+1] = Math.max(d[i][j+1], d[i+1][j]);
				}
			}
			
			System.out.println("#" + t + " " + d[aStr.length()][bStr.length()]);
		}
		
		sc.close();
	}
}
