package backjun.etc;

import java.util.Arrays;
import java.util.Scanner;

public class P6359 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		int [] test = new int[testCase];

		for(int i=0 ; i<testCase ; i++) 
			test[i] = sc.nextInt();

		for(int i=0 ; i<testCase ; i++) {
			int val = test[i];
			int [] arr = new int[val+1];
			Arrays.fill(arr, 1); //0 : closed // 1 : oepn

			for(int round = 2 ; round<=val ; round++) {
				for(int j=1 ; j<= val ; j++) {
					if(j % round == 0) {
						if(arr[j] == 0) arr[j] = 1;
						else arr[j] = 0;
					}
				}
			}

			int count = 0;
			for(int j = 1 ; j<=val ; j++)
				if(arr[j] == 1) count++;
				
			System.out.println(count);
		}

		sc.close();
	}
}
