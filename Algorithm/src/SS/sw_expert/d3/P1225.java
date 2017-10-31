package SS.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//암호생성기
public class P1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = 10;
		
		for(int t=1 ; t<=testCase ; t++) {
			int num = sc.nextInt();
			int n = 1;
			
			ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 8; i++)
                list.add(sc.nextInt());
 
            while (list.get(7) != 0) {
                list.add(list.get(0) - (n++));
                list.remove(list.get(0));
                if (n == 6) n = 1;
                if (list.get(7) < 0) {
                    list.add(7, 0);
                    break;
                }
            }
 
            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
		}

		sc.close();
	}
}