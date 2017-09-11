package codeground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//CodeGround 19번 최대구간중첩 :
/*
 * LIS tree[i] = 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이 , 세그먼트 트리 s~e : s-m / m+1 ~ e 2개
 * i    : 1 2 3 4 5 6 7 8
 * A[i] : 1 3 1 2 4 3 4 2
 * 
 * i       : 1 2 3 4 5
 * tree[i] : 0 0 0 0 0
 */
public class Sol19 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 1;

			int intervalSize = sc.nextInt();
			ArrayList<P19> list = new ArrayList<>();

			for(int i = 0 ; i < intervalSize ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list.add(new P19(a, b));
			}

			Collections.sort(list);	
			
			ArrayList<Integer> answer = new ArrayList<>();
			int first = -10_000_001;
			
			for(int i= list.size() -1 ; i >= 0 ; i--) {
				if(first <= list.get(i).y) {
					first = list.get(i).y;
					answer.add(first);
				} else {
					if(answer.contains(list.get(i).y)) {
						
					} else {
						first = list.get(i).y;
						answer.remove(answer.size()-1);
						answer.add(first);
					}
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(answer.size());
		}
	}


}

class P19 implements Comparable<P19>{
	int x;
	int y;

	public P19(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(P19 o) {
		if(this.x > o.x){
			return 1;
		} else if(this.x == o.x && this.y < o.y){
			return 1;
		}
		
		return -1;
	}
}