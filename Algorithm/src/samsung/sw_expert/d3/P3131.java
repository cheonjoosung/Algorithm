package samsung.sw_expert.d3;

//100만 이하의 모든 소수
public class P3131 {
	static boolean [] isNotPrime = new boolean[1_000_000+1];

	public static void main(String[] args) {
		//Arrays.fill(isNotPrime, false);
		check();
		
		for(int i=2 ; i<isNotPrime.length ; i++) {
			if(!isNotPrime[i]) System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
	public static void check() {
		for(int i=2 ; i<= 1_000_000 ; i++) {
			if(isNotPrime[i]) continue;
			
			for(int j=2 ; i*j <= 1_000_000 ; j++) {
				isNotPrime[i*j] = true;
			}
		}
	}
}
