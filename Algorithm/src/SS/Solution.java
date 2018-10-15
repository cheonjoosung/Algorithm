package SS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for(int i=1;i<=tc;i++) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			
			for(int j=0;j<n;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
			}
			sb.append("#"+i+" "+ ans +"\n");
		}        

		System.out.print(sb);
	}
	
	public static void solve() {
		
	}

}