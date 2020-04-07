package programmers.lv2;

import java.util.ArrayList;

public class NewsCluster {
	public int solution(String str1, String str2) {
		int answer = 1; //65536

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		int or = 0;
		int and = 0;
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=1 ; i<str1.length() ; i++) {
			char c1 = str1.charAt(i-1);
			char c2 = str1.charAt(i);
			
			if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
				list.add(c1 + "" + c2);
			}
		}

		or = list.size();
		
		
		for(int i=1 ; i<str2.length() ; i++) {
			char c1 = str2.charAt(i-1);
			char c2 = str2.charAt(i);
			
			if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
				String temp = c1 + "" + c2;
				
				if(list.contains(temp)) {
					and++;
					list.remove(temp);
				} else {
					or++;
				}
			}
		}

		if(or == 0 && and == 0) return answer * 65536;
		else {			
			return (int) (65536 * (and/(double)or));
		}
	}
}
