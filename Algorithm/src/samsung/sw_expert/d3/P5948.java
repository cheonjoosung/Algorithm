package samsung.sw_expert.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//5948번 새샘이의 7-3-5 게임
public class P5948 {
	static int ans;
	static int [] arr;
	static boolean [] visited;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			ans = 0;
			arr = new int[7];
			visited = new boolean[7];
			list = new ArrayList<>();

			for(int i=0 ; i<7 ; i++)
				arr[i] = sc.nextInt();

			dfs(0, 0);
			Collections.sort(list);
			Collections.reverse(list);
			ans = list.get(4);

			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}
	
	public static void dfs(int cnt, int sum) {
		if(cnt == 3) {
			if(!list.contains(sum)) 
				list.add(sum);
			
			return;
		}
		
		for(int i=0 ; i<7 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, sum+arr[i]);
				visited[i] = false;
			}
		}
	}
}
