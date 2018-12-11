package test;

import data_structure.*;

public class Main {
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
		
		String s = new String("abcABC");
		char [] charArr = s.toCharArray();
		System.out.println(new String(charArr));
	}
}
