package samsung.last;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int [] d = {1000, 100, 10, 1};
	static boolean [] isNotPrime = new boolean[10000];
	static private boolean[] discovered = new boolean[10000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		findPrimeNum();

		int testCase = sc.nextInt();

		for(int i=0 ; i<testCase ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if(a== b) System.out.println(0);
			else System.out.println(bfs(a , b));	
		}

		sc.close();
	}

	public static int bfs(int res, int dest) {
		discovered = new boolean[10000];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(res);
		discovered[res] = true;
		
		int step = -1;
		
		while(!q.isEmpty()) {
			step++;
			
			int size = q.size();
			
			for(int i=0 ; i<size ; i++) {
				int u = q.poll();
				
				if(u == dest) return step;
				
				//자리수 분할
				int[] cipher = new int[4];
				for(int j=0 ; j<4 ; j++) {
					cipher[j] =  u / d[j];
					u %= d[j];
				}
				
				//탐색 
				for(int j=0 ; j<4 ; j++) {
					for(int k=0 ; k<10 ; k++) {
						cipher[j] = cipher[j] + 1 > 9 ? 0 : cipher[j] + 1;
						
						int nextNum = 0;
						
						for(int l = 0; l<4 ; l++) {
							nextNum += cipher[l] * d[l];
						}
						
						if(nextNum < 1000 || discovered[nextNum] || isNotPrime[nextNum]) continue;
						
						q.add(nextNum);
						discovered[nextNum] = true;
					}
				}
			}
		}
		return -1;
	}

	public static void findPrimeNum() {
		for (int i = 2; i < 10000; i++) {
			if (isNotPrime[i]) continue;

			for (int j = 2; i * j < 10000; j++) isNotPrime[i * j] = true;
		}
	}
}
