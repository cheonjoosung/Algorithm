package codeground;

import java.util.ArrayList;
import java.util.Scanner;

//CodeGround 14번 회로판위의 배터리
public class Sol14 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int numLine = sc.nextInt();
			
			ArrayList<Point2> list = new ArrayList<>();
			
			double minX = 100_000_001;
			double maxX = -1;
			double minY = 100_000_001;
			double maxY = -1;
			
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
			/*
			 * maxX 와 maxY 는 기준이 되었지만 minX 와 minY 는 아니다. 제일 작은점을 뽑은 것이지만 maxX 와 maxY에 가까운점이라고는 보장할 수 없다.
			 * 0 0 5 0 / 2 0 16 0 / 3 0 4 0 / 10 0 10 4 를 하면 0 과 10이 뽑혀 5가 나오지만 거리를 4로 더 줄일 수가 있다.
			 */	
			
			double a = 0;
			double b = 0;
			
			System.out.println(minX + " , " + minY + " , " + maxX + " , " + maxY);
			
			double max = Math.max((double)maxX - (double)minX, (double)maxY - (double)minY);
			/*
			double x = (minX+maxX) / 2;
			double y = (minY+maxY) / 2;
			
			double max = -1;
			
			for(Point2 p : list) {
				long fx = p.x1;
				long fy = p.y1;
				
				long sx = p.x2;
				long sy = p.y2;
				
				long a = (long) (Math.pow(fx-x, 2) + Math.pow(fy-y, 2));
				long b = (long) (Math.pow(sx-x, 2) + Math.pow(sy-y, 2));
				
				double val = 0;
				if(a <= b) {
					val = Math.max(Math.abs(fx-x), Math.abs(fy-y));
				} else {
					val = Math.max(Math.abs(sx-x), Math.abs(sy-y));
				}
				
				//System.out.print(fx + " " + fy + " " + sx + " " + sy + " = " + val + "\n");
				max = Math.max(max, val);
				
			}*/
			max /= 2;
			
			if(max - Math.floor(max) == 0) {
				System.out.println("Case #"+(test_case+1));
				System.out.println((long)max);
			} else {
				System.out.println("Case #"+(test_case+1));
				System.out.println(max);
			}
			
		}
	}

}

class Point2 implements Comparable<Point2>{
	long x1;
	long y1;
	
	long x2;
	long y2;
	
	public Point2(long x1, long y1, long x2, long y2){
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
