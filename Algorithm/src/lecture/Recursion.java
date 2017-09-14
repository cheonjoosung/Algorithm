package lecture;

public class Recursion {
	public static void main(String[] args) {
		
		System.out.println(func1("Hello"));
		func2("Hello");
		System.out.println();
		func3("Hello");
		System.out.println();
		func4(15);
		System.out.println();
		
		System.out.println(search(new int[]{1, 2 ,3}, 2, 0, 3));
		System.out.println(max(new int[]{5, 2 ,3}, 0, 2));
		/*
		 * 암시적(implicit) 매개변수 -> 명시적(explicit) 매개변수 로 바꾸어
		 */
	}
	
	public static int max(int [] data, int begin, int end) {
		if(begin == end) 
			return data[begin];
		else
			return Math.max(data[begin], max(data,begin+1, end));
	}
	
	public static int search(int [] data, int target, int begin, int end) {
		if(begin > end) 
			return -1;
		else if(target == data[begin])
			return begin;
		else
			return search(data, target, begin+1, end);
	}
		
	public static int func1(String str) {
		if(str.equals("")) 
			return 0;
		else 
			return 1 + func1(str.substring(1));
	}
	
	public static void func2(String str) {
		if(str.length() == 0) 
			return;
		else
			System.out.print(str.charAt(0));
			func2(str.substring(1));
	}
	
	public static void func3(String str) {
		if(str.length() == 0)
			return;
		else {
			func3(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
	
	public static void func4(int n) {
		if(n < 2) 
			System.out.print(n);
		else {
			func4(n/2);
			System.out.print(n%2);
		}
	}
	
	public static int func5(int n, int [] data) {
		if(n <= 0) 
			return 0;
		else 
			return func5(n-1, data) + data[n-1];
	}
	
}
