package codeground;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	
	public static void main(String args[]) throws Exception	{
	    Scanner sc = new Scanner(System.in);
	    
	 
	    long result = fact(10);
	    System.out.println(result);
	    System.out.println(gcd(16, 10));
	    System.out.println(lcd(16, 10));
	}
	
	public static long fact(long num) {
		if(num == 0 || num == 1){
			return 1;
		} else {
			return num * fact(num-1);
		}
	}	
	
	public static int gcd(int m, int n) {
		if(n == 0)
			return m;
		else
			return gcd(n, m % n);
	}
	
	public static int lcd(int m, int n) {
		return (m * n) / gcd(m,n);
	}
}