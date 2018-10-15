package SS.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//무선 충전
public class P5644 {
	static int ans;
	static int m, a; //시간, 충전기 수
	static int ax, ay, bx, by; //사용자 A,B 좌표
	static int [] amove, bmove;
	static int [] dx = {0, 0, 1, 0, -1};
	static int [] dy = {0, -1, 0, 1, 0};
	static ArrayList<Po> chargeList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			m = sc.nextInt();
			a = sc.nextInt();
			
			amove = new int[m+1];
			bmove = new int[m+1];
			chargeList = new ArrayList<>();
			
			ax=1; ay=1; bx=10; by=10; //초기 위치
			amove[0] = 0; bmove[0] = 0; //처음방향 0
			ans = 0;
			
			for(int i=1 ; i<=m ; i++) amove[i] = sc.nextInt();
			for(int i=1 ; i<=m ; i++) bmove[i] = sc.nextInt();
			
			for(int i=0 ; i<a ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();
				
				chargeList.add(new Po(x, y, c, p));
			}
			
			Collections.sort(chargeList);
			
			for(int i=0 ; i<=m ; i++) {
				ArrayList<Integer> aList = new ArrayList<>();
				ArrayList<Integer> bList = new ArrayList<>();
				
				//사용자 a,b 이동
				ax += dx[amove[i]]; ay += dy[amove[i]];
				bx += dx[bmove[i]]; by += dy[bmove[i]];
				
				//A B 계산
				for(int j=0 ; j<a ; j++) {
					Po po = chargeList.get(j);
					if(po.c >= calcD(po.x, po.y, ax, ay)) aList.add(j);
					if(po.c >= calcD(po.x, po.y, bx, by)) bList.add(j);
				}
				
				int aSize = aList.size();
				int bSize = bList.size();
				if(aSize == 0 && bSize != 0) ans += chargeList.get(bList.get(0)).p;
				else if(aSize != 0 && bSize == 0) ans += chargeList.get(aList.get(0)).p;
				else if(aSize != 0 && bSize != 0) {
					int max = 0;
					
					for(int aIdx=0 ; aIdx<aSize ; aIdx++) {
						for(int bIdx=0 ; bIdx<bSize ; bIdx++) {
							if(aList.get(aIdx) == bList.get(bIdx)) 
								max = Math.max(max, chargeList.get(aList.get(aIdx)).p);
							else {
								max = Math.max(max,
										chargeList.get(aList.get(aIdx)).p + chargeList.get(bList.get(bIdx)).p);
							}
						}
					}
					
					ans += max;
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
	
	public static int calcD(int x, int y, int x1, int y1) {
		return (Math.abs(x-x1) + Math.abs(y-y1));
	}
}

class Po implements Comparable<Po>{
	int x, y, c, p;
	Po(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
	
	@Override
	public int compareTo(Po o) {
		return (o.p - this.p);
	}
}