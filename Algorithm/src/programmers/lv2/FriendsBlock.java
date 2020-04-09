package programmers.lv2;

public class FriendsBlock {

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char [][] map = new char[m][n];

		for(int i=0 ; i<m ; i++) {
			map[i] = board[i].toCharArray();
		}

		while(true) {
			int cnt = 0;

			boolean [][] isVisited = new boolean[m][n];

			for(int i=0 ; i<=m-2 ; i++) {
				for(int j=0 ; j<=n-2 ; j++) {
					if(map[i][j] == '0') continue;
					
					if(map[i][j] == map[i][j+1] && map[i][j+1] == map[i+1][j+1] && map[i+1][j+1] == map[i+1][j]) {
						cnt += check(i,j, map, isVisited);
					}
				}
			}

			if(cnt == 0) {
				break;
			} else {
				answer += cnt;
				move(isVisited, map, m, n);
			}
		}

		return answer;
	}

	public int check(int x, int y, char [][] map, boolean [][] isVisited) {
		int res = 4;
		
		if(isVisited[x][y]) res--;
		if(isVisited[x+1][y]) res--;
		if(isVisited[x][y+1]) res--;
		if(isVisited[x+1][y+1]) res--;
		
		isVisited[x][y] = true;
		isVisited[x+1][y] = true;
		isVisited[x][y+1] = true;
		isVisited[x+1][y+1] = true;

		return res;
	}

	public void move(boolean [][] isVisited, char [][] map, int m, int n) {
		for(int j=0 ; j<n ; j++) {
			for(int i=m-1 ; i>=0 ; i--) {
				if(isVisited[i][j] == true) {
					map[i][j] = '0';
					
					for(int k=i-1 ; k>=0 ; k--) {
						if(isVisited[k][j] == false) {
							char temp = map[i][j];
							map[i][j] = map[k][j];
							map[k][j] = temp;
							
							boolean isTemp = isVisited[i][j];
							isVisited[i][j] = isVisited[k][j];
							isVisited[k][j] = isTemp;
							break;
						}
					}
				}
			}
			
		}
	}
}