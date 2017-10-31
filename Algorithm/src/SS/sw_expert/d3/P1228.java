package SS.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//암호문 1
public class P1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = 10;
		
		for(int t=1 ; t<=testCase ; t++) {
			int size = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=0 ; i<size ; i++) list.add(sc.nextInt());
			
			int num = sc.nextInt();
			
            for (int i = 0; i < num; i++) {
            	String s = sc.next();
            	int index = sc.nextInt();
            	int count = sc.nextInt();
            	
            	for(int j=0 ; j<count ; j++) {
            		int val = sc.nextInt();
            		list.add(index++, val);
            	}
            }
 
            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
		}

		sc.close();
	}
}