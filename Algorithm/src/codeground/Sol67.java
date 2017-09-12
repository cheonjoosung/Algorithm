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

				

				int eLoc = 0, iLoc = 0, oLoc = 0, uLoc = 0;
				
				if(i+1 < len)
					eLoc = line.substring(i+1, len).indexOf('e');
				if(eLoc < len && eLoc != -1)
					iLoc = line.substring(eLoc, len).indexOf('i');
				if(iLoc < len && iLoc != -1)
					oLoc = line.substring(iLoc, len).indexOf('o');
				if(oLoc < len && oLoc != -1)
					uLoc = line.substring(oLoc, len).indexOf('u');

				System.out.println("index : " + i + " , " + eLoc + " " + iLoc);
				
				if(i < eLoc && eLoc < iLoc && iLoc < oLoc && oLoc < uLoc) {
					Start = i+1;
					Last = uLoc;
				} else {
					continue;
				}
			}

			/*
			while(aLoc) {

				aLoc = line.indexOf('a');
				eLoc = line.indexOf('e');
				iLoc = line.indexOf('i');
				oLoc = line.indexOf('o');
				uLoc = line.indexOf('u');

				if(aLoc < eLoc && eLoc < iLoc && iLoc < oLoc && oLoc < uLoc) {
					//System.out.println(Answer + " " + aLoc + " , " + uLoc + " , " + temp);
					if(Answer > (uLoc - aLoc)) {
						Start = (aLoc+1) + temp;
						Last = (uLoc+1) + temp;
						Answer = Last - Start;
					}
				} else {
					break;
				}

				line = line.substring(aLoc+1, line.length());
				temp += (aLoc+1);
				//System.out.println(line + " , " + temp + " " + aLoc);
			}
			 */

			System.out.println("Case #"+(test_case+1));
			System.out.println(Start + " " + Last);
		}
	}


}
