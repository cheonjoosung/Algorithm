package codeground;

import java.util.Scanner;

////CodeGround 8번 블럭 없애기
public class Sol08 {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

			int n = sc.nextInt();
			int [] arr = new int[n];

			for(int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int start = 0;
			
			//start 는 제일 왼쪽에 있는 라인으로써 1회 마다 사라짐
			//start = Math.min(arr[i], start) 의 의미는 제일 좌측이 되는 지점과 위에서 노출되어 사라지는 것 중 더 빨리 없어지는 경우를 찾기 위해서..
			//right 는 그 반대로 생각하면 됨 
			for(int i = 0; i < n; i++) {
				start++;
				//System.out.println(arr[i] + "  ,  " + start);
				arr[i] = Math.min(arr[i], start);
				start = Math.min(arr[i], start);
			}
			
			//for(int k : arr) {
			//	System.out.print(k + " ");
			//}
			
			start = 1;
			
			start = 0;
			for(int i = n-1 ; i >= 0 ; i--) {
				//System.out.println(arr[i] + "  ,  " + start);
				start++;
				arr[i] = Math.min(arr[i], start);
				start = Math.min(arr[i], start);
			}
			
			//for(int k : arr) {
			//	System.out.print(k + " ");
			//}
			
			
			for(int k : arr) {
				Answer = Math.max(Answer, k);
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
