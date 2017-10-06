package codeground;

import java.util.Scanner;

public class Sol63 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			
			int people = sc.nextInt();
			int [] v = new int[people];
			int [] track = new int[people];
			int [] start = new int[people];
			
			//68 , 63 , 217
			
			int maxIndex = -1;
			int max = -1;
			
			for(int i=0 ; i<people ;i++) {
				v[i] = sc.nextInt();
				track[i] = sc.nextInt();
				start[i] = sc.nextInt();
				
				if(max < v[i]) {
					max = v[i];
					maxIndex = i;
				}
			}
			
			boolean isFound;
			for(int t=1 ;  ; t++) {
//				if(( v[0]*t + start[0] ) % track[0] != 0) continue; 
				isFound = true;
				for(int i=0 ; i< people ; i++) {
					if( (v[i]*t + start[i]) % track[i] == 0) {
						//System.out.println(i + " " + t);
						continue;
					}
					else {
						isFound = false;
						break;
					}
				}
				
				if(isFound == true) {
					Answer = t;
					break;
				}
			}
			
			for(int i=1 ; i<=312 ; i++) {
				if( (7*i + 17) % 31 == 0)
					System.out.println(i);
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
