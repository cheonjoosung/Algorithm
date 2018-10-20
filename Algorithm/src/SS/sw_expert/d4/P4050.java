package SS.sw_expert.d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//4050번 재관이의 대량할인
public class P4050 {
	static int n, ans;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt();
			
			ans = 0;
			list = new ArrayList<>();
			
			for(int i=0 ; i<n ; i++)
				list.add(sc.nextInt());
			
			Collections.sort(list);
			Collections.reverse(list);
			
			for(int i=0 ; i<list.size() ; i++) {
				if(i%3 != 2) ans += list.get(i);
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}