package SS.sw_expert.d3;

import java.util.Scanner;

//두가지 빵의 딜레마
public class P5162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1 ; t<=tc ; t++) {
			int a = sc.nextInt(); //소수중에 n를 포함한 수
			int b = sc.nextInt();
			int c = sc.nextInt();

			int ans = 0;

			if(a < b) {
				int cnt = c/a;
				if(cnt > 0) {
					c -= a*cnt;
					ans += cnt;
					if(c != 0) {
						cnt = c/b;
						if(cnt != 0) ans += cnt;
					}
				}
			} else {
				int cnt = c/b;
				if(cnt > 0) {
					c -= b*cnt;
					ans += cnt;
					if(c != 0) {
						cnt = c/a;
						if(cnt != 0) ans += cnt;
					}
				}
			}


			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
}