package samsung.last;

import java.util.Scanner;

public class CirclRotate_17822 {
	static int n, m, t, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();

		int [][] arr = new int[n+2][m]; //0번째와 n+1번째는 0으로 채워진 원판

		ans = 0;

		for(int i=1 ; i<n+1 ; i++)
			for(int j=0 ; j<m ; j++)
				arr[i][j] = sc.nextInt();  //위가 0으로 판단			

		for(int i=0 ; i<t ; i++) {
			int idx = sc.nextInt(); //몇번째
			int dir = sc.nextInt(); //방향 0이면 시계 1 반시계
			int cnt = sc.nextInt(); //몇칸 돌릴지
			
			move(arr, idx, dir, cnt);
			
			int [][] temp = new int[n+2][m];
			for(int x=0 ; x<n+2 ; x++) 
				for(int y=0 ; y<m ; y++) 
					temp[x][y] = arr[x][y];
			
			change(arr, temp);			
		}

		for(int i=1 ; i<=n ; i++)
			for(int j=0 ; j<m ; j++) 
				ans += arr[i][j];

		System.out.println(ans);
		sc.close();
	}

	public static void move(int [][] arr, int idx, int dir, int cnt) {
		int [] temp = new int[m];

		for(int t=1 ; idx*t <= n ; t++) {			
			for(int i=0 ; i<m ; i++) {
				if(dir == 0) temp[(i+cnt) % m] = arr[idx*t][i]; //시계
				else temp[(i-cnt+m) % m] = arr[idx*t][i]; //시계
			}

			arr[idx*t] = temp.clone();
		}
	}

	public static void change(int [][] arr, int [][] temp) {
		boolean isFound = false;
		for(int i=1 ; i<=n ; i++) {			
			for(int j=0 ; j<m ; j++) {
				if(temp[i][j] == temp[i][(j+1) % m]) {              
					arr[i][j] = 0; arr[i][(j+1) % m] = 0;
					
					if(temp[i][j] != 0) isFound = true;
				}

				if(temp[i][j] == temp[i][(j-1+m) % m]) {
					arr[i][j] = 0; arr[i][(j-1+m) % m] = 0;
					
					if(temp[i][j] != 0) isFound = true;
				}

				if(temp[i][j] == temp[i-1][j]) {
					arr[i][j] = 0; arr[i-1][j] = 0;
					
					if(temp[i][j] != 0) isFound = true;
				}

				if(temp[i][j] == temp[i+1][j]) {
					arr[i][j] = 0; arr[i+1][j] = 0;
					
					if(temp[i][j] != 0) isFound = true;
				}
			}			
		}


		if(!isFound) {
			int sum = 0;
			int cnt = 0;
			for(int i=1 ; i<=n ; i++) {			
				for(int j=0 ; j<m ; j++) {
					if(arr[i][j] != 0) {
						sum += arr[i][j];
						cnt++;
					}
				}
			}

			if(cnt != 0) {
				double avg = sum / (double) cnt;
				
				for(int i=1 ; i<=n ; i++) {
					for(int j=0 ; j<m ; j++) {
						if(arr[i][j] != 0) {
							if(arr[i][j] > avg) arr[i][j] -= 1;
							else if(arr[i][j] < avg) arr[i][j] += 1;
						}
					}
				}
			}
		}

	}
}
