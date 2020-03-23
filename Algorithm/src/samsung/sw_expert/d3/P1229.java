package samsung.sw_expert.d3;

import java.util.ArrayList;
import java.util.Scanner;

//암호문 3
public class P1229 {
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
            	
            	if(s.equals("I")){
            		int index = sc.nextInt();
                	int count = sc.nextInt();
                	
            		for(int j=0 ; j<count ; j++) {
                		int val = sc.nextInt();
                		list.add(index++, val);
                	}
            	} else if(s.equals("D")) {
            		int index = sc.nextInt();
                	int count = sc.nextInt();
                	
            		for(int j=0 ; j<count ; j++) {
            			list.remove(index);
            		}
            	} else if(s.equals("A")) {
                	int count = sc.nextInt();
            		for(int j=0 ; j<count ; j++) {
            			int val = sc.nextInt();
            			list.add(val);
            		}
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