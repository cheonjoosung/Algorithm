package SS.sw_expert.test_sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//SWExpertAcademy 모의 SW 역량 테스트 보물상자 비밀번호
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
			
			list = new ArrayList<>();
			arr = new int[n];
			ans = 0;
			
			for(int i=0 ; i<n ; i++) {
				if(s.charAt(i) == 'A') arr[i] = 10;
				else if(s.charAt(i) == 'B') arr[i] = 11;
				else if(s.charAt(i) == 'C') arr[i] = 12;
				else if(s.charAt(i) == 'D') arr[i] = 13;
				else if(s.charAt(i) == 'E') arr[i] = 14;
				else if(s.charAt(i) == 'F') arr[i] = 15;
				else arr[i] = Integer.parseInt(s.charAt(i)+"");
			}
			
			for(int i=0; i<(n/4) ; i++) {
				int [] temp = new int[n];
				
				for(int j=0 ; j<n ; j++)
					temp[j] = arr[(j+i)%n];
				
				calc(temp);
			}
			
			ans = list.get(k-1);
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
	
	public static void calc(int [] temp) {
		for(int i=0 ; i<n; i=i+(n/4)) {
			int val = 0;
			int idx = (n/4)-1;
			
			for(int j=i ; j<i+(n/4) ; j++) {
				val += temp[j] * Math.pow(16, idx--);
			}
			
			if(false == list.contains(val)) 
				list.add(val);
		}
		
		Collections.sort(list);
		Collections.reverse(list);
	}
}