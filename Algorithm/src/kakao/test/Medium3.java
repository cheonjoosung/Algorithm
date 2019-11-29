package kakao.test;

public class Medium3 {
	public static String change124(int n) {
		String answer = "";
		
		while(n != 0) {
			if( (n-1) % 3 == 0) {
				answer = "1" + answer;
				n = (n-1) / 3;
			} else if( (n-2) % 3 == 0) {
				answer = "2" + answer;
				n = (n-2) / 3;
			} else if( (n-3) % 3 == 0) {
				answer = "4" + answer;
				n = (n-3) / 3 ;
			}
		}

		return answer;
	}
	
	public static int[] setAlign(int n, long k) {
		int[] answer = {};

		for(int i=0; i<n ; i++) {
			
		}
		
		return answer;
	}
	
	public static int tiling(int n) {
		int answer = 0;

		return answer;
	}
	
	public static int[][] hanoi(int n) {
		// 2차원 배열을 완성해 주세요.
		int[][] answer = null;

		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(change124(10));
		System.out.println(setAlign(3, 5));
		System.out.println(tiling(2));
		System.out.println(hanoi(2));
	}
}
