package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Test {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int numLine = sc.nextInt();
			
			ArrayList<Point2> list = new ArrayList<>();
			
			long minX = 100_000_001;
			long maxX = -1;
			long minY = 100_000_001;
			long maxY = -1;
			
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
			
			long minXTemp = 999999999;
			long minYTemp = 999999999;
			
			for(int i=0 ; i < list.size() ; i++) {
				long fx1 = list.get(i).x1;
				long fx2 = list.get(i).x2;
				
				if(fx1 == minX || fx2 == maxX) continue;
				
				for(int j=0 ; j < list.size() ; j++) {
					if(i == j) continue;
				
					long sx1 = list.get(j).x1;
					long sx2 = list.get(j).x2;
					
					if(sx2 > maxX) {
						if(fx1 > minX) continue;
					} else {
						
					}
				}
			}
			
			/*
			for(Point2 p : list) {
				long fx = p.x1;
				long fy = p.y1;
				
				long sx = p.x2;
				long sy = p.y2;
				
				if(sx < maxX) {
					minXTemp = Math.min(minXTemp, sx);
				} else if(sx == maxX) {
					minXTemp = Math.min(minXTemp, fx);
				} else {
					if(sx > maxX) {
						minXTemp = Math.min(minXTemp, fx);
					} 
				}
				
				if(sy < maxY) {
					minYTemp = Math.min(minYTemp, sy);
				} else if(sy == maxY) {
					minYTemp = Math.min(minYTemp, fy);
				} else {
					if(fy < maxY) {
						minYTemp = Math.min(minYTemp, fy);
					}
				}
			}*/
			
			minX = minXTemp;
			minY = minYTemp;
			
			//System.out.println(minX + " , " + minY + " , " + maxX + " , " + maxY);
			
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