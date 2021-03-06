package codeground;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol53 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			
			int n = sc.nextInt();
			
			ArrayList<P53> list = new ArrayList<>();
			
			for(int i=0 ; i<n ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				list.add(new P53(x, y));
			}
			
			double distance = 0;
			
			if( n % 2 != 0) {
				//짝수각형
				distance = getDistanceOdd(n , list);
			} else {
				//홀수각형
				distance = getDistanceEven(n , list);
			}

			System.out.println("Case #"+(test_case+1));
			System.out.printf("%.2f",distance);
			System.out.println();
		}
	}
	
	public static double getDistanceOdd(int n, ArrayList<P53> list) {
		/*
		 * 1. ax + by + c = 0 과 (x,y) 사이의 거리 = |ax + by + c| / (a*a + b*b);
		 * 2. (x1, y1) - (x2, y2)를 지나는 직선방정식 y - ( (y2-y1) / (x2-x1) ) x + ( ( (y2-y1) / (x2-x1) ) * x1 ) - y1 ) = 0
		 */
		double dist = Integer.MAX_VALUE;
		
		int first = (n / 2);
		int second = (first + 1) % n;
		
		for(int i=0 ; i<n ; i++) {
			//System.out.println(i + " " + first + " " + second);
			int x = list.get(i).getX();
			int y = list.get(i).getY();
			
			int x1 = list.get(first).getX();
			int y1 = list.get(first).getY();
			
			int x2 = list.get(second).getX();
			int y2 = list.get(second).getY();
			
			double a = 0;
			double b = 1;
			double c = y1;
			
			if(x1 != x2) {
				a = ( (y2-y1) / (x2-x1) ) * (-1);
				c = ( ( (y2-y1) / (x2-x1) ) * x1 ) - y1;
			}
			
			if(y1 == y2) {
				a = 0;
				b = 1;
				c = x1;
			}
			if(x1 == x2) {
				a = 1;
				b = 0;
				c = y1;
			}
			
	
			double up = Math.abs(a*x + b*y + c);
			double down = Math.sqrt(a*a + b*b);
			double result = 0;
			
			if(down == 0 || up == 0) {
				result = 0;
			} else {
				result = up / down;
			}
					
			//System.out.println(x + " , " + y);
			//System.out.println(a + " , " + b + " , " + c);
			//System.out.println(up + " , " + down + " : " + result);
			if(result != 0) 
				dist = Math.min(dist, result);
			
			first = (first + 1) % n;
			second = (second + 1) % n;
		}
		return dist;
	}
	
	public static double getDistanceEven(int n, ArrayList<P53> list) {
		return 0;
	}
}

class P53 {
	int x;
	int y;
	
	P53(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return this.x;
	}
	
	int getY() {
		return this.y;
	}
}