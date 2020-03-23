package samsung.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//2115번 모의 sw 역량테스트 벌꿀채취
public class P2115 {
	static int ans, n, m, c, max;
	static int [][] map;
	static ArrayList<Pos> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n =sc.nextInt();
			m = sc.nextInt(); //선택할 수 있는 벌통의 개수 1 < m < 5
			c = sc.nextInt(); //꿀을 채취할 수 있는 최대 양 10< c < 30

			map = new int[n][n];
			ans = 0;
			list = new ArrayList<>();

			for(int i=0; i<n ; i++) 
				for(int j=0 ; j<n ; j++)
					map[i][j] = sc.nextInt();

			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n-m+1 ; j++)
					calc(i, j);

			Collections.sort(list);

			ans += list.get(0).sum;
			int x = list.get(0).x;
			int y = list.get(0).y;

			for(int i=1 ; i<list.size() ; i++) {
				if(list.get(i).x == x) {
					if(Math.abs(list.get(i).y - y) >= m) {
						ans += list.get(i).sum;
						break;
					}
				} else {
					ans += list.get(i).sum;
					break;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}

	public static void calc(int x, int y) {
		int [] temp = new int[m];
		boolean [] visited = new boolean[m];

		int idx = 0;
		for(int i=y ; i<y+m ; i++)
			temp[idx++] = map[x][i];

		max = 0;
		dfs(0, temp, visited, x, y);
		list.add(new Pos(x, y, max));
	}

	public static void dfs(int i, int [] temp, boolean [] visited, int x, int y) {
		int val = 0;

		for(int j=0 ; j<visited.length ; j++) {
			if(visited[j]) {
				val += temp[j];
			}
		}

		if(val <= c) {
			int sum = 0;
			for(int j=0 ; j<visited.length ; j++) {
				if(visited[j]) sum += Math.pow(temp[j], 2);
			}
			max = Math.max(max, sum);
		}

		for(int j=i ; j<temp.length ; j++) {
			if(visited[j]) continue;

			visited[j] = true;
			dfs(j+1, temp, visited, x, y);
			visited[j] = false;
		}

	}
}

class Pos implements Comparable<Pos>{
	public int x,y,sum;
	Pos(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}

	@Override
	public int compareTo(Pos o) { //내림 차순
		if(o.sum > this.sum) return 1;
		else if(o.sum < this.sum) return -1;
		else return 0;
	}
}
