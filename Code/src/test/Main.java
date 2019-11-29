package test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		PriorityQueue<P> q = new PriorityQueue<>();

		q.add(new P(1, 5));
		q.add(new P(5, 6));
		q.add(new P(4, 3));
		q.add(new P(4, 5));
		q.add(new P(3, 8));
		q.add(new P(3, 9));
		q.add(new P(2, 10));
		q.add(new P(1, 3));
		q.add(new P(4, 2));

		while(!q.isEmpty()) {
			P p = q.poll();

			System.out.println(p.x + " " + p.y);
		}
	}
}

class P implements Comparable<P> {
	int x; int y;
	P(int x, int y) { 
		this.x = x; this.y = y;
	}

	@Override
	public int compareTo(P o) {
		if(this.x > o.x) {
			return 1;
		} else if(this.x == o.x) {
			if(this.y > o.y) return 1;
			return -1;
		} 
		return -1;

	}

}