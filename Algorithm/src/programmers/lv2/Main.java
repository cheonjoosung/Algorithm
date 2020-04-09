package programmers.lv2;

import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) {
		Tuple t = new Tuple();
		
		String str1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String str2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String str3 = "{{20,111},{111}}";
		String str4 = "{{123}}";
		String str5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		System.out.println(t.solution(str1));
		System.out.println(t.solution(str2));
		System.out.println(t.solution(str3));
		System.out.println(t.solution(str4));
		System.out.println(t.solution(str5));
		
		int [] arr = t.solution(str1);
		
		for(int temp : arr) {
			System.out.println(temp + " ");
		}	
	}
}