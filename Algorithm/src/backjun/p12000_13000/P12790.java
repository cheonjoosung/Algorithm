package backjun.p12000_13000;

import java.util.Scanner;

//Mini Fantasy War
public class P12790 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1 ; t<=tc ; t++) {
			int hp = sc.nextInt();
			int mp = sc.nextInt();
			int attack = sc.nextInt();
			int defense = sc.nextInt();
			
			hp += sc.nextInt();
			mp += sc.nextInt();
			attack += sc.nextInt();
			defense += sc.nextInt();
			
			if(hp < 1) hp = 1;
			if(mp < 1) mp = 1;
			if(attack < 0) attack = 0;
			
			int sum = hp + 5*mp + 2*attack + 2*defense;
			System.out.println(sum);
			
		}
		
		
		sc.close();
	}
}
