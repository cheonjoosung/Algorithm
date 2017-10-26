package SS.sw_expert.d2;

import java.util.ArrayList;
import java.util.Scanner;

//아름이의 돌 던지기
public class P1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			int n = sc.nextInt();
			int count = 1;
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0 ; i<=9 ; i++) list.add(i);
			
			while(list.size() != 0) {
				int temp = n*count;
				
				while(temp != 0) {
					int val = temp % 10;
					if(list.contains(val))
						list.remove(list.indexOf(val));
					temp /= 10;
				}
				
				if(list.size() == 0) System.out.println("#" + t + " " + n*count);
				count++;
			}
			
			
		}
		
		sc.close();
	}
}
