package SS.Winter2017;

import java.util.Scanner;

/*
 * 
2
0 1 0 1 0 1 1 1
1 1 1 0 0 1 0 0
1 1 0 1 0 1 0 0
1 1 1 0 0 1 0 0
1 -1
3 1
 */
public class Sol_1 {
	static int Ans;
	static int [] arr1, arr2, arr3, arr4;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Ans = 0;
		arr1 = new int[8]; arr2 = new int[8]; arr3 = new int[8]; arr4 = new int[8];	
		
		for(int i=0; i<8 ; i++) arr1[i] = sc.nextInt();
		for(int i=0; i<8 ; i++) arr2[i] = sc.nextInt();
		for(int i=0; i<8 ; i++) arr3[i] = sc.nextInt();
		for(int i=0; i<8 ; i++) arr4[i] = sc.nextInt();
		
		for(int i=0; i<n ; i++) {
			int num = sc.nextInt(); int dir = sc.nextInt(); 
			rotate(num, dir); // dir 1 은 시계, -1 은 반시계  몇번 톱니바퀴를 회전시킬지
		}
		
		//0의 위치가 1이면 합하기
		if(arr1[0] == 1) Ans += 1;
		if(arr2[0] == 1) Ans += 2;
		if(arr3[0] == 1) Ans += 4;
		if(arr4[0] == 1) Ans += 8;
		
		System.out.println(Ans);
		
		sc.close();
	}
	
	public static void rotate(int num, int dir) {
		switch(num){
		case 1:
			/*
			 * 1번이랑 2번 같으면 1번만 돌리면 됨.
			 * 1번이랑 2번 다르면 1번은 돌려놓고 2번과 3번 비교 같으면 2번만 회전 아니면... 쭉쭉
			 */
			if(arr1[2] == arr2[6]) change(arr1, dir);
			else {
				change(arr1, dir);
				if(arr2[2] == arr3[6]) change(arr2, -dir);
				else {
					change(arr2, -dir);
					if(arr3[2] == arr4[6]) change(arr3, dir);
					else {
						change(arr3, dir);
						change(arr4, -dir);
					}
				}
			}
			break;
		case 2:
			if(arr2[6] != arr1[2]) change(arr1, -dir);
			if(arr2[2] == arr3[6]) change(arr2, dir);
			else {
				change(arr2, dir);
				if(arr3[2] == arr4[6]) change(arr3, -dir);
				else {
					change(arr3, -dir);
					change(arr4, dir);
				}
			}
			break;
		case 3:
			if(arr3[2] != arr4[6]) change(arr4, -dir);
			if(arr3[6] == arr2[2]) change(arr3, dir);
			else {
				change(arr3, dir);
				if(arr2[6] == arr1[6]) change(arr2, -dir);
				else {
					change(arr2, -dir);
					change(arr1, dir);
				}
			}
			break;
		case 4:
			if(arr4[6] == arr3[2]) change(arr4, dir);
			else {
				change(arr4, dir);
				if(arr3[6] == arr2[2]) change(arr3, -dir);
				else {
					change(arr3, -dir);
					if(arr2[6] == arr1[2]) change(arr2, dir);
					else {
						change(arr2, dir);
						change(arr1, -dir);
					}
				}
			}
			break;
		}
	}
	
	public static void change(int [] arr, int dir) {
		if(dir == 1) {
			int temp = arr[7];
			for(int i=arr.length-1; i>=1 ; i--) arr[i] = arr[i-1];
			arr[0] = temp;
		} else {
			int temp = arr[0];
			arr[0] = arr[1];
			for(int i=1; i<arr.length-1 ; i++) arr[i] = arr[i+1];
			arr[7] = temp;
		}
	}
}
