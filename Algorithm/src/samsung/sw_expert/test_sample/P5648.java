package samsung.sw_expert.test_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SWExpertAcademy 모의 SW 역량 테스트 원자 소멸 시뮬레이션
public class P5648 {
	static int n;
	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for(int i=1;i<=tc;i++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Atom> list = new ArrayList<>();
			
			for(int j=0;j<n;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Atom(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken())));
			}
			sb.append("#"+i+" "+solve(list)+"\n");
		}        

		System.out.print(sb);
	}

	static int [][] map = new int[4001][4001];
	public static int solve(ArrayList<Atom> list) {
		Queue<Atom> q = new LinkedList<>();

		//0.5초때의 애매한 상황을 피하기 위하여 2배
		for(Atom a : list) {
			int x = a.x+1000;
			int y = a.y+1000;
			q.add(new Atom(2*x, 2*y, a.d, a.k));
			map[2*x][2*y] = a.k;
		}

		
		int res = 0;
		while(!q.isEmpty()) {
			Atom a = q.remove();

			/*
			 * 1. 출발하기 전에 나의 방출값과 맵의 저장된 값(누군가 오면 기존의 값보다 커진다) 비교
			 * 2. 내가 가진 방출값보다 맵의 값이 크다면 충돌한거기에 해당맵을 0으로 하고 큐에서 제거(continue)
			 */
			if(map[a.x][a.y] > a.k) { //누가와서 파워를 더했기에 추가됬으므로 지워야함
				res += map[a.x][a.y];
				map[a.x][a.y] = 0;
				continue;
			}

			//칸 이동
			int nx = a.x + dx[a.d];
			int ny = a.y + dy[a.d];

			//범위 나가면 제거. 맵에 표시된 값 제거
			if(nx < 0 || ny < 0 || nx > 4000 || ny > 4000) {
				map[a.x][a.y] = 0;
				continue;
			}

			/*
			 * 1. 이동한 칸에 값이 있는 경우 : 먼저 온 것이기에 내가 가진 방출값만 더해주고 이동하기 전의 위치를 0으로 + 제
			 * 2. 이동한 칸에 값이 0인 경우 : 아무도 안왔기에 나의 방출값 표시 + 이동하기 전의 위치 0 + 이동한 위치로 큐에 추
			 */
			if(map[nx][ny] != 0) {
				map[nx][ny] += a.k; //누군가 먼저 도착한 것이기에 더해준다.
				map[a.x][a.y] = 0; //이동했으므로 기존 것 초기화
			} else {
				map[nx][ny] = a.k;
				map[a.x][a.y] = 0; //이동했으므로 기존것 초기화
				q.add(new Atom(nx, ny, a.d, a.k));
			}
		}

		return res;
	}
}

class Atom {
	int x; int y; int d; int k;
	Atom(int x, int y, int d, int k) {
		this.x=x; this.y=y; this.d=d; this.k=k;
	}
}
