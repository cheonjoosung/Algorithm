package SS.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

//SWExpertAcademy 모의 SW 역량 테스트 줄기세포 배양
public class P5653 {
	static int n, m, k, ans;
	static int [][] map;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {1, 0, -1, 0};
	static ArrayList<C> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();

			/*
			 * k시간동안 이동한다면 1인 세포는 2초마다 이동하므로 좌우로 k/2씩 증가가능
			 * n+k , m+k 가 세포의 최대 가능한 크기임. 이것이 싫다면 부딪히지 않을 만큼 범위의 500*500 잡아도 됨
			 */
			map = new int[n+k][m+k];  
			ans = 0;
			list = new ArrayList<>();

			for(int i=k/2 ; i<n+k/2 ; i++) {
				for(int j=k/2 ; j<m+k/2 ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) {
						/*
						 * 살아있는 시간은 = 비활성 + 활성시간 - 1 = 2*x - 1
						 * 2초인 세포는 2초때 활성이 들어가므로 총 3초동안 생존임 
						 * false 여부는 spread 판단... 
						 */
						list.add(new C(i, j, map[i][j], map[i][j], 2*map[i][j] - 1, false));
					}
				}
			}

			Collections.sort(list);
			solve();			

			ans = list.size();
			System.out.println("#" + t + " " + ans);
		}        

		sc.close();
	}

	public static void solve() {
		/*
		 * 1. 비활성 0 이면 activeOn
		 * 2. 비활성 -1 이면 퍼트리기
		 * 2-1. 맵에 상하좌우 퍼트릴때 이동하는 곳에 값이 0일때만 퍼트린다.
		 * 3. 활성시간 -1 && activeOn 이면 제거 
		 * 4. activeOn 이면 -1
		 * 5. 활성시간이 끝난 세포를 List 에서 제거
		 */
		for(int t=1 ; t<=k ; t++) {
			for(int i=0 ; i<list.size() ; i++) {
				list.get(i).nt--;
				list.get(i).at--;
			}

			ArrayList<C> temp = new ArrayList<>();
			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i).nt <= -1 && list.get(i).isSpread == false) {
					spread(list.get(i), temp);
				}
			}

			/*
			 * 역순 정렬을 하는 이유
			 * 1. 1, 2, 3 인 세포가 동시에 이동할 때 높은 value가 우선권을 가짐
			 * 2. List 대신 Priority 큐를 써서 풀이도 가능
			 * 3. List<ArrayList<C>> list 이중을 이용가능
			 * 3-1. 생명령이 1부터 10이므로 리스트 0에는 생명력 1인 애들이 들어감. i리스트에는 생명력이 i-1인 친구들이 들어감  
			 */
			if(temp.size() > 0) list.addAll(temp);
			Collections.sort(list); 
			
			/*
			 * ArrayList 제거시 반드시 iterator 사용해야 함. 
			 * 미사용시 concurrentModification Exception 발생 
			 */
			Iterator<C> iter = list.iterator();
			while(iter.hasNext()) {
				C c = iter.next();
				
				if(c.at <= -1) //비활성 + 활성시간이 -1 이하면 죽은세포
					iter.remove();
			}
		}

	}

	public static void spread(C c, ArrayList<C> temp) {
		for(int i=0 ; i<4 ; i++) { //상하좌우
			int nx = c.x + dx[i];
			int ny = c.y + dy[i];

			if(map[nx][ny] == 0) {
				map[nx][ny] = c.v;
				temp.add(new C(nx, ny, c.v, c.v, c.v*2-1, false));
			}
		}
	}
}

class C implements Comparable<C>{
	int x; int y; int v; int nt; int at; boolean isSpread;
	C(int x, int y, int v, int nt, int at, boolean isSpread) {
		this.x = x; this.y =y; this.v = v; this.nt = nt; this.at = at; this.isSpread = isSpread;
	}
	@Override
	public int compareTo(C o) {
		return (o.v - this.v);
	}
}