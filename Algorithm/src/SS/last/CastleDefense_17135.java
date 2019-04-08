package SS.last;

import java.util.ArrayList;
import java.util.Scanner;

public class CastleDefense_17135 {
	static int n, m, d, ans;
	static int [][] map;
	static boolean [] arrowVisited;
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {-1, 0, 1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();

		map = new int[n+1][m];
		arrowVisited = new boolean[m];

		ans = 0;

		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for(int j=0 ; j<m ; j++) {
			if(map[n][j] == 0 && !arrowVisited[j]) { 
				arrowVisited[j] = true;
				map[n][j] = 2;
				setArrow(j, 1);	
				map[n][j] = 0;
				arrowVisited[j] = false;
			}
		}

		System.out.println(ans);

		sc.close();
	}

	public static void setArrow(int idx, int cnt) {
		if(cnt == 3) {
			int [][] copyMap = new int[n+1][m];

			for(int i=0 ; i<n+1 ; i++) 
				for(int j=0 ; j<m ; j++)
					copyMap[i][j] = map[i][j];

			startGame(copyMap);
			return;
		}

		for(int j=idx+1 ; j<m ; j++) {
			if(map[n][j] == 0 && !arrowVisited[j]) {
				arrowVisited[j] = true;
				map[n][j] = 2;
				setArrow(j, cnt+1);
				map[n][j] = 0;
				arrowVisited[j] = false;
			}
		}
	}

	public static void startGame(int [][] newMap) {
		int val = 0;

		boolean [][] visited = new boolean[n+1][m];
		ArrayList<Doot> arrowList = new ArrayList<>();
		ArrayList<Doot> enermyList = new ArrayList<>();

		for(int j=0 ; j<m ; j++) {
			if(newMap[n][j] == 2) {
				arrowList.add(new Doot(n, j, false));
			}
		}		

		int count = 0;
		
		for(int l=1 ; l<=d ; l++) {
			for(int j=0 ; j<m ; j++) {
				for(int i=n-1 ; i>=0 ; i--) {

					if(newMap[i][j] == 1) {
						for(int k=0 ; k<arrowList.size() ; k++) {
							Doot a = arrowList.get(k);

							if(a.isUsed) {
								count++;
								continue;
							}

							int len = getDist(i, j, a.x, a.y);

							if(len <= d) {
								a.isUsed = true;
								if(!visited[i][j]) {
									val++;
									enermyList.add(new Doot(i, j, false));
									visited[i][j] = true;
								}
							}

						}
					}

					if(count == 3) break;
				}
				
				if(count == 3) break;
			}

			if(count == 3) break;
		}

	}

	public static boolean moveEnermy(int [][] newMap) {
		for(int i=n-1 ; i>=0 ; i--) {
			for(int j=0 ; j<m ; j++) {
				if(i == n-1) { //궁수들이 적을 잡은후에 N-1 에 적이 있다면 그 다음에 성에 도착하므로 게임 종료
					if(newMap[i][j] == 1) return false;
				} else { //적 한칸씩 이동
					newMap[i+1][j] = newMap[i][j];
				}
			}
		}

		for(int j=0 ; j<m ; j++) //마지막 줄이므로 
			newMap[0][j] = 0;		

		return true;
	}

	public static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(x2-y2);
	}
}

class Doot{
	int x; int y; boolean isUsed;
	Doot(int x, int y, boolean isUsed) {
		this.x = x; this.y = y; this.isUsed = isUsed;
	}
}