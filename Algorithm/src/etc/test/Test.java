package etc.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {		
		SimpleProblem sp = new SimpleProblem();
		int [] arr = {1, 3, 5, 19, 24, 155};
		System.out.println(sp.binarySearch(arr, 0, arr.length-1, 155));
		sp.printDivisor(99);
		sp.countDivisor();
		sp.perfectNumber(6);
		sp.primeNumberCheck();
		sp.factorial(6);
		sp.fibonachi(10);
		sp.hanoi(3, 1, 2, 3);
		
		Sort sort = new Sort();
		sort.bubbleSort();
		sort.selectSort();
		sort.insertSort();
		int [] a = { 15, 1, 1, 3, 8, 5, 4};
		sort.quickSort(a, 0, a.length-1);
		sort.print(a);
		int [] b = {15, 1, 1, 3, 8, 5, 4};
		int [] temp = new int[b.length];
		sort.mergeSort(b, temp, 0, b.length-1);
		sort.print(b);
		
		StringProblem stp = new StringProblem();
		StringBuilder sb = new StringBuilder("ABCab");
		System.out.println(stp.reverseString(sb));
		System.out.println(stp.reverseString2(sb));
		System.out.println(stp.reverseString3(sb));
		stp.lcs("abcd", "abbdddacd");
		
//		B a1 = (B) new A();
//		a1.run();
//		a1.siren();
		
		
		B b1 = new B();
		b1.siren();
		b1.run();
		
		A a2 = new B();
		a2.run();
		((B)a2).siren();
	}
}

class A {	
	public A() {
		System.out.println("부모 호출");
	}
	public void run() { 
		System.out.println("A : RUN()"); 
	}
}

class B extends A {
	public B() {
		System.out.println("자식 호출");
	}
	
	public void siren() { 
		System.out.println("B : SIREN()");
	}
}
