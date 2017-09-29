package SS;

import java.util.Scanner;

public class Snake10875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		n = 2*n + 1;
		
		int count = sc.nextInt();
		int [] num = new int[count];
		int [] direciton = new int[count];
		
		for(int i=0 ; i<count ; i++) {
			num[i] = sc.nextInt();
			String temp = sc.next();
			if("L".equals(temp)) direciton[i] = 0;	
			else direciton[i] = 1;	
		}
		
		sc.close();
	}
}
