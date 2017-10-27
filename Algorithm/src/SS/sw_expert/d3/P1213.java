package SS.sw_expert.d3;

import java.util.Scanner;

//String
public class P1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		for(int t=1 ; t<=10 ; t++) {
			int n = sc.nextInt();
			String word = sc.next();
			String line = sc.next();
			int count = 0;
			
			for(int i=0 ; i<line.length()-word.length()+1 ; i++) {
				if(line.charAt(i) == word.charAt(0)) {
					boolean check = true;
					for(int j=0 ; j<word.length() ; j++) {
						if(word.charAt(j) != line.charAt(i+j)) {
							check = false;
							break;
						}
					}
					if(check) count++;
				}
			}
			
			System.out.println("#"+t+ " " + count);
		}
		
		sc.close();
	}
}