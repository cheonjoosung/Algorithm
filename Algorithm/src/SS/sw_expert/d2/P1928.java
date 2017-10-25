package SS.sw_expert.d2;

import java.util.Base64.Decoder;
import java.util.Base64;
import java.util.Scanner;

//Base64 Decoder
public class P1928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1 ; t<= testCase ; t++) {
			String s = sc.next();
			
			Decoder decoder = Base64.getDecoder();
            byte[] decoderByte = decoder.decode(s);
            String answer = new String(decoderByte);
			System.out.println("#" + t + " " + answer);
		}
		
		sc.close();
	}
}
