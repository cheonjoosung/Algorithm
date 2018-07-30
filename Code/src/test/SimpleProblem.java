package test;

import data_structure.Sort;

public class SimpleProblem {
	public static char [] val = {'a', 'b', 'c', 'e', 'd', 'k'};
	public static boolean [] isNotPrime = new boolean[101];
	public static long [] fact = new long[11];
	public static int [] arr = {1, 3, 5, 19, 24, 155};
	public static int [] fibo;


	public static void main(String[] args) {
		int [] a = {3, 10, 5, 1, 155, 24};
		int [] temp = new int[a.length];
		
		
		Sort s = new Sort();
		s.mergeSorting(a, temp, 0, a.length-1);
		for(int val : a) System.out.print(val + " ");
	}

	public static void findDivisor(int num) { // 약수 갯수 구하기..
		int cnt = 0;
		for(int i=1 ; i <= Math.abs(num) ; i++) {
			if(num % i == 0) cnt++; // list.add(i) && list.add(num/i)
			if(i * i < num) cnt++; //
		}
		
		int [] count = new int[10000+1];
		for(int i=1 ; i <= 10000 ; i++) {
			for(int j=1 ; j <= 10000 ; j++) 
				count[i*j]++;
			//10의 약수 = 1,2,5,10
			//1의 배수 = 1*10 , 2의 배수 = 2*5, 5의 배수 = 5*2, 10의 배수 = 10*1 다 10포함
		}
		
		for(int i=1 ; i*i <= num ; i++) {
			if(num % i == 0) {
				//list.add(i);
				//list.add(num/i);
			}
		}
		
	}

	public static void hanoi(int n, int from, int by, int to) {
		if(n == 1) move(from, to);
		else {
			hanoi(n-1, from, to, by);
			move(from, to);
			hanoi(n-1, by, from, to);
			/*
			 * 2^n - 1 만큼 이동
			 * 1. 기둥 1에서 n-1 개의 원판을 기둥 3를 이용하여 기둥 2로 옮긴다.
			 * 2. 기둥 1에서 남은 1개의 원판을 기둥 3으로 옮긴다.
			 * 3. 기둥 2에서 n-1 개의 원판을 기둥 1을 이용하여 기둥 3으로 옮긴다.  
			 */
		}
	}

	public static void move(int a, int b) {
		System.out.println(a + " -> " + b);
	}

	public static void fibo(int num) {
		fibo = new int[num+1];

		if(num == 0) System.out.println(0);
		else if(num == 1) System.out.println(1);
		else {
			fibo[0] = 0;
			fibo[1] = 1;

			for(int i=2 ; i<=num ; i++)
				fibo[i] = fibo[i-1] + fibo[i-2];
		}
	}

	public static int binarSearch(int num, int low, int high) { //정렬이 되어 있어야 함. 
		if(low >= high) return -1;

		int mid = (low+high) / 2;

		if(num < arr[mid]) return binarSearch(num, low, mid-1);
		else if(num == arr[mid]) return mid;
		else return binarSearch(num, mid+1, high);
	}

	public static void reverseString(char [] arr) {
		int size = arr.length;

		for(int i=0 ; i<size/2 ; i++) {
			char tmp = arr[i];
			arr[i] = arr[size - 1 - i];
			arr[size - 1 - i] = tmp;
		}
	}

	public static StringBuilder reverseString2(char [] arr) {
		StringBuilder temp = new StringBuilder();
		int size = arr.length;

		for(int i=0 ; i<size ; i++) 
			temp.append(arr[size-1-i]);

		return temp;
	}

	public static void checkPrime() {
		for(int i=2 ; i<isNotPrime.length ; i++) { 
			if(isNotPrime[i]) continue;
			for(int j=i ; j*i < isNotPrime.length ; j++) {
				isNotPrime[i*j] = true;
			}
		}
	}

	public static void calcFactorial() {
		fact[0] = 1;

		for(int i=1 ; i<fact.length ; i++)
			fact[i] = fact[i-1] * i;
	}
}
