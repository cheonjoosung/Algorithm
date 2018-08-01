package SS.last;

import java.util.Scanner;

////백준 15684 사다리 조작
public class Ladder_15684 {
	static int n, m, h, Ans;
	static int [][] map;
	static int [] start;
	static int [] end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n가로선의 갯수(칼럼), m세로선의 갯수(로우), h세로선마다 가로선을 놓을수 있는 갯수
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt(); 
		
		start = new int[n];
		end = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			start[i] = sc.nextInt(); //사다리 타기 윗줄의 정보
			end[i] = sc.nextInt(); //사다리 타기 아랫줄의 정보
		}	
		
		//정답이 3보다 크거나 없으면 -1, 그렇지 않다면 최소값 출력
		System.out.println(Ans);
		
		sc.close();
	}
}
