package test;

public class SimpleProblem {
	//1.이진검색
	public int binarySearch(int [] arr, int low, int high, int key) {
		if(low > high) return -1;

		int mid = (low+high) / 2;

		if(arr[mid] == key) return mid;
		else if(arr[mid] < key) return binarySearch(arr, mid+1, high, key);
		else return binarySearch(arr, low, mid-1, key);
	}

	//2-1.약수찾기
	public void printDivisor(int value) {
		for(int i=1 ; i<=Math.sqrt(value) ; i++) {
			if(value % i == 0) {
				if(i*i == value) System.out.print(i + " ");
				else System.out.print(i + " " + value/i + " ");
			}
		
		System.out.println();
		}
	}

	//2-2.약수개수 구하기
	public void countDivisor() {
		int [] count = new int[10000+1];
		for(int i=1 ; i<=100 ; i++) {
			for(int j=1 ; j<=100 ; j++)
				count[i*j]++;
		}
		System.out.println(count[4] + " " + count[100] + " " + count[201] + " " + count[204]);
	}

	//2-3.완전수 구하기(자기 자신을 제외한 약수들의 합 = 자기자신)
	public void perfectNumber(int val) {
		int sum = 0;		
		for(int j=1 ; j<=Math.sqrt(val) ; j++) {
			if(val%j == 0) {
				if(j*j == val) sum += j;
				else sum += val/j + j;
			}
		}

		if(val*2 == sum) System.out.println(val + " is Perfect Number");
		else System.out.println(val + " is NOT Perfect Number");
	}
	
	//3. 소수 체크하기(배수 활용)
	public void primeNumberCheck() {
		boolean [] isNotPrime = new boolean[1000+1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for(int i=2 ; i<=1000 ; i++) {
			if(isNotPrime[i]) continue;
			
			for(int j=2 ; j*i<=1000 ; j++) {
				isNotPrime[i*j] = true;
			}
		}
		
		System.out.println("101 소수입니다. " + isNotPrime[101]);
		System.out.println("102 소수입니다. " + isNotPrime[102]);
	}
	
	//4. 팩토리얼 게산(메모리제이션 활용)
	public void factorial(int num) {
		int [] fact = new int[num+1];
		fact[0] = 1;
		
		for(int i=1 ; i<=num ; i++)
			fact[i] = fact[i-1] * i;
		
		System.out.println(fact[num] + " " + fact[num-1] + " " + fact[num-2]);
	}
	
	//5. 피보나치 수열(메모리제이션 활용)
	public void fibonachi(int num) {
		int [] fibo = new int[num+1];
		
		if(num == 0) System.out.println(0);
		else if(num == 1) System.out.println(1);
		else {
			fibo[0] = 0;
			fibo[1] = 1;
			
			for(int i=2 ; i<=num ; i++) 
				fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[num] + " " + fibo[num-1] + " " + fibo[num-2]);
	}
	
	//6. 하노이 
	public void hanoi(int n, int from, int by, int to) {
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

	public void move(int a, int b) {
		System.out.println(a + " -> " + b);
	}
}
