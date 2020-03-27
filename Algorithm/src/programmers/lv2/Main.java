package programmers.lv2;

public class Main {
	public static void main(String [] args) {
		NDigitsGame game = new NDigitsGame();
		
		
		System.out.println(game.solution(2, 4, 2, 1));
		System.out.println(game.solution(16, 16, 2, 1));
		System.out.println(game.solution(16, 16, 2, 2));
		
	}
}
