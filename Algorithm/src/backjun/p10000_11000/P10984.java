package backjun.p10000_11000;

import java.util.Scanner;

//내 학점을 구해줘
public class P10984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int tc=1 ; tc<=t ; tc++) {			
			int sum = 0;
			int n = sc.nextInt();
			double score = 0.0;
			
			for(int i=0 ; i<n ; i++) {
				int val = sc.nextInt();
				double temp = sc.nextDouble();
				
				sum += val;
				score += val*temp;
			}

			
			System.out.println(sum + " " + Math.round((score/sum)*10)/10.0);
		}

		sc.close();
	}
}
