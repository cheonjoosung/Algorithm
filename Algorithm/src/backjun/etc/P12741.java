package backjun.etc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12741 {
	static boolean [] visitied;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int powA = sc.nextInt();
		int powB = sc.nextInt();
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();

		visitied = new boolean[100001];
		Arrays.fill(visitied, false);

		//+1, -1, cur*A, cur*B, +A, +B, -A, -B 8가지의 무빙방식이 존재
		bfs(powA, powB, p1, p2);
		sc.close();
	}

	public static void bfs(int powA, int powB, int p1, int p2) {
		int count = 0;
		boolean isExit = false;
		Queue<Integer> q = new LinkedList<>();
		visitied[p1] = true;

		q.add(p1);

		while(!q.isEmpty() && !isExit) {
			int size = q.size();

			while(size > 0 && !isExit) {
				int pos = q.poll();

				if(pos == p2) {
					System.out.println(count);
					isExit = true;
					break;
				}
				int [] next = {1 , -1, powA, -powA, powB, -powB, pos*powA, pos*powB};

				for(int i=0; i<8 ; i++) {
					int nextPos = 0;
					if(i <= 5) nextPos = pos + next[i];
					else nextPos = next[i];

					if(nextPos < 0 || nextPos > 100000) continue;
					if(visitied[nextPos]) continue;
					q.offer(nextPos);
					visitied[nextPos] = true;
				}
				if(isExit) break;
				size--;
			}
			if(isExit) break;
			count++;
		}
	}
}
