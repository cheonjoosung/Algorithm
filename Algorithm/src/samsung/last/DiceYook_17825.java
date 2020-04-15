package samsung.last;

import java.util.Scanner;

public class DiceYook_17825 {
	static int answer = 0;
	static int [] a = {
			0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //0 ~ 21
			10, 13, 16, 19, 25, 30, 35, 40, 0,  //22 ~ 30
			20, 22, 24, 25, 30, 35, 40, 0,      //31 ~ 38
			30, 28, 27, 26, 25, 30, 35, 40, 0}; //39 ~ 47

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] player = new int[10]; //주사위 10번 던질동안 말 1,2,3,4 번중 누가 움직일 것인지
		int [] dice = new int[10];

		for(int i=0 ; i<10 ; i++)
			dice[i] = sc.nextInt();

		dfs(10, 0, player, dice);

		System.out.println(answer);
		sc.close();
	}

	public static void dfs(int n, int cnt, int [] player, int [] dice) {		
		if(cnt == 10) {
			move(player, dice);
			return;
		}

		for(int i=0 ; i<4 ; i++) {
			player[cnt] = i;
			dfs(n, cnt+1, player, dice);
		}
	}

	public static void move(int [] player, int [] dice) {
		int a0 = 0; int a1 = 0; int a2 = 0; int a3 = 0;
		int score = 0;		
		
		for(int i=0 ; i<10 ; i++) {
			int d = dice[i];
			int p = player[i]; //p : 0~4

			switch(p) {
			case 0:
				if(isEnd(a0)) return;
				else {
					if(isDuplicated(a0, a1, a2, a3, d)) return;
			
					int temp = jumpCheck(a0, d);		
					a0 = temp;
					score += a[a0];
				}
				break;
			case 1:
				if(isEnd(a1)) return;
				else {
					if(isDuplicated(a1, a0, a2, a3, d)) return;
					
					int temp = jumpCheck(a1, d);		
					a1 = temp;
					score += a[a1];
				}
				break;
			case 2:
				if(isEnd(a2)) return;
				else {
					if(isDuplicated(a2, a0, a1, a3, d)) return;
				
					int temp = jumpCheck(a2, d);		
					a2 = temp;
					score += a[a2];
				}
				break;
			case 3:
				if(isEnd(a3)) return;
				else {
					if(isDuplicated(a3, a0, a1, a2, d)) return;

					int temp = jumpCheck(a3, d);
					a3 = temp;
					score += a[a3];
				}
				break;
			}
		}
		answer = Math.max(answer, score);
	}

	public static int jumpCheck(int v, int d) {
		int temp = v + d;
		
		if(v < 21) {
			if(temp >= 21) temp = 21;
		} else if(v < 30) {
			if(temp >= 30) temp = 30;
		} else if(v < 38) {
			if(temp >= 38) temp = 38;
		} else if(v < 47) {
			if(temp >= 47) temp = 47;
		}	

		if(temp == 5) return 22;
		if(temp == 10) return 31;
		if(temp == 15) return 39;

		return temp;
	}

	public static boolean isEnd(int idx) {
		return (idx==21) || (idx==30) || (idx==38) || (idx==47);
	}
	
	public static boolean isDuplicated(int p, int p1, int p2, int p3, int d) {
		//도착점을 초과하는 위치
		if(p < 21 && p+d >= 21) return false;
		else if(p < 30 && p+d >= 30) return false;
		else if(p < 38 && p+d >= 38) return false;
		else if(p < 47 && p+d >= 47) return false; 

		//5, 10, 15 번째는 점프가 발생하는 위치 파란색 
		int temp = p + d;
		if(temp == 5) temp = 22;
		if(temp == 10) temp = 31;
		if(temp == 15) temp = 39;
		
		//같은 선상에 있는지 체크
		if(temp == p1 || temp == p2 || temp == p3) return true;
		
		//25, 30, 35, 40 은 중복 공유위치
		if(a[temp] == 25) {
			if(a[p1] == 25 || a[p2] == 25 || a[p3] == 25) return true;
		} else if(a[temp] == 35) {
			if(a[p1] == 35 || a[p2] == 35 || a[p3] == 35) return true;
		} else if(a[temp] == 40) {
			if(a[p1] == 40 || a[p2] == 40 || a[p3] == 40) return true;
		} else if(a[temp] == 30) {
			if(temp == 39) {
				if(p1 == 39 || p2 == 39 || p3 == 39) return true;
			} else if(temp == 27){
				if(p1 == 27 || p2 == 27 || p3 == 27) return true;
				if(p1 == 35 || p2 == 35 || p3 == 35) return true;
				if(p1 == 44 || p2 == 44 || p3 == 44) return true;
			} else if(temp == 35) {
				if(p1 == 27 || p2 == 27 || p3 == 27) return true;
				if(p1 == 35 || p2 == 35 || p3 == 35) return true;
				if(p1 == 44 || p2 == 44 || p3 == 44) return true;
			} else if(temp == 44) {
				if(p1 == 27 || p2 == 27 || p3 == 27) return true;
				if(p1 == 35 || p2 == 35 || p3 == 35) return true;
				if(p1 == 44 || p2 == 44 || p3 == 44) return true;
			}
		}

		return false;
	}
}