package SS.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Scanner;

//보물상자 비밀번호
public class P5658 {
	static int [] arr;
	static ArrayList<Integer> list;
	static int n, k, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {
			n = sc.nextInt(); //총 숫자의 갯수 4의 배수
			k = sc.nextInt(); //내림차순 정렬 후 k번째로 큰 수(중복제거)
			String s = sc.next();
			
			arr = new int[n];
			ans = 0;
			
			for(int i=0 ; i<n ; i++) {
				if(s.charAt(i) == 'A') arr[i] = 10;
				else if(s.charAt(i) == 'B') arr[i] = 10;
				else if(s.charAt(i) == 'C') arr[i] = 10;
				else if(s.charAt(i) == 'D') arr[i] = 10;
				else if(s.charAt(i) == 'E') arr[i] = 10;
				else arr[i] = Integer.parseInt(s.charAt(i)+"");
			}
			
			for(int i=0; i<3 ; i++) {
				
			}
						
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

}
