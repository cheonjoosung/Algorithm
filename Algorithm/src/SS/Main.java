package SS;

import java.util.*;

public class Main {
	static int n, m, min = Integer.MAX_VALUE;
	static int [][] map;

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<PP> list = new ArrayList<>();
		
		list.add(new PP(5));
		list.add(new PP(55));
		list.add(new PP(4));
		list.add(new PP(3));
		list.add(new PP(999));
		list.add(new PP(1));
		
		Collections.sort(list);
		
		for(PP p :list)
			System.out.println(p.x);

		sc.close();
	}
}

class PP implements Comparable<PP>{
	int x;
	PP(int x) { this.x = x; }
	
	@Override
	public int compareTo(PP o) {
		return this.x - o.x;
	}
	
}

