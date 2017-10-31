package SS.sw_expert.d3;

import java.util.Scanner;

//단순 2진 암호코드 
public class P1240 {
	static String [] Code = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		
		for(int t=1 ; t<=testCase ; t++) {
			int col = sc.nextInt();
			int row = sc.nextInt();
			int sum = 0;
			int last = 0;
			int code = 0;
			
			String s = "";
			for(int i=0 ; i<col ; i++){
				String val = sc.next();
				if(val.contains("1")) {
					s = val;
				}
			}
			
			s = s.substring(s.lastIndexOf("1") - 56 + 1 , s.lastIndexOf("1")+1);
			
			for(int i=0 ; i<8 ; i++) {
				//System.out.println(s.substring(7*i, 7*(i + 1)));
				String val = s.substring(7*i, 7*(i + 1));
				
				for(int j=0 ; j<Code.length ; j++) {
					if(Code[j].equals(val)){
						if(i % 2 == 0) sum += j*3;
						else sum += j;
						
						code += j;
						break;
					}
				}
			}
 
            if(sum % 10 == 0) System.out.println("#" + t + " " + code);
            else System.out.println("#" + t + " " + 0);
		}

		sc.close();
	}
}