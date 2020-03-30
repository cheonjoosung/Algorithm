package programmers.lv2;

import java.util.ArrayList;

public class Cache {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		ArrayList<String> list = new ArrayList<>();

		for(String city : cities) {
			String temp = city.toLowerCase();

			if(list.contains(temp)) { //hit
				answer += 1;

				int idx = list.indexOf(temp);
				list.remove(idx);
				list.add(temp);
			} else { //miss
				answer += 5;
				if(cacheSize > 0) {
					if(list.size() >= cacheSize)
						list.remove(0);
					list.add(temp);                    
				}
			}
		}
		
		return answer;
	}
}
