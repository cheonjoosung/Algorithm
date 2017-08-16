package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//27번 바이러스
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
			
			ArrayList<Integer> removedList = new ArrayList<>();
			boolean isFound = false;
			
			for(int [] temp : a) 
				Arrays.fill(temp, -1);
			
			for(int i=0; i<line ; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				
				a[first][second] = 1;
				a[second][first] = 1;
			}	
			
			int size = n;
			
			while( size >= l) {
				size = n - removedList.size();
				
				int minLine = k;
				int maxLine = size - l -1;
				int totalCount = 0;
				
				//System.out.println("minLine : " + minLine + " , maxLine : " + maxLine);
				
				for(int i=1 ; i<n+1 ; i++) {
					//System.out.println("i : " + i);
					if(removedList.contains(i)) continue;
					
					int lineCount = 0;
					
					for(int j=1 ; j<n+1 ; j++) {
						//System.out.println("i : " + i + " , j : " + j + " , a[i][j] : " + a[i][j]);
						if(removedList.contains(i) || removedList.contains(j)) continue;
						
						if(a[i][j] == 1) lineCount++;
					}
					
					if(lineCount >= minLine && lineCount <= maxLine) {
						totalCount++;
					} else {
						removedList.add(i);
						break;
					}
				}
				
				if(size == totalCount) break;
			}
			
			for(int val : removedList) {
				Answer += val;
				//System.out.print(val + " ");
			}
			
			if(size < l) {
				Answer = 0;
				for(int i=1; i<=n ; i++) {
					Answer += i;
				}
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
