package SS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Snake10875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = n;
		int y = n;
		int d = 1; // 0 북, 1 동 2 남 3 서 
		int answer = 0;
		
		int [][] arr = new int[200000000][200000000];
		
		/*
		int [][] visited = new int[2*n+1][2*n+1];
		
		for(int [] k : visited) 
			Arrays.fill(k, 0);
		visited[x][y] = 1;
		
		int answer = 0;
		int count = sc.nextInt();
		int [] num = new int[count];
		int [] direciton = new int[count];
		
		for(int i=0 ; i<count ; i++) {
			num[i] = sc.nextInt();
			String temp = sc.next();
			if("L".equals(temp)) direciton[i] = 0;	
			else direciton[i] = 1;	
		}
		
		int i = 0;
		boolean crash = false;
		
		while(!crash) {
			//System.out.println(x + " " + y + " : " + d + " , ans : " + answer) ;
			int move = num[i];
			
			if(d == 0) {
				for(int j=0; j<move ; j++) {
					//System.out.println("HI");
					if(y - 1 < 0) {
						answer++;
						crash = true;
						break;
					} else {
						y--;
						answer++;
						if(visited[x][y] == 1) {
							crash = true;
							break;
						} else {
							visited[x][y] = 1;							
						}
					}
				}
			} else if(d == 1) {
				for(int j=0; j<move ; j++) {
					if(x + 1 > 2*n) {
						answer++;
						crash = true;
						break;
					} else {
						x++;
						answer++;
						if(visited[x][y] == 1) {
							crash = true;
							break;
						} else {
							visited[x][y] = 1;							
						}
					}
				}
			} else if(d == 2) {
				for(int j=0; j<move ; j++) {
					if(y + 1 > 2*n) {
						answer++;
						crash = true;
						break;
					} else {
						y++;
						answer++;
						if(visited[x][y] == 1) {
							crash = true;
							break;
						} else {
							visited[x][y] = 1;							
						}
					}
				}
			} else {
				for(int j=0; j<move ; j++) {
					if(x - 1 < 0) {
						answer++;
						crash = true;
						break;
					} else {
						x--;
						answer++;
						if(visited[x][y] == 1) {
							crash = true;
							break;
						} else {
							visited[x][y] = 1;							
						}
					}
				}
			}
			
			if(direciton[i] == 0) d = ((d-1) + 4) % 4;
			else d = ((d+1) + 4) % 4;
			i++;
		}
		*/
		
		System.out.println(answer);
		
		sc.close();
	}
}
