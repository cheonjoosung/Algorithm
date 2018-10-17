package SS.sw_expert.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//늘어지는 소리 만들기
public class P4676 {
	static int n;
	static int [][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			String s = sc.next();
			
			int n = sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0 ; i<n ; i++)
				list.add(sc.nextInt());
			Collections.sort(list);
			
			String res = "";
			for(int i=0 ; i<s.length() ; i++) {
				for(int j=0 ; j<list.size() ; j++) 
					if(list.get(j) == i) res+= "-";
				res += s.charAt(i)+"";
			}
			
			for(int j=0 ; j<list.size() ; j++) {
				if(list.get(j) > s.length()-1) res += "-";
			}
			
			System.out.println("#" + t + " " + res);
		}
		
		sc.close();
	}
}