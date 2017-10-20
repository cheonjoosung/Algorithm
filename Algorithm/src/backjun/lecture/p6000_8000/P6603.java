package backjun.lecture.p6000_8000;

import java.util.Scanner;

public class P6603 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isExit = false;
		while(!isExit) {
			int n = sc.nextInt();
			
			if(n == 0) break;
			else {
				int [] arr = new int[n];
				for(int i=0 ; i<n ; i++) {
					int val = sc.nextInt();
					arr[i] = val;
				}
				dfs(n, arr, 0, 6, "");
				System.out.println();
			}
		}
		
		sc.close();
	}
	
	public static void dfs(int size , int [] arr, int index, int N, String s) {
		if(N == 0) System.out.println(s);
		else if(index >= size) return;
		else {
			dfs(size, arr, index+1, N-1, s + arr[index] + " ");
			dfs(size, arr, index+1, N, s);
		}	
	}
}
