package samsung.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//모음이 보이지 않는 사람
public class P4406 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			String str = sc.next();
			
			ArrayList<String> list = new ArrayList<>();
			for(int i=0 ; i<str.length() ; i++) {
				if(str.charAt(i) == 'a' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || 
						str.charAt(i) == 'e' ||  str.charAt(i) == 'u') continue;
					
				list.add(str.charAt(i)+"");
			}
			
			StringBuilder sb = new StringBuilder();
			for(String s : list) sb.append(s);
						
			System.out.println("#" + t + " " + sb);
		}
		
		sc.close();
	}
}