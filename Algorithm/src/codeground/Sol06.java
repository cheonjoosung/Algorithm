package codeground;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol06 {
	static int Answer;
	static long sum;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int n = sc.nextInt();
			int count = sc.nextInt();

			String res = sc.next();
			
			sum = 1 + n*n;
			
			ArrayList<P> list = new ArrayList<>();
			list.add(new P(0,0));
			int x = 0, y = 0;
			
			for(int i=0; i<res.length() ; i++) {
				if(res.charAt(i) == 'D') {
					y++;
					list.add(new P(x,y));
				} else if(res.charAt(i) == 'U') { 
					y--;
					list.add(new P(x,y));
				} else if(res.charAt(i) == 'L') {
					x--;
					list.add(new P(x,y));
				} else {
					x++;
					list.add(new P(x,y));
				}
			}
			
			long temp = 0;
			
			for(P p : list) {
				long val = 0;
				
				if( (p.x + p.y) % 2 == 0) {
					int k = 0;
					
					if(p.x + p.y > (n-1) ) {
						p.x = n - 1 - p.x;
						p.y = n - 1 - p.y;
						k = 1;
					}
					
					if(p.x + p.y == 0) val = 1;
					else val = 1 + (p.x+p.y)/2 + getSum( (p.x + p.y) /2 , 4, 4);
					
					if(k == 1) {
						temp += sum - (val - p.y);
					} else {
						temp += val - p.y;						
					}
					//System.out.println("AA : " + p.x + " " + p.y + " , " + temp + " " + (val-p.y));
				} else {
					int k = 0;
					
					if(p.x + p.y > (n-1) ) {
						p.x = n - 1 - p.x;
						p.y = n - 1 - p.y;
						k = 1;
					}
					
					if(p.x + p.y == 1) val = 2;
					else val = 1 + (p.x+p.y + 1) / 2 + getSum( (p.x+p.y)/2 , 4 , 4 );
					
					if(k == 1) {
						temp += sum - (val + p.y);
					} else {
						temp += val + p.y;
					}
					//System.out.println("BB : " + p.x + " " + p.y + " , " + temp + " " + (val+p.y));
				}
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(temp);
		}
		
		sc.close();
	}
	
	public static int getSum(int n, int a, int d) {
		return (n * (2*a + (n-1)*d))/2;
	}
}

class P {
	int x;
	int y;
	
	P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
