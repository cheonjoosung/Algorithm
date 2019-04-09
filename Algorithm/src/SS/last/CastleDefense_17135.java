package SS.last;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CastleDefense_17135 {
	static int n, m, d, ans;
	static int [][] map;
	static boolean [] arrowVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();

		map = new int[n+1][m];
		arrowVisited = new boolean[m];
		ans = 0;

		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<m ; j++)
				map[i][j] = sc.nextInt();

		//N+1번째 성 위에 궁수를 배치하기 위한 DFS
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

			for(int i=0 ; i<=n ; i++)
				for(int j=0 ; j<m ; j++)
					copyMap[i][j] = map[i][j];

			startGame(copyMap);
		} else {
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
	}

	public static void startGame(int [][] newMap) {
		int cnt = 0;

		ArrayList<Dot9> arrowList = new ArrayList<>();

		for(int j=0 ; j<m ; j++)
			if(newMap[n][j] == 2) 
				arrowList.add(new Dot9(n, j));

		for(int idx=0 ; idx<n ; idx++) {
			if(check(newMap)) break;

			ArrayList<Dot9> pointList = new ArrayList<>();

			boolean [][] visited = new boolean[n+1][m];
			for(boolean [] tempArr : visited)
				Arrays.fill(tempArr, false);

			for(int k=0 ; k<arrowList.size() ; k++) {
				int minDist = 100; int findX = 100; int findY = 100;
				for(int j=0 ; j<m ; j++) {
					for(int i=n-1 ; i>=0 ; i--) {

						if(newMap[i][j] == 1) {
							int dist = Math.abs(i-arrowList.get(k).x) + Math.abs(j-arrowList.get(k).y);

							if(dist <= d) {
								if(minDist > dist) {
									minDist = dist;
									findX = i;
									findY = j;
								} else if(minDist == dist) {
									minDist = dist;
									if(findY > j) {
										findX = i;
										findY = j;
									}
								} else { }
							}
						}
					}
				}

				if(minDist != 100) {
					pointList.add(new Dot9(findX, findY));
					if(!visited[findX][findY]) {
						cnt++;
						visited[findX][findY] = true;
					}
				}
			}		

			for(Dot9 p : pointList)
				newMap[p.x][p.y] = 0;

			moveEnermy(newMap);
		}

		ans = Math.max(ans, cnt);
	}

	public static boolean check(int [][] newMap) {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}

	public static void moveEnermy(int [][] newMap) {
		for(int i=n-1 ; i>=1 ; i--)
			for(int j=0 ; j<m ; j++)
				newMap[i][j] = newMap[i-1][j];

		for(int j=0 ; j<m ; j++) //마지막 줄이므로 
			newMap[0][j] = 0;
	}
}

class Dot9 {
	int x; int y;
	Dot9(int x, int y) {
		this.x = x; this.y = y;
	}
}