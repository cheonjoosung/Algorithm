package backjun.p11000_12000;

import java.util.Scanner;

//남욱이의 닭장 
public class P11006 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int sum = sc.nextInt(); //총 다리 5             총 다리 7
			int n = sc.nextInt(); // 닭의 수 3  -> 6   닭의 수 5 -> 10
			
			int temp = 0;
			for(int i=1 ; i<=n ; i++) {
				temp = i*2 + (n-i);
				if(temp == sum) {
					System.out.println((n-i) + " " + i);
					break;
				}
			}			
		}
		
		
		
		sc.close();
	}
}