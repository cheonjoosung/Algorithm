package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
	static long Answer;
	static ArrayList<P54> oneList;
	static ArrayList<P54> moreList;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			int n = sc.nextInt();
			long sum = 0;

			oneList = new ArrayList<>();
			moreList = new ArrayList<>();

			for(int i=0; i<n ; i++) {
				int v = sc.nextInt();
				int br = sc.nextInt();

				sum += br;

				if(br == 1) {
					oneList.add(new P54(v, br));
				} else {
					moreList.add(new P54(v, br));
				}
			}

			Collections.sort(oneList);
			Collections.sort(moreList);

			if( (n-1) * 2 > sum) { //2 - 2개, 3 - 4개, 4 - 6개, 5 - 8개의 최소 연결지점이 필요.. 늘어날때마다 2씩 증가
				System.out.println("Case #"+(test_case+1));
				System.out.println(-1);
			} else {

				if(oneList.size() <= 0) {
					Answer = moreList.get(moreList.size() - 1).v - moreList.get(0).v;
				} else {

					while( oneList.size() > 0 && moreList.size() > 0) {
						findNearIsland(0);
					}

					if(moreList.size() > 1)
						Answer += moreList.get(moreList.size() -1).v - moreList.get(0).v;
				}

				System.out.println("Case #"+(test_case+1));
				System.out.println(Answer);
			}


		}
	}

	public static void findNearIsland(int index) {
		/*
		 * 1. v섬과 가장 가까운 교차지점의 섬을 찾는다.
		 * 2. 만약 그 섬의 카운트가 2라면 해당지점을 moreList 에서 없애고 oneList 에 추가한다.
		 * 3. 다리 연결했다면 oneList 에서는 제거하고 List 에서 그 섬의 다리 갯수 하나씩 제거 후 Answer 의 연결된 다리 길이 추가
		 */
		long minValue = Long.MAX_VALUE;
		long temp = 0;

		int v = oneList.get(index).v;

		int findIndex = -1;

		for(int i=0; i < moreList.size() ; i++) {
			temp = Math.abs(moreList.get(i).v - v);

			if(minValue > temp) {
				minValue = temp;
				findIndex = i;
			}
		}

		int findNearVertex = moreList.get(findIndex).v;

		Answer += Math.abs(findNearVertex-v);

		oneList.remove(0);
		moreList.get(findIndex).br--;

		if(moreList.get(findIndex).br == 1) {
			oneList.add(moreList.get(findIndex));
			moreList.remove(findIndex);
		}

		Collections.sort(oneList);
		Collections.sort(moreList);
	}
}