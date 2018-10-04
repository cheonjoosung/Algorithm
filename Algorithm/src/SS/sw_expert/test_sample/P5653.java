package SS.sw_expert.test_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//줄기세포 배양
public class P5653 {
	static int [][] map;
	static int ans, n, m, k;
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	static List<ArrayList<Cell>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for(int tc=1 ; tc<=t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken()); //세포셀 크기 row,col<=50 
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken()); //배양 시간 k<=300

			map = new int[n+k][m+k]; //1이 가장 빠르게 번식함. 양쪽으로 퍼지니까 k/2+k/2=k 만큼 크게 설정, 비활성화된 친구 표시
			
			list.clear();
			for(int i=0 ; i<10 ; i++)
				list.add(new ArrayList<>()); //활성중인 세포를 표시하기 위한 리스트

			for(int i=(k/2) ; i<(k/2)+n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=(k/2) ; j<(k/2)+m ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					//생명력이 0~9사이
					if(map[i][j] != 0) 
						list.get(map[i][j]-1).add(new Cell(i, j, map[i][j], map[i][j], k ,0));
				}
			}

			solve();
			
			int ans = 0;
			for(int i=0 ; i<map.length ; i++) {
				for(int j=0 ; j<map[0].length ; j++) {
					if(map[i][j] !=0 && map[i][j] != -1) ans++;
				}
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	
	public static void solve() {
		Queue<Cell> q = new LinkedList<>();
		
		for(int i=9 ; i>=0 ; i--) {
			if(list.get(i).size() != 0) {
				for(int j=0 ; j<list.get(i).size() ; j++) {
					int x = list.get(i).get(j).x;
					int y = list.get(i).get(j).y;
					int k = list.get(i).get(j).k;
					int time = list.get(i).get(j).time;
					q.add(new Cell(x, y, k, k, time, 0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Cell c = q.poll();
			
			if(c.state == 0 && c.flag == 1) { //
				map[c.x][c.y] = -1;
				continue;
			}
			
			if(c.time == 0) continue;
			
			if(c.state == 0) { //비활성시간이 0이 될때
				q.add(new Cell(c.x, c.y, c.k, c.k, c.time, 1)); //활성화되고 머무는 시간 flag->1
			} else {
				q.add(new Cell(c.x,c.y, c.k, c.state-1, c.time-1, c.flag)); //시간 감소
				continue;
			}
			
			for(int i=0 ; i<4 ; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(nx<0 || ny <0 || nx>=n+k || ny>=m+k) continue;
				if(map[nx][ny] != 0) continue;
				
				map[nx][ny] = c.k;
				q.add(new Cell(nx, ny, c.k, c.k, c.time-1, 0));
			}
			
		}
	}
}

class Cell {
	int x; int y; int k; int state; int time; int flag;
	public Cell(int x, int y, int k, int state, int time, int flag) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.state = state; //변화는 생명력
		this.time = time; //전체시간
		this.flag = flag; //0이 되었을 때 번식 유무
	}

}