package codeground;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
        	 int k = sc.nextInt();
            BigInteger max = new BigInteger("1");
            
            for(int i=0; i<k; i++){
            	max = max.multiply(BigInteger.valueOf(2));
            }
            int total = 0;
			long min = 1;
			long num = 0;
			
			for(long i=1; ; i++){
				num = i;
				
				for(int j=0;j<k ;j++){
					if(num%2==0){
						num = num/2; 
						total++;
					}else if(num%2!=0 && num!=1){
						num = 3*num+1;
						total++;
					}else if(num==1){
						break;
					}
				}
				
				if(total==k && num==1 ){
					min = i;
					break;
				}
				total=0;
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(min+" "+max);
		}
	}}
