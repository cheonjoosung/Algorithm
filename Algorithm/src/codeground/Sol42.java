package codeground;

import java.util.Scanner;

//CodeGround 42번 부분배열
public class Sol42 {

	static int Answer;
	static int Sum;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			int size = sc.nextInt();
			Sum = sc.nextInt();

			int [] arr = new int[size];
			int [] partSumArr = new int[size];
			
			Answer = 0;
			
			for(int i=0 ; i<size ; i++) {
				arr[i] = sc.nextInt();
			}
			
			partSumArr[0] = arr[0]; //partSum 이랑 arr 이의 누적값을 저장하기 위한 변수, part 1 = arr0+arr1, part2 = arr0+arr1+arr2 이런식으로
			int indexOverSum = 0; 
			
			for(int i=1; i<size ; i++) {
				partSumArr[i] = partSumArr[i-1] + arr[i];
				if(partSumArr[i] >= Sum && indexOverSum == 0) {
					indexOverSum = i;   
					// 누적값중에 Sum 을 넘어가는 index 를 찾는다. 범위를 줄이기 위해서 시작지점을 0이 아닌 넘어가는 시점부터 계
				}
			}
			
			int k = 0;
			for(int i=indexOverSum ; i < size ; i++) {
				
				/*
				 * Count 가 발견이 되었다면 누적값의 차를 구할 때 인덱스를 0부터 시작하는 것이 아니라 i에서(Count+1) 만큼 뺀 숫자부터 시작하면 된다.
				 * 최소 카운트를 찾는 것이기 때문에 3보다 큰 값을 구할 필요는 없기 때문이다. 
				 */
				if(Answer == 0) k = 0;
				else k = i-Answer-1;
				
				
				
				for(int j=k ; j <= i ; j++) {
					/*
					 * partSumArr[5] - partSumarr[2] >= sum 이라면 3,4,5 배열값의 합은 Sum 을 넘으므로 Count 는 3이 된다. 
					 */
					if(partSumArr[i] - partSumArr[j] >= Sum) {
						if(Answer == 0) Answer = (i-j);
						if(Answer > (i-j) ) Answer = (i-j);
						else continue;
					} else {
						break;
					}
				}
			}
			

			System.out.println("#testcase"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
