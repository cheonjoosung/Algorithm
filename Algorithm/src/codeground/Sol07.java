package codeground;

import java.util.Scanner;

//7번 좋은수 
public class Sol07 {
	static int Answer;
	
	public static void main(String args[]) throws Exception {
		int T;
		int test_case;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			Answer = 0;
			
			int n = sc.nextInt();
			
			int[] num = new int[n];
			
			for(int i=0; i<n; i++){
				num[i] = sc.nextInt();
			}

			int[] p = new int[400001]; //범위가 -20만 ~ 20만 이므로 -10+-10만 은 -20만 
			
			for(int a=0 ; a<n ; a++) {
				boolean found = false;
				for(int b=0; b<a && !found ; b++) {
					if(p[num[a]-num[b] + 200000] == 1) { 
						// 좋은 수 예정자 a 와 어떤 수 b 와의 차이가 p[] 배열중 어떤 두수의 합으로 된적이 있다면 발견이 된 거임
						// 결국 좋은 수는 = b + (a-b) 의 차가 됨. 여기서 b는 존재하므로 (a-b) 의 값이 이전의 두수의 합으로 이루어진지만 체크하면 됨
						found = true;
					}
				}
				
				for(int b=0; b<=a ; b++) {
					p[num[a]+num[b]+200000] = 1; //더한값의 배열이 존재하면 1
				}
				
				if(found) Answer++;
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(Answer);
		}
		sc.close();
	}
}
