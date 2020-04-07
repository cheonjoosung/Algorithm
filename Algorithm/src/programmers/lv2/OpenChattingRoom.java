package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChattingRoom {
	public String[] solution(String[] record) {
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> hs = new HashMap<>();

		for(String temp : record) {
			String [] arr = temp.split(" ");

			if(!arr[0].equals("Leave")) 
				hs.put(arr[1], arr[2]);	
		}

		for(String temp : record) {
			String [] arr = temp.split(" ");

			if(arr[0].equals("Enter")) {
				list.add(hs.get(arr[1]) + "님이 들어왔습니다.");
			} else if(arr[0].equals("Leave")) {
				list.add(hs.get(arr[1]) + "님이 나갔습니다.");
			}
		}


		String [] answer = new String[list.size()];

		for(int i=0 ; i<list.size() ; i++)
			answer[i] = list.get(i);        

		return answer;
	}
}
