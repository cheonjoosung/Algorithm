package samsung.sw_expert.d4;

import java.util.Scanner;

//3289번 서로소 집합
public class P3289 {
	static int n, m;
	static String ans;
	static int [] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();

			parent = new int[n+1];
			for(int i=1 ; i<=n ; i++)
				parent[i] = i;
			
			ans = "";

			for(int i=0 ; i<m ; i++) {
				int op = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				if(op == 0) { //합집합
					union(a, b);
				} else { //둘이 같은 집합에 속하는지 비교
					if(isSameParent(a, b)) ans += "1";
					else ans += "0";
				}
			}

			System.out.println("#" + tc + " " + ans);

		}
		sc.close();
	}

	public static int find(int x) {
		if(x == parent[x])
			return x;
		else 
			return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		// 같은 부모를 가지고 있지 않을 때
		if(x != y) {
			// y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
			if(x<y) parent[y] = x;
			// 더 작은 값으로 넣어 줄 때 다음과 같이도 표현 가능
			/* 
            if(x < y) parent[y] = x;
            else parent[x] = y;
			 */
		}
	}
	//같은 부모 노드를 가지는지 확인
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y)
			return true;
		else
			return false;
	}
}