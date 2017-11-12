package backjun.p1000_2000;

import java.util.Scanner;

//수 이어 쓰기 1 
public class P1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i=1 ; i<=n ; i++) {
			int count = 0;
			
			int temp = i;
			while(temp != 0) {
				temp = temp/10;
				count++;
			}
			sum += count;
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
