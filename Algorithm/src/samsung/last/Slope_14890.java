package samsung.last;

import java.util.Scanner;

////백준 14890 경사로
public class Slope_14890 {
	static int n;
	static int len;
	static int [][] map;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		len = sc.nextInt();
		map = new int[n][n];
		ans = 0;

		//경사 길이 2, 각 높이는 10보다 작거나 같다

		for(int i=0 ; i<n ; i++)
			for(int j=0; j<n ; j++)
				map[i][j] = sc.nextInt();

		/*
		 * 1. 높이가 달라지는 지점 찾기 1만큼.. 그 이상이면 길 안됨
		 * 2. 찾은 지점부터 끝까지의 차이가 L 보다 같거나 커야 함. 그 반대도
		 * 3. 높아지느냐 낮아지느냐에 따라 다른 로직 사용
		 * 4. 만약에 슬로프를 놓았다면 기록을 해야 함... 2 1 1 2 의 경우
		 */

		for(int i=0 ; i<n ; i++) {
			boolean isPossible = true;
			int lastIdx = -1;
			
			for(int j=0 ; j<n-1 ; j++) {
				int diff = map[i][j] - map[i][j+1];
				
				if(Math.abs(diff) > 1) {
					isPossible = false;
					break;
				} else if(diff == 1) { //좌에서 우로 하향 슬로프 
					if(j+len >= n) {
						isPossible = false;
						break;
					}
					
					for(int k=j+1 ; k<=j+len ; k++) {
						if(map[i][j] - map[i][k] != 1) {
							isPossible = false;
							break;
						}
					}
					
					lastIdx = j+len;
					
				} else if(diff == -1) { //좌에서 우로 상향 슬로프 
					if(j-len +1 < 0 || j-len+1 <= lastIdx ) { //이전에 설치한거랑 겹치거나 그보다 아래에 있으면 아니
						isPossible = false;
						break;
					}
					
					for(int k=j ; k>=j-len+1 ; k--) {
						if(map[i][j] - map[i][k] != 0) {
							isPossible = false;
							break;
						}
					}
					
					lastIdx = j;
				}
				
				if(!isPossible) break;
			}
			
			if(isPossible) {
				ans++;
			}
		}

		for(int j=0 ; j<n ; j++) {
			boolean isPossible = true;
			int lastIdx = -1;
			
			for(int i=0 ; i<n-1 ; i++) {
				int diff = map[i][j] - map[i+1][j];
				
				if(Math.abs(diff) > 1) {
					isPossible = false;
					break;
				} else if(diff == 1) { //좌에서 우로 하향 슬로프 
					if(i+len >= n) {
						isPossible = false;
						break;
					}
					
					for(int k=i+1 ; k<=i+len ; k++) {
						if(map[i][j] - map[k][j] != 1) {
							isPossible = false;
							break;
						}
					}
					
					lastIdx = i+len;
					
				} else if(diff == -1) { //좌에서 우로 상향 슬로프 
					if(i-len +1 < 0 || i-len+1 <= lastIdx ) { //이전에 설치한거랑 겹치거나 그보다 아래에 있으면 아니
						isPossible = false;
						break;
					}
					
					for(int k=i ; k>=i-len+1 ; k--) {
						if(map[i][j] - map[k][j] != 0) {
							isPossible = false;
							break;
						}
					}
					
					lastIdx = i;
				}
				
				if(!isPossible) break;
			}
			
			if(isPossible) {
				ans++;
			}
		}

		System.out.println(ans);


		sc.close();
	}
}
