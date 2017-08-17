package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
	static int Answer;
	static int MOD = 1_000_000_007;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int row = sc.nextInt();
			int col = sc.nextInt();
			int block = sc.nextInt();

			long [] road = new long[row];

			Arrays.fill(road, 1);

			List<Point> list = new ArrayList<>();

			for(int i=0 ; i<block ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				if(x>=1 && y>=1 && x <= row && y<= col)
					list.add(new Point(x-1, y-1));
				else { //장애물 체스판 바깥에 존재
					continue;
				}
			}

			for(int j = 0 ; j < col ; j++) {
				for(int i = 0 ; i < row ; i++) {
					//System.out.print("i : " + i + " , j : " + j + " ");

					if(j == 0) {
						if(list.contains(new Point(i, j))) {
							road[i] = -1;
						} else {
							if(i >= 1 && road[i-1] == -1) {
								road[i] = -1;
							} else {
								road[i] = 1;
							}
						}
					} else {
						if(i == 0) {
							if(list.contains(new Point(i, j))) {
								//-1
								road[i] = -1;
							} else {
								if(road[i] == -1) {
									road[i] = -1;
								} else {
									road[i] = 1;
								}
							}
						} else {
							// i >= 1 && j >= 1 일 경우
							if(list.contains(new Point(i,j))) {
								road[i] = -1;
							} else {
								/*
								 * 1. 위쪽 + 왼쪽 
								 * 2. 위쪽 
								 * 3. 왼쪽
								 */
								if(road[i] != -1 && road[i-1] != -1) {
									long temp = road[i];
									temp += road[i-1];
									road[i] = (temp % MOD);
								} else if(road[i-1] == -1 && road[i] != -1) {
									road[i] = road[i];
								} else if(road[i-1] != -1 && road[i] == -1) {
									road[i] = road[i-1];
								} else {
									road[i] = -1;
								}
							}
						}
					}
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(road[row-1] % MOD);
		}
	}
}

class Point implements Comparable<Point>{
	int x;
	int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if(this.x > o.x){
			return 1;
		}else if(this.x == o.x && this.y > o.y){
			return 1;
		}
		return -1;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) return true;
		// 2. null 인지 체크 (모든 객체는 null과 동치 관계가 있지 않다.)
		if (obj == null) return false;
		// 3. 인자의 자료형이 정확한지 검사.
		if (!(obj instanceof Point)) return false;
		// 4. 자료형 변환
		Point p = (Point) obj;

		// 5. 중요 필드 점검
		return this.x == p.x && this.y == p.y;
	}
}

