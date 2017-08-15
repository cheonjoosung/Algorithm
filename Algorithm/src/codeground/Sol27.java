package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sol27 {
	static int Answer;
	static int MAX = 101;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int k = sc.nextInt(); //1개 이상의 로봇과 통신해야 되는 수
			int l = sc.nextInt(); //감영된 후 L 개 이상의 로봇이 살아남도
			//각 정점의 차수 G` 은 최소 k 이면서 최대 |V`| - L - 1
			
			int n = sc.nextInt(); //그래프 정점 수
			int line = sc.nextInt(); //총 간선의 갯수
			
			int [][] a = new int[n+1][n+1];
			
			boolean isFound = false;
			
			ArrayList<Integer> removedList = new ArrayList<>();
			
			for(int [] temp : a) 
				Arrays.fill(temp, -1);
			
			for(int i=0; i<line ; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				
				a[first][second] = 1;
				a[second][first] = 1;
			}	
			
			int count = 0;
			while( isFound != true) {
				int size = n - removedList.size();
				
				for(int i=1 ; i<n+1 ; i++) {
					if(removedList.contains(i)) {
						
					} else {
						
					}
				}
				
				isFound = true;
			}
			
			for(int i=0 ; i<n ; i++) {
				int minLine = k;
				int maxLine = n - i - 1;
				
				for(int x=1 ; x< n+1 ; x++) {
					check(a, x, minLine, maxLine);
				}
			}
			System.out.println(a[2][1] + " , " + a[1][2]);
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static boolean check(int [][] a, int vertex, int minLine, int maxLine){
		int count = 0;
		for(int i=1 ; i < a.length ; i++) {
			if(a[vertex][i] == 1) {
				count++;
			}
		}
		
		System.out.println(vertex + " : " + count);
		
		if(count >= minLine && count <= maxLine) {
			return true;
		} else {
			return false;
		}
	}
}
