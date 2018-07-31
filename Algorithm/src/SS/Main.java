package SS;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int row, col, Ans, Block;
	static int [][] arr;
	static boolean [][] visited;
	
	public static void main(String [] args) {
		int [] arr = new int[4];
		int [] copyArr = new int[4];
		
		int [][] arr2 = new int[4][4];
		int [][] copyArr2 = new int[4][4];
		
		/*
		 * 1차원 배열 카피
		 */
		Arrays.fill(arr, 1);
		copyArr = arr.clone();
		
		/*
		 * 2차원 배열 카피
		 */
		
		for(int i=0 ; i<arr2.length ; i++)
			copyArr2[i] = arr2[i].clone();
		
	}
}
