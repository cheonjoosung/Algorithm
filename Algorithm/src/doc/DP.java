package doc;

public class DP {
	public static void main(String[] args) {
		//System.out.println(getFibonachi1(3));
		//System.out.println(getFibonachi2(3));
		
		//System.out.println(getFactorial1(15));
		//System.out.println(getFactorial2(15));
		
		String [] x = {"A", "B" ,"C", "B", "D", "A", "B"};
		String [] y = {"B", "D", "C", "A", "B", "D"};
		
		
		//System.out.println(LCSLength(x, y, 0, 0, ));
		long a = 3/2;
		System.out.println(a);
	}
	
	public static int getFibonachi1(int n) { // 시간복잡도 n // 공간복잡도 n 배
		int [] fib = new int[n+1];
		if(n == 1) return 1;
		if(n == 2) return 2;
		if( fib[n] != 0) return fib[n];
		return fib[n] = getFibonachi1(n-1) + getFibonachi1(n-2);
	}
	
	public static int getFibonachi2(int n) { // 시간복잡도 n // 공간복잡도 1
		int sum = 0, a = 0, b = 1; //a : n, b : n+1
		
		for(int i=0; i<n ; i++) {
			sum = a+b;
			a = b;
			b = sum;
		}
		
		return sum;
	}
	
	public static int getFactorial1(int n) { // 시간복잡도 n // 공간복잡도 n 스
		if( n == 0 || n == 1) return 1;
		return n * getFactorial1(n-1);
	}
	
	public static int getFactorial2(int n) { // 시간복잡도 n보다 작 // 공간복잡도 n 보다 작
		int [] fact = new int[n+1];
		if( n == 0 || n == 1) return 1;
		if( fact[n] != 0 ) return fact[n];
		return n * getFactorial1(n-1);
	}
	
	public static int LCSLength(String [] x, String [] y, int i, int j) {
		if(x.length == 0 || y.length == 0) return 0;
		if(x[i].equals(y[j])) {
			System.out.println(i + " , " + j);
			return (1 + LCSLength(x, y, i+1, j+1));
		}
		return Math.max( LCSLength(x, y, i, j+1), LCSLength(x, y, i+1, j) );
	}
}
