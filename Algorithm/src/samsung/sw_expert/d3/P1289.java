package samsung.sw_expert.d3;

import java.util.Scanner;

//원재의 메모리 복구하기 
public class P1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for(int t=1; t<=tc; t++) {
			String s = sc.next();
			String init = "";
			for(int i=0 ; i<s.length() ; i++) init += "0";
			int count = 0;
			int index = 0;

			while(!init.equals(s)) {
				//변형시키기 
				//System.out.println("Init : " + init + " " + s);

				if((init.charAt(index)+"").equals(s.charAt(index)+"")) {
					System.out.println("PASS");
					index++;
					continue;
				} else {
					char [] c = new char[init.length()];

					for(int i=0 ; i<c.length ; i++) c[i] = init.charAt(i);

					if(init.charAt(index) == '0') {
						for(int i=index ; i<c.length ; i++) c[i] = '1';
					} else {
						for(int i=index ; i<c.length ; i++) c[i] = '0';
					}

					String temp = "";
					for(int i=0 ; i<c.length ; i++) {
						temp += c[i];
					}
					init = temp;				
				}

				index++;
				count++;
			}

			System.out.println("#" + t + " " + count);
		}

		sc.close();
	}
}