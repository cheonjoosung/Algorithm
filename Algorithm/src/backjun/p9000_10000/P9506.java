package backjun.p9000_10000;

import java.util.ArrayList;
import java.util.Scanner;

//약수들의 합
public class P9506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			if(n == -1) break;

			ArrayList<Integer> list = new ArrayList<>();
			int sum = 0;
			
			for(int i=1 ; i<n ; i++) {
				if(n % i == 0) {
					list.add(i);
					sum += i;
				}
			}
			
			if(sum == n) {
				System.out.print(n + " = ");
				for(int i=0 ; i<list.size() ; i++) {
					System.out.print(list.get(i));
					if(i != list.size()-1) System.out.print(" + ");
				}
				System.out.println();
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}
		
		sc.close();
	}
}
