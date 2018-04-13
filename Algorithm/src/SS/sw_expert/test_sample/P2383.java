package SS.sw_expert.test_sample;

import java.util.Scanner;

class P {
	int r, c;
	public P(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

//점심 식사시간
public class P2383 {
	static int ans, N, M, S;
	static int MAXM = 11;
	static int MAXT = 11*2 + 11*11;
	// n 방의 한 변의 길이, M 사람의 수, S(=2) 계단의 수
	
	static int [][] map;
	static int [] match;
	
	static P man[], stair[];
	
	public static int dist(int man_idx, int stair_idx) {
		int dx = Math.abs(man[man_idx].r - stair[stair_idx].r);
		int dy = Math.abs(man[man_idx].c - stair[stair_idx].c);
		
		return dx+dy;
	}
	
	public static void update() {
		int total_min_time = 0; //모든 사람이 계단을 내려가는데 필요한 시간
		
		//두 계단에 대해 독립적으로 계산 !!
		for(int stair_idx=0 ; stair_idx<2 ; stair_idx++) {
			P now_stair = stair[stair_idx];
			int arrival_time[] = new int[MAXM * 2]; // 시간이 t일때 계단에 도착하는 사람의 수
			int current_stair[] = new int[MAXT]; // 시간 t일때 계단을 내려가고 있는 사람의 수
			
			for(int i=0 ; i<MAXT ; i++) current_stair[i] = 0;
			for(int i=0 ; i<2*MAXM ; i++) arrival_time[i] = 0;
			
			for(int man_idx=0 ; man_idx<M ; man_idx++) {
				if(match[man_idx] == stair_idx) {
					arrival_time[dist(man_idx, stair_idx) + 1]++;
				}
			}
			
			int now_min_time = 0; //stair_dx 번째 계단을 내려가는 사람이 모두 작업을 마치기 위해 필요한 최소 시간
			
			//계단에 도착하는 시간 오름차순으로 각 사람이 게단을 내려가도록 시뮬레이션?
			for(int time=1 ; time<=20 ; time++) {
				//도착한 사람이 있다면 
				while(arrival_time[time] > 0) {
					arrival_time[time]--;
					
					//해당 계단을 내려가는데 필요한 시간
					int remain_time = map[now_stair.r][now_stair.c];
					
					//도착한 시점부터 사람 3명이 동시에 내려가고 있지 않을 때 1칸식 밑으로 돌려보낸다
					for(int walk_time = time; walk_time<MAXT ; walk_time++) {
						if(current_stair[walk_time] < 3) {
							current_stair[walk_time]++;
							remain_time--;
							
							if(remain_time == 0) { //계단을 다 내려갔으면 now_min_time 갱신
								now_min_time = Math.max(now_min_time, walk_time+1);
								break;
							}
						}
					}
				}
			}
			//전체 계단을 내려가는데 필요한 최소 시간은 두 계단을 내려가는데 필요한 최소 시간 중 
			total_min_time = Math.max(total_min_time, now_min_time);
		}
		//현재 match 상태일 때의 total_min_time 을 정답으로 갱신
		ans = Math.min(ans, total_min_time);
	}
	
	public static void dfs(int man_idx) {
		//사람을 각 계단에 할당해서 돌리는 구조
		if(man_idx == M) {
			update();
			return;
		}
		
		for(int stair_idx=0 ; stair_idx < 2 ; stair_idx++) {
			match[man_idx] = stair_idx;
			dfs(man_idx + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = S = 0;
			
			ans = Integer.MAX_VALUE;
			
			map = new int[N+2][N+2];
			man = new P[N*N];
			stair = new P[2];
			
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=N ; j++) {
					map[i][j] = sc.nextInt(); //1은 사람, 0은 빈칸
					if(map[i][j] == 1) man[M++] = new P(i,j);
					if(map[i][j] >= 2) stair[S++] = new P(i,j);
				}
			}
			
			match = new int[M];
			dfs(0);

			System.out.println("#" + test_case + " " + ans + " ");
		}

		sc.close();
	}
}
