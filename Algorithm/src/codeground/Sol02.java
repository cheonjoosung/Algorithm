package codeground;
import java.util.Arrays;
import java.util.Scanner;

// 2번 프로그래밍 경진대회 
public class Sol02 {

	static int Answer;
 
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

			int num = sc.nextInt(); //¿¿Ω√¿⁄ ºˆ
			int [] arr = new int[num];

			for(int i=0 ; i < num ; i++ ) 
				arr[i] = sc.nextInt();

			Arrays.sort(arr);

			int foundIndex = -1;
			
			for(int i = 0 ; i < num ; i++) {
				if(arr[i] + num < arr[num-1] + 1) continue;
				
				boolean result = check(arr, i, num);
				
				if(result) {
					foundIndex = i;
					break;
				}
			}
			
			System.out.println(foundIndex);
			
			Answer = num - foundIndex;

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

	public static boolean check(int [] arr, int index, int size) {
		int temp = 1;
		boolean isCheck = false;

		for(int j = size-1 ; j >= index ; j--) {
			int last = arr[j] + temp++;
			int first = arr[index] + size;
			
			if( first >= last ) {
				isCheck = true;
			} else {
				isCheck = false;
				break;
			}
		}

		return isCheck;
	}



}
