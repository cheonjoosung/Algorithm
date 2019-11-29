package kakao.test;

import java.util.Arrays;

public class Easy {
	public static int getStrToInt(String str) {
		if( (str.charAt(0)+"").equals("-") ) {
			int k = Integer.parseInt(str.substring(1, str.length()));
			return -k;
		} else {
			int k = Integer.parseInt(str);
			return k;
		}
	}

	public static int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];

		int tempB = b;
		int tempA = a;
		int gcd = 0;
		int lcd = 0;

		while(tempB != 0){
			int temp = tempB;
			tempB = tempA % tempB;
			tempA = temp;
		}
		gcd = tempA;
		lcd = (a * b) / gcd;

		answer[0] = gcd;
		answer[1] = lcd;

		return answer;
	}

	public static int sumDivisor(int num) {
		int answer = 0;

		for(int i=1 ; i*i <= num ; i++) {
			if(num % i == 0) {
				answer += i;
				answer += (num / i);
			}
		}


		return answer;
	}

	public static String watermelon(int n){
		String res = "";

		for(int i=0 ; i< n/2 ; i++) {
			res += "수박";
		}
		if(n % 2 != 0) 
			res += "수";

		return res;
	}

	public static String getMiddle(String word){

		if(word.length() % 2 == 0) {
			return word.substring(word.length()/2-1, word.length()/2+1);    			
		} else {
			return word.substring(word.length()/2, word.length()/2+1); 
		}
	}

	public int getMean(int[] array) {
		int sum = 0;
		for(int i=0 ; i<array.length ; i++) {
			sum += array[i];
		}
		return sum/array.length;
	}
	//"1 2 3 4"라면 "1 4
	public static String getMinMaxString(String str) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		String[] s = str.split(" ");
		for(int i=0 ; i<s.length ; i++) {
			int num = Integer.parseInt(s[i]);
			if(num < min) min = num;
			if(num > max) max = num;
		}

		return min + " " + max;
	}

	public static String reverseStr(String str){
		char [] c = new char[str.length()];
		for(int i=0; i<str.length() ; i++) {
			c[i] = str.charAt(i);
		}
		Arrays.sort(c);
		
		String res = "";
		for(int i=c.length-1 ; i>=0 ; i--) {
			res += c[i];
		}
		return res;
	}
	
	public static long fibonacci(int num) {
		int [] dp = new int[num+1];
		dp[1] =1;
		if(num == 0) return 0;
		else if(num == 1) return 1;
		else {
			dp[0] = 0; dp[1] = 1;
			for(int i=2; i <= num ; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		
		return dp[num];
	}
	
	public static int[] divisible(int[] array, int divisor) {
		//ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
		int count = 0;
		for(int i=0; i<array.length ; i++) {
			if(array[i] % divisor == 0) count++;
		}
		
		int[] ret = new int[count];
		
		int start = 0;
		for(int i=0; i<array.length ; i++) {
			if(array[i] % divisor == 0) {
				ret[start++] = array[i];
			}
		}
		
		return ret;
	}
	
	public static String findKim(String[] seoul){
		//x에 김서방의 위치를 저장하세요.
		int x = 0;

		for(int i=0 ; i<seoul.length ; i++) {
			if(seoul[i].equals("Kim")) {
				return "김서방은 "+ i + "에 있다";
			}
		}
		
		return "김서방은 "+ x + "에 있다";
	}

	//아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String args[]) {
		System.out.println(getStrToInt("-1234"));
		System.out.println(gcdlcm(3, 12) + "");
		System.out.println(sumDivisor(24));
		System.out.println(watermelon(3) + " - " + watermelon(4));
		System.out.println(getMiddle("hir") + " - " + getMiddle("hire"));
		System.out.println(getMinMaxString("-1 1 2 3 4"));
		System.out.println(reverseStr("Zbcdefg"));
		System.out.println(fibonacci(1));
		System.out.println(divisible(new int[]{5, 9, 7, 10}, 5));
		System.out.println(findKim(new String[]{"Queen", "Tod","Kim"}));
	}
}
