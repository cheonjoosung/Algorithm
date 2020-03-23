package samsung.sw_expert.d3;

import java.util.Scanner;

//최대 상금  
public class P1244 {   
	static int cnt;
	static int ans;
	static boolean[][] visited;

	static void dfs(int depth, String str) {
		visited[depth][Integer.parseInt(str)] = true;
		if(depth==cnt) {
			ans = Math.max(ans, Integer.parseInt(str));
			return;
		}

		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<str.length(); j++) {

				String tmp = str.substring(0,i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i) + str.substring(j+1, str.length());

				if(!visited[depth+1][Integer.parseInt(tmp)])
					dfs(depth+1, tmp);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tn = sc.nextInt();
		for(int t=1; t<=tn; t++) {
			String str = sc.next();
			cnt = sc.nextInt();
			visited = new boolean[cnt+1][1000000];
			ans=0;
			dfs(0, str);
			System.out.println("#" + t + " " + ans);
		}

	}
}