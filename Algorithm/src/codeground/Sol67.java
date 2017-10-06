package codeground;

import java.util.Scanner;

public class Sol67 {
	static int Answer;
	static int Start;
	static int Last;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//a e i o u

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 987_654_321;

			int len = sc.nextInt();
			String line = sc.next();

			Start = -1;
			Last = -1;

			for(int i=0 ; i < len ; i++) {
				if(line.charAt(i) != 'a')
					continue;
				
				int eLoc = -1, iLoc = -1, oLoc = -1, uLoc = -1;
				
				if(i+1 < len)
					eLoc = line.substring(i+1, len).indexOf('e') + (i+1);
				if(eLoc < len && eLoc != -1)
					iLoc = line.substring(eLoc, len).indexOf('i') + eLoc;
				if(iLoc < len && iLoc != -1)
					oLoc = line.substring(iLoc, len).indexOf('o') + iLoc;
				if(oLoc < len && oLoc != -1)
					uLoc = line.substring(oLoc, len).indexOf('u') + oLoc;

				//System.out.println("index : " + i + " , " + eLoc + " , " + iLoc + " , " + oLoc + " , " + uLoc);
				
				if(i < eLoc && eLoc < iLoc && iLoc < oLoc && oLoc < uLoc) {
					if(Answer > (uLoc - i)) {
						Start = i+1;
						Last = uLoc+1;
						Answer = (Last - Start);
					}
				} else {
					continue;
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Start + " " + Last);
		}
	}


}
