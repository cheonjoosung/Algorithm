package SS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	static int n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			n = sc.nextInt();

			ans = 0;
			solve();			
			
			System.out.println("#" + t + " " + ans);
		}        

		sc.close();
	}

	public static void solve() {}
}