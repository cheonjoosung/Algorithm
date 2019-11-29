package kakao.test;

import java.util.Arrays;

public class Medium {
	public static String caesar(String s, int n) {
		String result = "";

		for(int i=0 ; i< s.length() ; i++) {
			char c = s.charAt(i);

			if(c != ' ') {
				n = n % 26;

				if(65 <= c && c <= 90) {
					if(c+n > 90) {
						c = (char) (c + n -26);
					} else {
						c = (char) (c + n);
					}			
				} else if(97 <= c && c <= 122) {
					if(c+n > 122) {
						c = (char) (c + n -26);
					} else {
						c = (char) (c + n);
					}
				}
			} 

			result += c;
		}

		return result;
	}


	public static int nextBigNumber(int n){
		int answer = 0;

		String res = Integer.toBinaryString(n);
		int oneCount = 0;

		for(int i=0; i<res.length() ; i++)
			if(res.charAt(i) == '1') oneCount++;

		char [] temp = res.toCharArray();

		for(int i=res.length()-1 ; i>=1 ; i--) {
			if(temp[i] == '0') continue;
			else {
				if(temp[i] == '1' && temp[i-1] == '0') {
					temp[i] = '0';
					temp[i-1] = '1';

					int last = 0;
					for(int j=i ; j<temp.length ; j++) {
						if(temp[j] == '0') continue;
						else {
							if(j < (temp.length-1 - last) && temp[temp.length-1-last] == '0') {
								temp[j] = '0';
								temp[temp.length-1-last] = '1';
								last++;
							}
						}
					}

					res = "";

					for(char c : temp)
						res += c;
					break;
				}

				if(i == 1) {
					res = "1";
					for(int k=0 ; k<temp.length ; k++) {
						if(k > temp.length - oneCount) {
							res += "1";
						} else {
							res += "0";
						}
					}
					break;
				}
			}
		}

		answer = Integer.parseInt(res, 2);

		return answer;
	}

	public static int jumpCase(int num) {
		int [] dp = new int[num+1];
		dp[0] = 1;
		dp[1] = 2;

		if(num == 1) {
			return 1;
		} else if(num == 2) {
			return 2;
		} 

		for(int i=2; i<num ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[num-1];
	}

	public static int noOvertime(int no, int[] works) {
		int result = 0;

		Arrays.sort(works);

		while(no != 0) {
			works[works.length-1]--;
			Arrays.sort(works);
			no--;
		}
		
		for(int k : works) {
			result += Math.pow(k, 2);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(caesar("a B z", 4));
		System.out.println(nextBigNumber(78));
		System.out.println(jumpCase(4));
		System.out.println(noOvertime(4, new int[]{4,3,3}));
	}
}
