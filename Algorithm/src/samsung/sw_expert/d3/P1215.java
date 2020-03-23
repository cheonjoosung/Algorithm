package samsung.sw_expert.d3;

import java.util.Scanner;

//회문
public class P1215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int len = sc.nextInt();
			int count = 0;

			int [][] a = new int[8][8];
			
			for(int i=0; i<8 ; i++) {
				for(int j=0 ; j<= 8-len ; j++) {
					boolean b1 = true, b2 = true;
					for(int k=0 ; k<=len/2 ; k++) {
						if(a[i][k+j] != a[i][len-1-k+j]) b1 = false;
						if(a[k+j][i] != a[len-1-k+j][i]) b2 = false;
					}
					if(b1) count++;
					if(b2) count++;
				}
			}


			System.out.println("#"+t+ " " + count);
		}
		sc.close();
	}
}