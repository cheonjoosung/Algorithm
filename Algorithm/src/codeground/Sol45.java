package codeground;
import java.util.Arrays;
import java.util.Scanner;

//45번 수강신청
public class Sol45 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			
			int num = sc.nextInt();
			int sum = sc.nextInt();
			
			int [] arr = new int[num];
			
			for(int i=0 ; i<num ; i++){
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for(int i = num-1 ; i >= 0 ; i--) {
				int max = 0;
				max += arr[i];
				
				if(max == sum) {
					Answer = max;
					break;
				}
				
				for(int j = i-1 ; j >= 0 ; j--) {
					if(max + arr[j] == sum) {
						Answer = max+arr[j];
						break;
					} else if(max + arr[j] > sum) {
						continue;
					} else {
						max += arr[j];
					}
				}
				
				if(Answer == sum) break;
				else {
					Answer = Math.max(Answer, max);
				}
			}
			
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
