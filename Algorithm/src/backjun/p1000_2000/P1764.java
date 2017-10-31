package backjun.p1000_2000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<String> aList = new ArrayList<>();
		for(int i=0; i<n ; i++) {
			String s = sc.next();
			aList.add(s);
		}
		
		ArrayList<String> tempList = new ArrayList<>();
		for(int i=0; i<m ; i++) {
			String s = sc.next();
			if(aList.contains(s)) tempList.add(s);
		}
		
		Collections.sort(tempList);
		System.out.println(tempList.size());
		for(String temp : tempList) System.out.println(temp);
		
		
		sc.close();
	}
}
