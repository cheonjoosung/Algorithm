package SS.last;

import java.util.Scanner;

//아기 상어
public class Shark_16236 {
	static int [][] map;
	static int ans, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		
		map = new int[n][n];
		ans = 0;		
		
		/*
		 * 0은 빈칸, 1~6은 물고기의 크기, 9아기상어의 위치
		 * 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간 출력
		 * 조건1) 물고기가 1마리면 그 물고기를 먹으러 감
		 * 조건2) 물고기가 여러마리면 지나가는 칸의 개수가 최소에 있는 물고기
		 * 조건2-1) 근데 최소 거리에 있는 물고기가 여러마리면 가장위에 -> 가장왼쪽 순으로 선택
		 * 조건3) 이동하는데 1초씩 걸리고 먹는데는 시간이 소요되지 않음
		 * 조건4) 자신의 크기과 같은 물고기를 먹으면 1이 증가, 만약 2라면 두마리 먹어야 3이된다.
		 * 조건5) 이동할 때 물고기가 있는 위치는 갈수없음
		 * 조건6) 자신보다 큰 물고기를 먹을 수 없음
		 */
		
		for(int i=0 ; i<n ; i++) 
			for(int j=0 ; j<n ; j++)
				map[i][j] = sc.nextInt();
		
		System.out.println(ans);

		sc.close();
	}
}