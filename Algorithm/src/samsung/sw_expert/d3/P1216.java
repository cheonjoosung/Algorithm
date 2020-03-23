package samsung.sw_expert.d3;

import java.util.Scanner;

//회문2
public class P1216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1 ; t<=10 ; t++) {
			int num = sc.nextInt();

			int [][] a = new int[100][100];
			int maxLen = 1;


			for(int i=0 ; i<100 ; i++) {
				String s = sc.next();
				for(int j=0 ; j<s.length() ; j++){
					if(s.charAt(j) == 'A') a[j][i] = 0;
					else if(s.charAt(j) == 'B') a[j][i] = 1;
					else a[j][i] = 2;
				}
			}

			for(int len=2 ; len <=100 ; len ++) {
				for(int i=0; i<100 ; i++) {
					for(int j=0 ; j<= 100-len ; j++) {
						boolean b1 = true, b2 = true;

						for(int k=0 ; k<=len/2 ; k++) {
							if(a[i][k+j] != a[i][len-1-k+j]) b1 = false;
							if(a[k+j][i] != a[len-1-k+j][i]) b2 = false;
						}

						if(b1 || b2)  {
							maxLen = len;
							continue;
						}
					}
				}
			}

			System.out.println("#"+t+ " " + maxLen);
		}

		sc.close();
	}
}