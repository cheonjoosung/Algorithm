package SS.last;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//백준 15686 치킨 배달
class Dot {
	public int x, y;
	
	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Chicken_15686 {
	static int n, m, dist;
	static ArrayList<Dot> homeList, chickenList;
	static boolean [] isChoiced;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //집 사이즈 NxN
		m = sc.nextInt(); //최대로 선택 가능한 치킨집 
		dist = Integer.MAX_VALUE; //최소값 구하는 문제이므로 맥스로 설정
		
		homeList = new ArrayList<>();
		chickenList = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				int val = sc.nextInt();
				
				if(val == 1) {
					homeList.add(new Dot(i, j));
				} else if(val == 2) {
					chickenList.add(new Dot(i, j));
				}
			}
		}
		
		isChoiced = new boolean[chickenList.size()]; //m 개의 치킨집을 선택여부를 확인하기 위한 변수
		Arrays.fill(isChoiced, false);
		
		for(int i=0 ; i<chickenList.size() ; i++) {
			isChoiced[i] = true; //i번째 치킨집 선택 
			dfs(i, 0);
			isChoiced[i] = false; //i번째 치킨집 선택 안함
		}
		
		System.out.println(dist);
		
		sc.close();
	}
	
	public static void dfs(int idx, int cnt) {
		for(int i=idx ; i<chickenList.size() ; i++) {
			if(isChoiced[i]) continue;
			isChoiced[i] = true;
			dfs(i, cnt+1);
			isChoiced[i] = false;
		}
		
		if(m-1 == cnt) { //m-1 인 이유는 dfs들어오기전에 선택을 한번하고 오기때문...
			int minSum = 0;
			for(int i=0 ; i<homeList.size() ; i++) {
				
				int min = Integer.MAX_VALUE;
				for(int j=0 ; j<chickenList.size() ; j++) {//i번째 집과 가장 가까운 치킨집 찾는 과정
					if(!isChoiced[j]) continue; //선택되지 않은 치킨집과 계산필요 없음
					
					int curMin = getDist(homeList.get(i), chickenList.get(j)); 
					min = Math.min(min, curMin);
				}
				
				minSum += min;
			}
			
			dist = Math.min(dist, minSum);
		}
	}
	
	public static int getDist(Dot a, Dot b) { //치킨집과 집사이의 거리 계산
		return ( Math.abs(a.x - b.x) + Math.abs(a.y - b.y) );
	}
}