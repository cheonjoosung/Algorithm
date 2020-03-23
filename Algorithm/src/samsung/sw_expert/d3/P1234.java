package samsung.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//비밀번호 
public class P1234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = 10;
		
		for(int t=1 ; t<=testCase ; t++) {
			int n = sc.nextInt();
			String s = sc.next();

			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=0 ; i<n ; i++) {
				list.add(Integer.parseInt(s.charAt(i)+""));
			}
			
			
			for(int i=1 ; i<list.size() ; i++) {
				if(list.get(i) == list.get(i-1)) {
					list.remove(i-1);
					list.remove(i-1);
					i = 0;
				}
			}
 
            System.out.print("#" + t + " ");
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i));
            System.out.println();
		}

		sc.close();
	}
}