package backjun.etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1963 {
	static boolean [] isNotPrime = new boolean[10000];
	static boolean [] discover = new boolean[10000];
	static int [] d = {1000, 100, 10, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		check();
		
		int testCase = sc.nextInt();

		for(int i=0 ; i<testCase ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if(a== b) System.out.println(0);
			else System.out.println(bfs(a , b));	
		}

		sc.close();
	}
	
	public static int bfs(int a, int b) {
		discover = new boolean[10000];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		discover[a] = true;
		
		int step = -1;
		
		while(!q.isEmpty()) {
			step++;
			int size = q.size();
			
			for(int j=0; j<size ; j++) {
				int u = q.poll();
				
				if(u == b) return step;
				
				int [] cipher = new int[4];
				
				for(int i=0 ; i<4 ; i++) {
					cipher[i] = u / d[i];
					u %= d[i];
				}
				
				for(int i=0 ; i<4 ; i++) {
					for(int k=0 ; k<10 ; k++) {
						cipher[i] = cipher[i] + 1 > 9 ? 0 : cipher[i]+1;
						
						int nextNum = 0;
						for(int l=0 ; l<4 ; l++) 
							nextNum += cipher[l] * d[l];
						
						if(nextNum < 1000 || nextNum > 9999) continue;
						if(discover[nextNum] || isNotPrime[nextNum]) continue;
						
						q.add(nextNum);
						discover[nextNum] = true;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void check() {
		for(int i=2 ; i<10000 ; i++) {
			if(isNotPrime[i]) continue;
			for(int j=2; i*j < 10000 ; j++) isNotPrime[j*i] = true;
		}
	}
}
