package programmers.lv1;

public class ScreetMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String [] ans = new String[n];

		for(int i=0 ; i<n ; i++) {
			int res = arr1[i] | arr2[i];

			String binaryStr = Integer.toBinaryString(res);
			String temp = "";

			for(int j=0 ; j<n-binaryStr.length() ; j++) {
				temp += " ";
			}

			for(int j=0 ; j<binaryStr.length() ; j++) {
				String str = String.valueOf(binaryStr.charAt(j));

				if(str.equals("1")) {
					temp += "#";
				} else {
					temp += " ";
				}
			}

			ans[i] = temp;
		}

		return ans;
	}
}
