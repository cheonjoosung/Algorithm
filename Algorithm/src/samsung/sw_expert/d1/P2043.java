package samsung.sw_expert.d1;

import java.util.Scanner;

//서랍의 비밀번호
public class P2043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println((a-b+1));

		sc.close();
	}
}