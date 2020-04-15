package programmers.lv2;

import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) {
		Compress c = new Compress();
		
		System.out.println(c.solution("aabbaccc"));
		
		System.out.println(c.solution("ababcdcdababcdcd"));
		System.out.println(c.solution("abcabcdede"));
		System.out.println(c.solution("abcabcabcabcdededededede"));
		System.out.println(c.solution("xababcdcdababcdcd"));
	}
}