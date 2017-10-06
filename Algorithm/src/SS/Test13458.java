package SS;

import java.util.Scanner;

public class Test13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int people = sc.nextInt();
		int [] p = new int[people];
		
		for(int i=0 ; i<people ; i++) {
			p[i] = sc.nextInt();
		}
		
		int main = sc.nextInt();
		int sub = sc.nextInt();

		long answer = 0;
		
		for(int i=0; i <people ; i++) {
			if(p[i] - main >= 0) {
				p[i] -= main; 
				answer++;
			} else {
				p[i] = 0;
				answer++;
			}
		}
		
		for(int i=0; i<people ; i++) {
			if(p[i] % sub == 0) {
				answer += p[i] / sub;
			} else {
				answer += (p[i] / sub) + 1;
			}
		}
		
		System.out.println(answer);
		
		
		sc.close();
	}
}
