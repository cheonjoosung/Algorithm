package SS.last;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//백준 15685 드래곤커브
public class DragonCurve_15685 {
	static int [][] Map;
	static int Ans, N, Cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Cnt = sc.nextInt();
		Ans = 0;
		N=101;

		Map = new int[N][N];

		for(int [] temp : Map)
			Arrays.fill(temp, 0);

		/*
		 * 네 꼭지점이 모두 드래곤 커브의 일부인 것의 개수
		 * 0 세대는 길이가 1인 선분
		 * k 세대는 k-1 세 드래곤 커브의 끝점을 기준으로 90도 시계 방향 회전 시킨 다음. 그것의 끝점을 이은것 
		 */
		
		for(int i=0 ; i<Cnt ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int dir = sc.nextInt(); //방향 0(오른쪽 x증가), 1(위로 y증가), 2(왼쪽 x감소), 3(아래로 y감)
			int g = sc.nextInt(); //세대
		
			ArrayList<Integer> directionList = new ArrayList<>();
			directionList.add(dir);
		
			/* 0 1 2 3 4 5 6 7
			 * 1 2 3 2 3 0 3 2 : i번째 위치는 n-i 위치의 디렉션에서 +1 값
			 * 세대가 변한다는 건 끝지점을 기준으로 이전의 세대를 90도 회전시킴
			 */
			for(int j=0 ; j<g ; j++) {
				int size = directionList.size();
				
				for(int k=size-1 ; k>=0 ; k--) {
					int d = directionList.get(k);
					directionList.add( (d+1) % 4);
				}
			}
			
			/*
			 * Direction 에 따라 이동시키기
			 */
			Map[x][y] = 1;
			for(int d : directionList) {
				if(d == 0) x++;
				else if(d == 1) y--;
				else if(d == 2) x--;
				else if(d == 3) y++;
			
				Map[x][y] = 1;
			}
		}

		/*
		 * (0,0) , (0,1) , (1,0), (1,1) 으로 각 점이 드래곤커브이면 +1
		 */
		for(int i=0 ; i<100 ; i++) {
			for(int j=0 ; j<100 ; j++) {
				if(Map[i][j] == 1 && Map[i+1][j] == 1 
						&& Map[i][j+1] == 1 && Map[i+1][j+1] == 1)
					Ans++;
			}
		}

		System.out.println(Ans);

		sc.close();
	}
}
