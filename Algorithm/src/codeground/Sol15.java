package codeground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//CodeGround 15번 캠퍼스와 도로(1)
public class Sol15 { static int Answer;

public static void main(String args[]) throws Exception    {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for(int test_case = 0; test_case < T; test_case++) {
        Answer = 0;

        int num = sc.nextInt();
        int roadSize = sc.nextInt();

        int [][] road = new int[num][num];

        ArrayList<Integer> moneyList = new ArrayList<>();

        for(int [] k : road)
            Arrays.fill(k, 99999999);

        for(int i=0 ; i<roadSize ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            road[start - 1][end - 1] = dist;
            road[end - 1][start - 1] = dist;

        }

        for(int i=1 ; i<=num ; i++)
            moneyList.add(i);

        /**
         * 로직을 짜보자
         */

        System.out.println("Case #"+(test_case+1));
        if(moneyList.size() < 0) {
            System.out.println(Answer);
        } else {
            String s = moneyList.size() + " ";
            for(int k : moneyList)
                s += k + " ";
            System.out.println(s.trim());
        }

    }
}}
