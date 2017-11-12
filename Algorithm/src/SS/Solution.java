package SS;

import java.util.Scanner;

public abstract class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = "before";

		System.out.println(s);

		//System.out.println(good(2 + 3));
		//System.out.println(good(2.0 + 3.0));
		sc.close();
	}

	public abstract int test(String s);

	public static <T> T good(T val) {
		
		return val;
	}
}