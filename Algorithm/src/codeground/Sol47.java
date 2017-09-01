package codeground;

import java.util.Arrays;
import java.util.Scanner;

public class Sol47 { 
    static int Answer;

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;

            int n = sc.nextInt();

            int [][][] val = new int[n][n][2];
            int [][][] res = new int[n][n][1201];

            for(int [][] k : res) {
                for(int [] m : k)
                    Arrays.fill(m, -1);
            }

            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    int temp = sc.nextInt();
                    check(val, i, j, temp);
                }
            }

            int baseTwo = val[0][0][0];
            int baseThree = val[0][0][1];
            res[0][0][baseThree] = baseTwo;

            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(i == 0 && j == 0) continue;

                    if(i == 0 && j != 0) {
                        for (int k = 1200 ; k >= 0; k--) {
                            if (res[j - 1][i][k] == -1) continue;
                            else {
                                int two = val[j][i][0];
                                int three = val[j][i][1];

                                res[j][i][k + three] = res[j - 1][i][k] + two;
                            }
                        }
                    } else if(i != 0 && j == 0) {
                        for(int k = 1200 ; k >= 0 ; k--) {
                            if (res[j][i - 1][k] == -1) continue;
                            else {
                                int two = val[j][i][0];
                                int three = val[j][i][1];

                                res[j][i][k + three] = res[j][i-1][k] + two;
                            }
                        }
                    } else {
                        for(int k = 1200 ; k >= 0 ; k--) {
                            int left = res[j-1][i][k];
                            int down = res[j][i-1][k];

                            int two = val[j][i][0];
                            int three = val[j][i][1];

                            if(left == -1 && down == -1) continue;

                            if(left != -1 && down == -1) {
                                if(res[j][i][k+three] == -1) {
                                    res[j][i][k+three] = left + two;
                                } else {
                                    res[j][i][k+three] = Math.max(res[j][i][k+three], left+two);
                                }
                            } else if(left == -1 && down != -1) {
                                if(res[j][i][k+three] == -1) {
                                    res[j][i][k+three] = down + two;
                                } else {
                                    res[j][i][k+three] = Math.max(res[j][i][k+three], down+two);
                                }
                            } else {
                                if(res[j][i][k+three] == -1) {
                                    int temp = Math.max(left + two, down + two);
                                    res[j][i][k+three] = temp;
                                } else {
                                    int temp = Math.max(left + two, down + two);
                                    res[j][i][k+three] = Math.max(res[j][i][k+three], temp);
                                }
                            }
                        }
                    }
                }
            }

            for(int k = 0 ; k <= 1200 ; k++) {
                int temp = res[n-1][n-1][k];
                if(temp != -1 ) {
                    // System.out.println(temp + " " + k);
                    int t = Math.min(k, temp);
                    Answer = Math.max(Answer, t);
                }

            }

            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }

    public static void check(int [][][] val, int x, int y, int temp) {

        while(temp != 0 && (temp%6 == 0)) {
            val[y][x][0]++;
            val[y][x][1]++;
            temp = temp/6;
        }

        while(temp != 0 && (temp%3 == 0) ) {
            val[y][x][1]++;
            temp = temp/3;
        }
        while(temp != 0 && (temp%2 == 0) ) {
            val[y][x][0]++;
            temp = temp/2;
        }
    }
}
