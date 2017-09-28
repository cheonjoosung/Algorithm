package kakao;

import java.util.Arrays;

public class Easy2 {

	public static String getDayName(int a, int b) {//16.01.01 금
		String [] res = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int [] mon = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31 };

		int sum = 0;

		if(a == 1) {
			//System.out.println("a");
			sum += (b-1);
		} else {
			//System.out.println("A");
			for(int i=1 ; i< a ; i++) {
				sum += mon[i-1];
			}
			sum += (b-1);
		}

		//System.out.println("Sum : " + sum);
		int index = (sum % 7);
		//System.out.println("Index : " + index);

		return res[index];
	}
	
	public static int reverseInt(int n){
		String s = n+"";
		char [] c = new char[s.length()];
		
		for(int i=0; i<s.length() ; i++) {
			c[i] = s.charAt(i);
		}
		
		Arrays.sort(c);
		
		s = "";
		for(int i=c.length-1 ; i>=0 ; i--) {
			s += c[i];
		}
		
		return Integer.parseInt(s);
	}
	
	public static int numberOfPrime(int n) {
		int result = 0;
		
		for(int i=2 ; i<=n ; i++) {
			boolean isFound = false;
			for(int j=2 ; j<i ; j++) {
				if(j == i) continue;
				
				if(i % j ==0) {
					isFound = true;
				}
			}
			if(!isFound) result++;
		}

		return result;
	}
	
	public static int getMinSum(int []A, int []B)
    {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0 ; i<A.length ; i++) {
        	int sum = 0;
        	for(int j=0 ; j<B.length ; j++) {
        		sum += A[j] * B[(j + i) % B.length];
//        		System.out.println(j + " " + (j+i)%B.length);
        	}
        	if(sum < answer) answer = sum;
        }

        return answer;
    }
	
	public static boolean isHarshad(int num){
		int sum = 0;
		int temp = num;
		
		while(num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		
		if(temp % sum == 0) return true;
		else return false;
	}
	
	public static int collatz(int num) {
		int answer = 0;
		
		while(num != 1) {
			if(num % 2 == 0)  num /= 2;
			else num = num*3 +1;
			
			answer++;
			if(answer >= 500) return -1;
		}

		return answer;
	}
	
	public static long nlcm(int[] num) {
		long temp = num[0];
		for(int i=1; i<num.length ; i++) {
			
			temp = (temp * num[i]) / gcd(temp, num[i]);
		}
		return temp;
	}
	
	public static long gcd(long a, long b) {
		while(b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static int[][] productMatrix(int[][] A, int[][] B) {
		int[][] answer = new int[A.length][B[0].length];

		for(int i=0; i< answer.length ; i++) {
			for(int j=0; j< answer[0].length ; j++) {
				for(int k=0; k<A[0].length ; k++) {
					answer[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(getDayName(1, 31));
		System.out.println(reverseInt(118372));
		System.out.println(numberOfPrime(10));
        System.out.println(getMinSum(new int[]{1, 2, 3}, new int[]{3, 4, 5}));
        System.out.println(isHarshad(18));
        System.out.println(nlcm(new int[]{ 2, 6, 8, 14 }));
        System.out.println(
        		productMatrix(new int[][]{ { 1, 2 }, { 5, 3 } }, new int[][]{ { 3, 4 }, { 5, 6 } }));
	}
}
