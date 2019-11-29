package kakao.blind_2020;

public class Problem_01 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));		
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
	
	public static int solution(String s) { 
		int size = Integer.MAX_VALUE;
		
		for(int k=1 ; k<s.length() ; k++) { //최소 압축 단위
			StringBuilder sb = new StringBuilder();
			boolean isStart = true;
			
			for(int i=0 ; i<s.length() ; i++) {
				if(i+k > s.length()) {
					sb.append(s.substring(i, s.length()));
					break;
				}
				
				String before = s.substring(i, i+k);
				int cnt = 1;
				
				for(int j=i+k ; j<s.length() ; j=j+k) {
					if(j+k > s.length()) break;
					
					String next = s.substring(j, j+k);
					
					if(before.equals(next)) {
						cnt++;
					}
					else {
						if(i == 0 && cnt == 1) isStart = false;
						break;
					}
				}
				
				if(cnt > 1) {
					sb.append(cnt).append(before);
					i = i + cnt*k - 1;;
				} else {
					sb.append(before.charAt(0));
				}				
			}		
			
			if(isStart)
				size = Math.min(size, sb.length());
		}
		return size;
	}
	
}
