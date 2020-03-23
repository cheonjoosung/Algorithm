package samsung.sw_expert.d3;

import java.util.Arrays;
import java.util.Scanner;

//GNS 
public class P1221 {
	static String [] GNS = {"ZRO" , "ONE" , "TWO" , "THR" , "FOR" , "FIV" , "SIX", "SVN" , "EGT", "NIN"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		
		for(int t=1 ; t<=testCase ; t++) {
			String s = sc.next();
			int count = sc.nextInt();
			
			int [] a = new int[count];
			
			for(int i=0; i<count ; i++) {
				String temp = sc.next();
				if(temp.equals("ZRO")) a[i] = 0;
				else if(temp.equals("ONE")) a[i] = 1;
				else if(temp.equals("TWO")) a[i] = 2;
				else if(temp.equals("THR")) a[i] = 3;
				else if(temp.equals("FOR")) a[i] = 4;
				else if(temp.equals("FIV")) a[i] = 5;
				else if(temp.equals("SIX")) a[i] = 6;
				else if(temp.equals("SVN")) a[i] = 7;
				else if(temp.equals("EGT")) a[i] = 8;
				else if(temp.equals("NIN")) a[i] = 9;
			}
			
			Arrays.sort(a);
			
			System.out.println("#"+t);
			for(int val : a) System.out.print(GNS[val] + " ");
			System.out.println();
		}

		sc.close();
	}
}