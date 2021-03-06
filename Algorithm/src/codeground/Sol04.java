package codeground;

import java.util.Scanner;

//4번 다트문제 
public class Sol04 {
	static int Answer;
	static int [] radious;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		//System.out.println(getAngle(0, 1) + " " + getAngle(1,-1) + " " + getAngle(-1,1));
		
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			
			radious = new int[5];
			
			for(int i=0 ; i<5 ; i++) 
				radious[i] = sc.nextInt();
			
			int dartCount = sc.nextInt();
			
			for(int i=0 ; i< dartCount ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				double distance = getDistance(x, y);
				double degree = getAngle(x, y);
				
				int score = calScore(distance, degree);
				Answer += score;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
		sc.close();
	}
	
	public static int calScore(double distance, double degree) {
		int point = getScore(degree);
		
		//System.out.println(point + " " + degree);
		
		if(distance <= radious[0]) {
			return 50;
		} else if( (distance > radious[0] && distance < radious[1] )
				|| ( distance > radious[2] && distance < radious[3] ) ){
			return point;
		} else if(distance >= radious[1] && distance <= radious[2]) { 
			return point*3;
		} else if(distance >= radious[3] && distance <= radious[4]) {
			return point*2;
		} else {
			return 0;
		}
	}
	
	public static double getAngle(int x, int y) {
		double rad = Math.atan2(y, x);
		double degree = (rad*180) / Math.PI;
		
		return degree;
	}
	
	public static double getDistance(int x, int y) {
		return Math.sqrt(x*x + y*y);
	}
	
	public static int getScore(double tan) {
		if( (tan >= 0 && tan < 9) || (tan >= -9 && tan <= 0) ) {
			return 6;
		} else if(tan >= 9 && tan < 27) {
			return 13;
		} else if(tan >= 27 && tan < 45) {
			return 4;
		} else if(tan >= 45 && tan < 63) {
			return 18;
		} else if(tan >= 63 && tan < 81) {
			return 1;
		} else if(tan >= 81 && tan < 99) {
			return 20;
		} else if(tan >= 99 && tan < 117) {
			return 5;
		} else if(tan >= 117 && tan < 135) {
			return 12;
		} else if(tan >= 135 && tan < 153) {
			return 9;
		} else if(tan >= 153 && tan < 171) {
			return 14;
		} else if((tan >= 171 && tan <= 180) || (tan >= -180 && tan < -171) ) {
			return 11;
		} else if(tan >= -171 && tan < -153) {
			return 8;
		} else if(tan >= -153 && tan < -135) {
			return 16;
		} else if(tan >= -135 && tan < -117) {
			return 7;
		} else if(tan >= -117 && tan < -99) {
			return 19;
		} else if(tan >= -99 && tan < -81) {
			return 3;
		} else if(tan >= -81 && tan < -63) {
			return 17;
		} else if(tan >= -63 && tan < -45) {
			return 2;
		} else if(tan >= -45 && tan < -27) {
			return 15;
		} else if(tan >= -27 && tan < -9) {
			return 10;
		} else {
			return -1;
		}
	}
}
