package SS.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

//줄기세포 배양
public class P5653 {
	static int [][] map;
	static int ans, row, col, k;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	static ArrayList<Cell> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			col = sc.nextInt(); //세포셀 크기 row,col<=50 
			row = sc.nextInt();
			k = sc.nextInt(); //배양 시간 k<=300

			ans = 0;
			map = new int[row+k][col+k]; //1이 가장 빠르게 번식함. 양쪽으로 퍼지니까 k/2+k/2=k 만큼 크게 설정, 비활성화된 친구 표시
			list = new ArrayList<>(); //활성중인 세포를 표시하기 위한 리스트

			for(int i=0 ; i<row ; i++)
				for(int j=0 ; j<col ; j++) {
					int val = sc.nextInt();
					if(val != 0) {
						list.add(new Cell(i+k/2, j+k/2, val, val, val*2, 1));
						map[i+k/2][j+k/2] = val;
					}
				}

			
			for(int i=0 ; i<=k ; i++) {
				int size = list.size();
				
				for(int j=0 ; j<size ; j++) {					
					if(list.get(j).nonActTime == -1 && list.get(j).state == 1) {
						list.get(j).state = 0;
						spread(list.get(j).x, list.get(j).y, list.get(j).val);
					}
				}
				
				Collections.sort(list);
				
				Iterator<Cell> iter = list.iterator();
				while(iter.hasNext()) {
					Cell c = iter.next();
					
					if(c.totalTime <= 0 && c.state == 0) 
						iter.remove();
				}
				
				print(i);
				
				for(int j=0 ; j<list.size() ; j++) {
					list.get(j).nonActTime--;
					list.get(j).totalTime--;
				}
			}

			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i).state == 1) ans++;
				else {
					if(list.get(i).totalTime >=0) ans++;
					
				}
			}
			
			ans = list.size();
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	public static void print(int k) {
		System.out.println("K : " + k);
		for(Cell c : list) {
			System.out.print("Info : " + c.x + " " + c.y + " "
					+ c.val + " " + c.nonActTime + " " + c.totalTime + " " + c.state);
			System.out.println();
		}
		System.out.println();
	}

	public static void spread(int x, int y, int val) {
		for(int i=0 ; i<4 ; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];

			if(map[nextX][nextY] == 0) {
				map[nextX][nextY] = val;
				list.add(new Cell(nextX, nextY, val, val, val*2, 1));
			}
		}
	}
}

class Cell implements Comparable<Cell>{
	int x; int y; int val; int nonActTime; int totalTime; int state;
	Cell(int x, int y, int val, int nonActTime, int totalTime, int state) {
		this.x = x; this.y =y; this.val = val; 
		this.nonActTime = nonActTime; this.totalTime = totalTime; this.state=state; //1은 비활성화 0은 활성호
	}
	@Override
	public int compareTo(Cell o) {
		return (o.val - this.val);
	}
}