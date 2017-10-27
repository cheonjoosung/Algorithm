package SS.sw_expert.d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//조교의 성적 매기기 
public class P1983 {
	static String [] s = {"A+" , "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for(int t=1 ; t<= testCase ; t++) {			
			int n = sc.nextInt();
			int k = sc.nextInt();
			String ans = "";
			
			int p = n / 10; // 동일점수 부여

			ArrayList<Double> list = new ArrayList<>();

			for(int j=0 ; j<n ; j++)
				list.add(sc.nextInt()*0.35 + sc.nextInt()*0.45 + sc.nextInt()*0.2);
			
			double score = list.get(k-1);
			Collections.sort(list);
			Collections.reverse(list);
			
			for(int i=0 ; i<n ; i++)
				if(list.get(i) == score) ans = get(i , n);
			
			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
	
	public static String get(int i, int n) {
		for(int k=0; k<10; k++) {
            if(n/10*k<= i && i<n/10*(k+1)) return s[k];
        }
        return null;
	}
}
