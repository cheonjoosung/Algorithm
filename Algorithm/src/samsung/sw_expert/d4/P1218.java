package samsung.sw_expert.d4;

import java.util.Scanner;
import java.util.Stack;

//[S/W 문제해결 기본] 4일차 - 괄호 짝짓기 
public class P1218 {
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();
			String s = sc.next();

			ans = 1;
			Stack<Character> stack = new Stack<>();

			for(int i=0 ; i<n ; i++) {
				char c = s.charAt(i);

				if(c == '{' || c == '(' || c == '[' || c == '<') {
					stack.push(c);
				} else {
					if(stack.isEmpty()) {
						ans = 0;
						break;
					}
					char temp = stack.pop();

					if(c == '}') {
						if(temp != '{') {
							ans = 0 ; 
							break;
						}
					} else if(c == ')') {
						if(temp != '(') {
							ans = 0 ; 
							break;
						}
					} else if(c == ']') {
						if(temp != '[') {
							ans = 0 ; 
							break;
						}
					} else if(c == '>') {
						if(temp != '<') {
							ans = 0 ; 
							break;
						}
					}
				}
			}

			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}