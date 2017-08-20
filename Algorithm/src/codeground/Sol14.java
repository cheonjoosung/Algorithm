package codeground;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol14 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int numLine = sc.nextInt();
			
			ArrayList<Point2> list = new ArrayList<>();
			
			int minX = 100_000_001;
			int maxX = -1;
			int minY = 100_000_001;
			int maxY = -1;
			
			for(int i = 0 ; i < numLine ; i++) {
				int fx = sc.nextInt();
				int fy = sc.nextInt();
				
				int sx = sc.nextInt();
				int sy = sc.nextInt();
				
				fx = Math.min(fx, sx);
				fy = Math.min(fy, sy);
				sx = Math.max(fx, sx);
				sy = Math.min(fy, sy);
				
				if(minX > fx) minX = fx;
				if(maxX < fx) maxX = fx;
				if(minY > fy) minY = fy;
				if(maxY < fy) maxY = fy;
				
				list.add(new Point2(fx, fy, sx, sy));
			}
			
			System.out.println(minX + " " + maxX + " " + " " + minY + " " + maxY);
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}

class Point2 implements Comparable<Point2>{
	int x1;
	int y1;
	
	int x2;
	int y2;
	
	public Point2(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public int compareTo(Point2 o) {
		if(this.x1 > o.x1){
			return 1;
		}else if(this.x1 == o.x1 && this.y1 > o.y1){
			return 1;
		}
		return -1;
	}
}
