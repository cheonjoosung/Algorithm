package backjun.etc;

import java.util.Arrays;
import java.util.Scanner;

public class P1759 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		int count = sc.nextInt();
		
		String [] arr = new String[count];
		
		for(int i=0 ; i<count ; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
		go(count, arr, "", 0, len);
		
		sc.close();
	}
	
	public static void go(int n, String [] arr, String password, int i, int len) {
		if(password.length() == len) {
			if(check(password)) {
				System.out.println(password);
				return;
			}
		}
		
		if(i >= arr.length) return;
		go(n, arr, password+arr[i], i+1, len);
		go(n, arr, password, i+1, len);
	}
	
	public static boolean check(String password) {
		int ja = 0, mo =0;
		
		for(int i=0; i<password.length() ; i++){
			char c = password.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c=='o' || c=='u') mo++;
			else ja++;
		}
		
		return (ja>=2 && mo >=1);
	}
}
