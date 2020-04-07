package programmers.lv1;

import java.util.ArrayList;
import java.util.Stack;

public class DollGame {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		int row = board.length;
		Stack<Integer> stack = new Stack<>();

		for(int pos : moves) {
			pos = pos-1;

			for(int i=0 ; i<row ; i++) {
				if(board[i][pos] != 0) {
					int val = board[i][pos];

					if(!stack.isEmpty() && stack.peek() == val) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(val);
					}

					board[i][pos] = 0;					
					break;
				}
			}
		}		

		return answer;
	}
}
