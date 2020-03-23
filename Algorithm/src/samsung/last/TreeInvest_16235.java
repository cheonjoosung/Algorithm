package samsung.last;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//나무 제테크
public class TreeInvest_16235 {
	static int [][] curE, addE, tempE;
	static int ans;
	static int [] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int [] dy = {1, 1, 0, -1, -1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); //배열사이즈
		int m = sc.nextInt(); //m개의 나무 심기
		int k = sc.nextInt(); //년도 

		curE = new int[n][n]; //현재 양
		addE = new int[n][n]; //매년 추가되는 양
		tempE = new int[n][n]; //나무가 죽고 변하는 것에 의해 추가되는 양

		for(int [] tempArr : curE)
			Arrays.fill(tempArr, 5);
		
		ans = 0;

		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				addE[i][j] = sc.nextInt();				

		PriorityQueue<Tree> q = new PriorityQueue<>();

		for(int i=0 ; i<m ; i++) {
			int x = sc.nextInt(); //x좌표
			int y = sc.nextInt(); //y좌표 
			int age = sc.nextInt(); //나이

			q.add(new Tree(x-1, y-1, age));
		}

		for(int i=1 ; i<=k ; i++) {
			PriorityQueue<Tree> tempQ = new PriorityQueue<>();
			
			while(!q.isEmpty()) {
				Tree t = q.poll();

				if(t.age <= curE[t.x][t.y]) {
					curE[t.x][t.y] -= t.age;
					t.age++;
					
					if(t.age % 5 == 0) {
						for(int d=0 ; d<8 ; d++) {
							int nx = t.x + dx[d];
							int ny = t.y + dy[d];
							
							if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
							tempQ.add(new Tree(nx, ny, 1));
						}
					}
					tempQ.add(t);
				} else {
					tempE[t.x][t.y] += (t.age/2);
				}
			}
			
			q.addAll(tempQ);
			
			for(int x=0 ; x<n ; x++) 
				for(int y=0 ; y<n ; y++)
					curE[x][y] += addE[x][y] + tempE[x][y];
			
			for(int [] tempArr : tempE) 
				Arrays.fill(tempArr, 0);
		}

		ans = q.size();
		System.out.println(ans);

		sc.close();
	}
}

class Tree implements Comparable<Tree> {
	int x; int y; int age;
	Tree(int x, int y, int age) {
		this.x = x; this.y=y; this.age=age;
	}

	@Override
	public int compareTo(Tree o) {
		return Integer.compare(this.age, o.age);
	}
}