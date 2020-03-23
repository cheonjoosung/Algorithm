package samsung.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//미생물 격리 
public class P2382 {
	static int n, m, k, sum;
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1}; // 상화좌우
	static int [][] map;
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1 ; tc<=t ; tc++) {			
			n = sc.nextInt(); //가로,세로
			m = sc.nextInt(); //격리시간
			k = sc.nextInt(); //미생물 군집 수 
			
			map = new int[n][n];
			sum = 0;
			ArrayList<Point> list = new ArrayList<>();
			
			for(int i=0 ; i<k ; i++) { //좌표, 숫자, 방향
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt(); 
				int d = sc.nextInt();
				
				list.add(new Point(x, y, c, d-1));
			}
			
			for(int i=0 ; i<m ; i++) {
				Collections.sort(list); //내림정렬을 통해 방향은 그친구 위주
				
				for(int [] temp : map) 
					Arrays.fill(temp, -1); //매번 초기화
				
				for(int j=0 ; j<list.size() ; j++) {
					int x = list.get(j).x;
					int y = list.get(j).y;
					int c = list.get(j).c;
					int d = list.get(j).d;
					
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx == 0 || ny == 0 || nx == n-1 || ny == n-1) { //약품구역
						c = c/2;
						d = (d%2==0) ? d+1 : d-1;
						list.get(j).c = c;
						list.get(j).d = d;
					}
					
					if(map[nx][ny] != -1) { //이동한 위치에 미생물 존재시 삭제
						list.get(map[nx][ny]).c += c;
						list.get(j).c = 0;
					} else {
						map[nx][ny] = j; //맵에 인덱스를 기록
						list.get(j).x = nx;
						list.get(j).y = ny;
					}
					
				}
				
				for(int j=0 ; j<list.size() ; j++) {
					if(list.get(j).c == 0) {
						list.remove(j);
						j--;
					}
				}
			}
			
			for(int i=0 ; i<list.size() ; i++)
				sum+= list.get(i).c;
			
			System.out.println("#" + tc + " " + sum);
		}
		
		sc.close();
	}
}

class Point implements Comparable<Point>{
	public int x, y, c, d;
	Point(int x, int y, int c, int d) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.d = d;
	}
	
	@Override
	public int compareTo(Point o) { //내리차순 정렬, 군집이 큰걸 기반으로 방향이 유지되므로... 
		if(o.c > this.c) return 1;
		else if(o.c < this.c) return -1;
		else return 0;
	}
	
	
}
