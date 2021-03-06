package codeground;
import java.util.Scanner;

//Codeground 12번 방속의 거울 
public class Sol12 {
	static int Answer;
	static int n;
	static int count;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			count = 0;

			n = sc.nextInt();

			int [][] arr = new int[n][n];
			int [][] arrMirror = new int[n][n];
			
			int currentX = 0;
			int currentY = n-1;
			int direction = 1;

			sc.nextLine();

			for(int j=n-1 ; j>=0 ; j--) {
				String s = sc.nextLine();
				for(int i=0 ; i<n ; i++) {
					arr[i][j] = s.charAt(i) - '0';
					arrMirror[i][j] = 0;
				}
			}
			
			/*
			 * direction :  0 : 하 -> 상  //  1 : 좌 -> 우   //  2 : 상 -> 하   //  3 : 우 -> 좌
			 */
			while(true) {
				if(currentX < 0 || currentX >= n || currentY < 0 || currentY >= n) {
					break;
				}
				
				if(arr[currentX][currentY] == 1){
					if(arrMirror[currentX][currentY] == 0) {
						count++;
						arrMirror[currentX][currentY] = 1;
					}
					
					switch(direction) {
					case 0:
						currentX++;
						direction = 1;
						break;
					case 1:
						currentY++;
						direction = 0;
						break;
					case 2:
						currentX--;
						direction = 3;
						break;
					case 3:
						currentY--;
						direction = 2;
						break;
					}
					
				} else if(arr[currentX][currentY] == 2) {
					if(arrMirror[currentX][currentY] == 0) {
						count++;
						arrMirror[currentX][currentY] = 1;
					}
					
					switch(direction) {
					case 0:
						currentX--;
						direction = 3;
						break;
					case 1:
						currentY--;
						direction = 2;
						break;
					case 2:
						currentX++;
						direction = 1;
						break;
					case 3:
						currentY++;
						direction = 0;
						break;
					} 
					
				} else {
					switch(direction) {
					case 0:
						currentY++;
						break;
					case 1:
						currentX++;
						break;
					case 2:
						currentY--;
						break;
					case 3:
						currentX--;
						break;
					} 
				}
			}

			Answer = count;

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
