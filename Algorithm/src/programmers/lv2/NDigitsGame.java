package programmers.lv2;

public class NDigitsGame {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		int num = 1;

		while(sb.length() < t*m) {
			sb.append(convert(num, n));
			num++;
		}

		StringBuilder ans = new StringBuilder();

		for(int i=0 ; i<t*m ; i++)
			if(i % m == (p-1)) 
				ans.append(sb.charAt(i));


		return ans.toString();
	}

	public StringBuilder convert(int num, int n) {
		StringBuilder sb = new StringBuilder();
		
		while(num>0) {
			int val = num % n;
			sb.append(val >= 10 ? String.valueOf((char)('A' + val - 10)) : val);
			num /= n;
		}
		return sb.reverse();
	}
}
