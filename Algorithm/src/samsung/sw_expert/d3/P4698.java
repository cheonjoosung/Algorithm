package samsung.sw_expert.d3;

import java.util.Scanner;

//테네스의 특별한 소수
public class P4698 {
	static long [] isNotPrime = new long[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		checkPrime();
		
		for(int t=1 ; t<=tc ; t++) {
			int n = sc.nextInt(); //소수중에 n를 포함한 수
			int down = sc.nextInt();
			int up = sc.nextInt();			
			
			int ans = 0;
			
			for(int i=down ; i<=up ; i++) {
				if(isNotPrime[i] == 0) {
					if(String.valueOf(i).contains(String.valueOf(n))) {
						ans++;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		sc.close();
	}
	
	public static void checkPrime() {
		isNotPrime[0] = 1;
		isNotPrime[1] = 1;
		for(int i=2 ; i<isNotPrime.length ; i++) { 
			if(isNotPrime[i] == 1) continue;
			for(int j=i ; j*i < isNotPrime.length ; j++) {
				if((long)i*j < isNotPrime.length ) isNotPrime[i*j] = 1;
			}
		}
	}
}