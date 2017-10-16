package SS;

import java.util.ArrayList;
import java.util.Scanner;

public class Snake10875 {
	static long Ans;
	static int Left = 0;
	static int Up = 1;
	static int Right = 2;
	static int Down = 3;
	
	static int INF = 900_000_009;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int moveCount = sc.nextInt();
		
		int curDir = 1;
		int curX = n;
		int curY = n;
		int size = 2*n + 1;
		Ans = 0l;
		
		ArrayList<P10875> list = new ArrayList<>();
		
		
		for(int i=0 ; i<moveCount ; i++) {
			int move = sc.nextInt();
			int dir = (sc.next().equals("L") ? 0 : 1);
			list.add(new P10875(move, dir));
		}
		
		for(int i=0 ; i < list.size() ; i++) {
			System.out.println(list.get(i).dir + " " + list.get(i).move);
		}
		
		
		
		
		System.out.println(Ans);
		
		sc.close();
	}
}

class P10875{
	int move;
	int dir;
	
	public P10875(int move, int dir) {
		this.move = move;
		this.dir = dir;
	}
}
