package backjun.p4000_6000;

import java.util.Scanner;

//유니크 
public class P5533 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [][] a = new int[3][5];
		int [] score = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<3 ; j++) {
				a[j][i] = sc.nextInt();
			}
		}
		
		for(int i=0 ; i<3 ; i++) {			
			for(int j=0 ; j<n ; j++) {
				boolean isAdd = true;
				for(int k=0 ; k<n ; k++) {
					if(j == k) continue;
					if(a[i][j] == a[i][k]) {
						isAdd = false;
						break;
					}
				}
				if(isAdd) score[j] += a[i][j];
			}
		}
		
		for(int i=0 ; i<n ; i++) {
			System.out.println(score[i]);
		}
		
		sc.close();
	}
}
