package samsung.last;

import java.util.Scanner;

//백준 14891 톱니바퀴
public class Gear_14891 {
	static int [] arr1 = new int[8];
	static int [] arr2 = new int[8];
	static int [] arr3 = new int[8];
	static int [] arr4 = new int[8];

	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Ans = 0;

		for(int i=0; i<4 ; i++) {
			String s = sc.next();
			for(int j=0 ; j<s.length() ; j++) {
				if(i==0) arr1[j] = Integer.parseInt(s.charAt(j)+"");
				if(i==1) arr2[j] = Integer.parseInt(s.charAt(j)+"");
				if(i==2) arr3[j] = Integer.parseInt(s.charAt(j)+"");
				if(i==3) arr4[j] = Integer.parseInt(s.charAt(j)+"");
			}
		}

		int count = sc.nextInt();

		for(int i=0 ; i<count ; i++) {
			int num = sc.nextInt();
			int dir = sc.nextInt();

			rotate(num, dir);
		}

		if(arr1[0] == 1) Ans +=1;
		if(arr2[0] == 1) Ans +=2;
		if(arr3[0] == 1) Ans +=4;
		if(arr4[0] == 1) Ans +=8;

		System.out.println(Ans);

		sc.close();
	}

	public static void rotate(int num, int dir) {
		switch(num) {
		case 1:
			if(arr1[2] != arr2[6]) {
				if(arr2[2] != arr3[6]) {
					if(arr3[2] != arr4[6]) {
						change(arr4, -dir);
					}

					change(arr3, dir);
				}

				change(arr2, -dir);
			}

			change(arr1, dir);
			break;
		case 2:
			if(arr2[6] != arr1[2]) {
				change(arr1, -dir);
			}

			if(arr2[2] != arr3[6]) {
				if(arr3[2] != arr4[6]) {
					change(arr4, dir);
				}

				change(arr3, -dir);
			} 

			change(arr2, dir);
			break;
		case 3:
			if(arr3[2] != arr4[6]) {
				change(arr4, -dir);
			}

			if(arr3[6] != arr2[2]) {
				if(arr2[6] != arr1[2]) {
					change(arr1, dir);
				}
				change(arr2, -dir);
			} 

			change(arr3, dir);
			break;
		case 4:
			if(arr4[6] != arr3[2]) {
				if(arr3[6] != arr2[2]) {
					if(arr2[6] != arr1[2]) {
						change(arr1, -dir);
					}

					change(arr2, dir);
				}

				change(arr3, -dir);
			}

			change(arr4, dir);
			break;
		}
	}
	
	public static void change(int [] arr, int dir) {
		if(dir == 1) {
			int temp = arr[arr.length-1];
			for(int i=arr.length-1 ; i>=1 ; i--)
				arr[i] = arr[i-1];
			arr[0] = temp;
		} else {
			int temp = arr[0];
			for(int i=0 ; i<arr.length-1 ; i++)
				arr[i] = arr[i+1];
			arr[arr.length-1] = temp;
		}
	}
}
