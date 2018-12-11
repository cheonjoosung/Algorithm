package test;

public class StringProblem {
	public void print() {

	}

	public StringBuilder reverserChat(char[] arr) {
		int size = arr.length;

		for(int i=0 ; i<size/2 ; i++) {
			char tmp = arr[i];
			arr[i] = arr[size - 1 - i];
			arr[size - 1 - i] = tmp;
		}
		return new StringBuilder(arr.toString());
	}

	public StringBuilder reverseString(StringBuilder sb) {
		return sb.reverse();
	}

	public StringBuilder reverseString2(StringBuilder sb) {
		for(int i=0 ; i<sb.length()/2 ; i++) {
			char tmp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(sb.length()-1-i));
			sb.setCharAt(sb.length()-1-i, tmp);
		}
		return sb;
	}

	public StringBuilder reverseString3(StringBuilder sb) {
		StringBuilder temp = new StringBuilder();

		for(int i=0 ; i<sb.length() ; i++) {
			temp.append(sb.charAt(sb.length()-1-i));
		}
		return temp;
	}
	
	public void lcs(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int x = 1; x <= str1.length(); x++) {
			char c1 = str1.charAt(x - 1);

			for (int y = 1; y <= str2.length(); y++) {
				char c2 = str2.charAt(y - 1);

				if (c1 == c2) {
					// 값이 같으면 좌측 대각선 위의 값 + 1
					dp[x][y] = dp[x - 1][y - 1] + 1;
				} else {
					// 값이 다르면 좌측(x-1), 상단(y-1)의 값중 더 큰 값
					dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
				}
			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
