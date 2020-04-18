package samsung.last;

import java.util.Scanner;

public class Vote_17779 {
	static int ANS, n, total;
	static int [][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		ANS = Integer.MAX_VALUE;
		
		arr = new int[n+2][n+2];
		
		for(int i=1 ; i<=n ; i++) 
			for(int j=1; j<=n ; j++) {
				arr[i][j] = sc.nextInt();
				total += arr[i][j];
			}
				
		int [] d = new int[2];
		
		for(int x=1 ; x<=n ; x++) {
			for(int y=1 ; y<=n ; y++) {
				dfs(0, d, x, y);				
			}
		}	
		
		System.out.println(ANS);
		sc.close();
	}
	
	public static void dfs(int cnt, int [] d, int x, int y) { 
		if(cnt == 2) {
			if(x+d[0]+d[1] <= n && y-d[0] >= 1 && y+d[1] <=n && y>1) {
				calc(d, x, y);
			}
			return;
		}
		
		for(int i=1 ; i<=n ; i++) {
			d[cnt] = i;
			dfs(cnt+1, d, x, y);
		}
	}
	
	public static void calc(int [] d, int x, int y) {
		int sum1 = 0; int sum2 = 0; int sum3 = 0; int sum4 = 0; int sum5 = 0;
	
		int temp = y;
		for(int r=1; r<x+d[0] ; r++) {
			if(r>=x) temp=temp-1;
			for(int c=temp ; c>=1 ; c--) {
				sum1 += arr[r][c];				
			}
		}
		//System.out.println("SUM1 : " + sum1);
		
		temp = y+1;
		for(int r=1; r<=x+d[1] ; r++) {
			if(r>x) temp++;
			for(int c=temp ; c<=n ; c++) {
				sum2 += arr[r][c];
			}
		}
		//System.out.println("SUM2 : " + sum2);
		
		temp = y-d[0];
		for(int r=x+d[0]; r<=n ; r++) {
			for(int c=1 ; c<Math.min(temp, y-d[0]+d[1]) ; c++) {
				sum3 += arr[r][c];
			}
			
			if(r < x+d[0]+d[1]) temp++;
		}
		//System.out.println("SUM3 : " + sum3);
		
		temp = y+d[1];
		for(int r=x+d[1]+1; r<=n ; r++) {
			for(int c=n ; c>=Math.max(temp, y-d[0]+d[1]) ; c--) {
				sum4 += arr[r][c];
			}
			
			if(r <= x+d[0]+d[1]) temp--;
		}
		//System.out.println("SUM4 : " + sum4);
		
		sum5 = total - (sum1+sum2+sum3+sum4);
		int max = Math.max(sum1, Math.max(sum2, Math.max(sum3, Math.max(sum4, sum5))));
		int min = Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, sum5))));
		
		ANS = Math.min(ANS, max - min);
	}
}
