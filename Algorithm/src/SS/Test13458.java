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
		
		sc.close();
	}
}
