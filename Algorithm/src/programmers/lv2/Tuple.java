package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Tuple {
	public int[] solution(String s) {
		/*
		s = s.substring(2, s.length()-2).replace("},{", "-");
		String [] arr = s.split("-");
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		ArrayList<Integer> list = new ArrayList<>();
		for(String temp : arr) {
			String [] val = temp.split(",");
			
			for(int i=0 ; i<val.length ; i++) {
				int num = Integer.valueOf(val[i]);
				
				if(!list.contains(num)) {
					list.add(num);
				}
			}
		}
		
		int [] answer = new int[list.size()];
		for(int i=0 ; i<list.size() ; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
		
		*/
		
		StringTokenizer st = new StringTokenizer(s, "{}");
		
		ArrayList<String> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			if(!temp.equals(","))
				list.add(temp);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		
		ArrayList<String> answerList = new ArrayList<>();

		for(String temp : list) {
			String [] arr = temp.split(",");
			
			for(int i=0 ; i<arr.length ; i++) {
				if(!answerList.contains(arr[i])) {
					answerList.add(arr[i]);
				}
			}
		}
		
		int [] answer = new int[answerList.size()];
		for(int i=0 ; i<answerList.size() ; i++) {
			answer[i] = Integer.parseInt(answerList.get(i));
		}
		
		return answer;	
	}
}
