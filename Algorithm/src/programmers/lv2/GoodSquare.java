package programmers.lv2;

public class GoodSquare {
	public long solution(int w,int h) {
		long answer = 0;
		
		double lean = (double)h/w;
		
		for(int i=1 ; i<w ; i++) {
			double temp = lean * i;
			
			int ceilVal = (int) Math.ceil(temp);			
			answer += h - ceilVal;
			
			//System.out.println(ceilVal + " " + (h-ceilVal));
			
		}
		
		return answer * 2;
	}
}
