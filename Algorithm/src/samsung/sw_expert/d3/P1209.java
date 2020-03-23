package samsung.sw_expert.d3;

import java.util.Scanner;

//Sum
public class P1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();
			int [] row = new int[100];
			int [] col = new int[100];
			int line1 = 0, line2 = 0;
			
			int max = 0;
			
			for(int i=0 ; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++) {
					int val = sc.nextInt();
					if(i == j) line1 += val;
					if(i+j == 99) line2 += val;
					
					row[i] += val;
					col[j] += val;
				}
			}
			
			max = Math.max(line1, line2);
			for(int val : row) max = Math.max(max, val);
			for(int val : col) max = Math.max(max, val);
			
			System.out.println("#"+t+ " " + max);
		}
		
		sc.close();
	}
}