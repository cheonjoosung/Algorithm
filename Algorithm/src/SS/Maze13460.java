package SS;

import java.util.Scanner;

public class Maze13460 {
	static int [][] map;
	static int Ans;
	static int Blank = 0;
	static int Wall = 1;
	static int Red = 2;
	static int Blue = 3;	
	static int End = 4;	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int col = sc.nextInt();
		int row = sc.nextInt();

		map = new int[row][col];

		for(int i=0 ; i<col ; i++) {
			String s = sc.next();
			for(int k=0 ; k<s.length() ; k++) {
				if(s.charAt(k) == '#') map[k][i] = Wall;
				else if(s.charAt(k) == '.') map[k][i] = Blank;
				else if(s.charAt(k) == 'R') map[k][i] = Red;
				else if(s.charAt(k) == 'B') map[k][i] = Blue;
				else	 if(s.charAt(k) == 'O') map[k][i] = End;
			}

		}

		for(int i =0 ; i<col ; i++) {
			for(int j=0; j<row ; j++)
				System.out.print(map[j][i] + " ");
			System.out.println();
		}
		
		sc.close();
	}

}