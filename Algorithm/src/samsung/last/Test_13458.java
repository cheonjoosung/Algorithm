package samsung.last;

import java.util.Scanner;

//백준 13458 시험감독 
public class Test_13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int [] arr = new int[size];
		
		for(int i=0 ; i<size ; i++) 
			arr[i] = sc.nextInt();
		
		int main = sc.nextInt();
		int sub = sc.nextInt();
		long total = 0;
		
		for(int i=0 ; i<size ; i++) {
			if(arr[i] - main >= 0) arr[i] -= main;
			else arr[i] = 0;
			
			total ++;
		}
		
		for(int i=0 ; i<size ; i++) {
			if(arr[i] % sub == 0) total += arr[i]/sub;
			else total += (arr[i]/sub) + 1;
		}
		
		System.out.println(total);

		sc.close();
	}
}