package samsung.last;

import java.util.Scanner;

//백준 2048 12100
public class Game2048_12100 {
	static int [][] map;
	static int Ans;
	static int Len = 5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		map = new int[n][n];
		Ans = 0;

		for(int i=0; i<n ; i++)
			for(int j=0; j<n ; j++) { 
				map[j][i] = sc.nextInt();
				Ans = Math.max(Ans, map[j][i]);
			}

		dfs(map, 0, n);		

		System.out.println(Ans);

		sc.close();
	}

	public static void dfs(int [][] map, int step, int n) {
		if(step == Len) {
			update(map);
			return;
		}

		for(int i=0; i<4 ; i++) {
			int [][] temp = new int[n][n];

			for(int j=0 ; j< n ; j++) 
				for(int k=0 ; k<n ; k++)
					temp[k][j] = map[k][j];

			dfs(move(temp, i, n), step+1, n);
		}
	}

	public static int[][] move(int [][] tempMap, int dir, int n) {
		switch(dir) {
		case 0://좌->우
			for(int y=0 ; y<n ; y++){
				int blank = 0;
				for(int x = 1 ; x < n ; x++) {
					if(tempMap[x][y] == 0) {
						blank++;
						continue;
					} else {
						if(tempMap[x][y] == tempMap[x-1-blank][y]) {
							tempMap[x-1-blank][y] *= 2;
							tempMap[x][y] = 0;
						} else if(tempMap[x-1-blank][y] == 0){
							tempMap[x-1-blank][y] = tempMap[x][y];
							tempMap[x][y] = 0;
							blank++;
						} else {
							//값을 같지않으므로 우측으로 땡기기
							tempMap[x-blank][y] = tempMap[x][y];
							if(blank != 0) tempMap[x][y] = 0;
						}
					}
				}
			}
			break;
		case 1://상->하
			for(int x=0 ; x<n ; x++){
				int blank = 0;
				for(int y = n-2 ; y >= 0 ; y--) {
					if(tempMap[x][y] == 0) {
						blank++;
						continue;
					} else {
						if(tempMap[x][y] == tempMap[x][y+1+blank]) {
							tempMap[x][y+1+blank] *= 2;
							tempMap[x][y] = 0;
						} else if(tempMap[x][y+1+blank] == 0){
							tempMap[x][y+1+blank] = tempMap[x][y];
							tempMap[x][y] = 0;
							blank++;
						} else {
							//값을 같지않으므로 우측으로 땡기기
							tempMap[x][y+blank] = tempMap[x][y];
							if(blank != 0) tempMap[x][y] = 0;
						}
					}
				}
			}
			break;
		case 2://우->좌 
			for(int y=0 ; y<n ; y++){
				int blank = 0;
				for(int x = n-2 ; x >= 0 ; x--) {
					if(tempMap[x][y] == 0) {
						blank++;
						continue;
					} else {
						if(tempMap[x][y] == tempMap[x+1+blank][y]) {
							tempMap[x+1+blank][y] *= 2;
							tempMap[x][y] = 0;
						} else if(tempMap[x+1+blank][y] == 0){
							tempMap[x+1+blank][y] = tempMap[x][y];
							tempMap[x][y] = 0;
							blank++;
						} else {
							//값을 같지않으므로 우측으로 땡기기
							tempMap[x+blank][y] = tempMap[x][y];
							if(blank != 0) tempMap[x][y] = 0;
						}
					}
				}
			}
			break;
		case 3://하->상 
			for(int x=0 ; x<n ; x++){
				int blank = 0;
				for(int y = 1 ; y<n ; y++) {
					if(tempMap[x][y] == 0) {
						blank++;
						continue;
					} else {
						if(tempMap[x][y] == tempMap[x][y-1-blank]) {
							tempMap[x][y-1-blank] *= 2;
							tempMap[x][y] = 0;
						} else if(tempMap[x][y-1-blank] == 0){
							tempMap[x][y-1-blank] = tempMap[x][y];
							tempMap[x][y] = 0;
							blank++;
						} else {
							//값을 같지않으므로 우측으로 땡기기
							tempMap[x][y-blank] = tempMap[x][y];
							if(blank != 0) tempMap[x][y] = 0;
						}
					}
				}
			}
			break;

		}
		return tempMap;
	}

	public static void update(int [][] tempMap) {
		for(int [] temp : tempMap)
			for(int val : temp) {
				Ans = Math.max(Ans, val);
			}
	}


}
