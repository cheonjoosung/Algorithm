package etc.test;

public class Main {
	int val = 4;
	static int staticVal = 4;
	public static void main(String[] args) {
		/*PriorityQueue<P> q = new PriorityQueue<>();

		q.add(new P(1, 5));
		q.add(new P(5, 6));
		q.add(new P(4, 3));
		q.add(new P(4, 5));
		q.add(new P(3, 8));
		q.add(new P(3, 9));
		q.add(new P(2, 10));
		q.add(new P(1, 3));
		q.add(new P(4, 2));

		while(!q.isEmpty()) {
			P p = q.poll();

			System.out.println(p.x + " " + p.y);
		}
		
		Son s = new Son(4);
		
		Father a = new Son();
		System.out.println(a.f4() + " " + s.f4());
		
		int [][] arr = { {0}, {1,2}, {1,2,3} };
		
		System.out.println(arr.length + " " + arr[1].length + " " + arr[2].length);
		*/
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		
		char[] charArray = a.toCharArray();
		
		for(int i=0 ; i<charArray.length/2 ; i++) {
			char temp = charArray[i];
			charArray[i] = charArray[charArray.length-1-i];
			charArray[charArray.length-1-i] = temp;
		}
		for(char v : charArray)
				System.out.println(v);
		
		
		StringBuilder sb = new StringBuilder("str");
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("str");
		sb2.append("bcd");
		
		sb.toString();
	}
	
	public static void change(String k) {
		
	}
	
	public static void test() {
		try {
			System.out.println("Test");
			System.exit(0);
		} catch( Exception e) {
			System.out.println("BYE");
		} finally {
			System.out.println("HI");
		}
		System.out.println("END");
	}
}


class Father {
	static int k = 4;
	
	Father() {
		this.k++;
		System.out.println("Fahter 생성자 호출!");
	}
	
	Father(int k) {
		System.out.println("Father(int val) 생성자 호출!");
	}
	int f1(int a, int b) {
		return a+b;
	}
	
	int f2(int a, int b) {
		System.out.println("SW");
		return a-b;
	}
	
	int f3(int a, int b) {
		return a*b;
	}
	
	int f4() {
		return 1;
	}
}

class Son extends Father {
	Son() {
		System.out.println("Son 생성자 호출!");
	}
	
	Son(int k) {
		System.out.println("Hi");
	}
	int f1(int a, int b) {
		return a%b;
	}
	
	double f2(double a, double b) {
		System.out.println("HE");
		return a*b;
	}
	
	int f3(int a, int b) {
		return a/b;
	}
	
	int f4() {
		return 3;
	}
}

class SonOfSon extends Son {
	public SonOfSon() {
		System.out.println("SonOfSon 생성자 호출!");
	}
}

class P implements Comparable<P> {
	int x; int y;
	P(int x, int y) { 
		this.x = x; this.y = y;
	}

	@Override
	public int compareTo(P o) {
		if(this.x > o.x) {
			return 1;
		} else if(this.x == o.x) {
			if(this.y > o.y) return 1;
			return -1;
		} 
		return -1;

	}

}

interface Test1 {
	void func();
}

abstract class Test2 {
	abstract void func();
}

