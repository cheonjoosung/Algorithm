package backjun.p4000_6000;

import java.util.Scanner;

//유니크 
public class P5533 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [][] a = new int[n][3];
		
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<3 ; j++)
				a[i][j] = sc.nextInt();

		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<3 ; j++) {
				boolean isFound = false;
				for(int k=0 ; k<n ; k++) {
					if(i==k) continue;
					if(a[i][j] == a[k][j]) {
						a[k][j] = 0;
						isFound = true;
					}
				}
				if(isFound) a[i][j] = 0;
			}
		}
		
		for(int i=0 ; i<n ; i++) {
			System.out.println(a[i][0] + a[i][1] + a[i][2]);
		}
		
		sc.close();
	}
}
