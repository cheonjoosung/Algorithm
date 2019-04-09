package SS.last;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//큐빙
public class Qube_5373 {
	static int T; // 테스트케이스 수
	static int n; // 큐브를 돌린 횟수
	static char map[][];
	static char temp[];

	// U = 0, L = 1, F = 2, R = 3, B = 4, D = 5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++){

			initCube();
			n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");

			for(int i=0; i<n; i++){
				String input = st.nextToken();
				char m = input.charAt(0);
				char d = input.charAt(1);

				turn(m, d);

			}
			printUp();
		}
	}

	public static void turn(char m, char d){

		switch(d){
		case '+':
			turnMe(m);
			turnOther(m);
			break;
		case '-':
			turnMe(m);
			turnMe(m);
			turnMe(m);
			turnOther(m);
			turnOther(m);
			turnOther(m);
			break;
		}
	}

	public static void turnMe(char m){
		// m을 d방향으로 회전
		int idx = -1;
		// U = 0, L = 1, B = 2, R = 3, F = 4, D = 5
		switch(m){
		case 'U':
			idx = 0;
			break;
		case 'L':
			idx = 1;
			break;
		case 'F':
			idx = 2;
			break;
		case 'R':
			idx = 3;
			break;
		case 'B':
			idx = 4;
			break;
		case 'D':
			idx = 5;
			break;
		}


		char tempMap[] = {map[idx][6], map[idx][3], map[idx][0]
				, map[idx][7], map[idx][4], map[idx][1]
						, map[idx][8], map[idx][5], map[idx][2]};

		for(int i=0; i<9; i++){
			map[idx][i] = tempMap[i];
		}

	}

	public static void turnOther(char m){
		// m을 d방향으로 회전할 때 주변것들

		temp = new char[3];

		switch(m){
		case 'U':
			temp[0] = map[1][6];
			temp[1] = map[1][3];
			temp[2] = map[1][0];

			map[1][6] = map[2][0];
			map[1][3] = map[2][1];
			map[1][0] = map[2][2];

			map[2][0] = map[3][2];
			map[2][1] = map[3][5];
			map[2][2] = map[3][8];

			map[3][2] = map[4][0];
			map[3][5] = map[4][1];
			map[3][8] = map[4][2];

			map[4][0]= temp[0];
			map[4][1]= temp[1];
			map[4][2]= temp[2];

			break;
		case 'D':

			temp[0] = map[4][6];
			temp[1] = map[4][7];
			temp[2] = map[4][8];

			map[4][6] = map[3][0];
			map[4][7] = map[3][3];
			map[4][8] = map[3][6];

			map[3][0] = map[2][6];
			map[3][3] = map[2][7];
			map[3][6] = map[2][8];

			map[2][6] = map[1][8];
			map[2][7] = map[1][5];
			map[2][8] = map[1][2];

			map[1][8]= temp[0];
			map[1][5]= temp[1];
			map[1][2]= temp[2];

			break;

		case 'F':
			temp[0] = map[1][2];
			temp[1] = map[1][1];
			temp[2] = map[1][0];

			map[1][2] = map[5][2];
			map[1][1] = map[5][1];
			map[1][0] = map[5][0];

			map[5][2] = map[3][2];
			map[5][1] = map[3][1];
			map[5][0] = map[3][0];

			map[3][2] = map[0][6];
			map[3][1] = map[0][7];
			map[3][0] = map[0][8];

			map[0][6]= temp[0];
			map[0][7]= temp[1];
			map[0][8]= temp[2];

			break;

		case 'B':
			temp[0] = map[3][6];
			temp[1] = map[3][7];
			temp[2] = map[3][8];

			map[3][6] = map[5][6];
			map[3][7] = map[5][7];
			map[3][8] = map[5][8];

			map[5][6] = map[1][6];
			map[5][7] = map[1][7];
			map[5][8] = map[1][8];

			map[1][6] = map[0][2];
			map[1][7] = map[0][1];
			map[1][8] = map[0][0];

			map[0][2]= temp[0];
			map[0][1]= temp[1];
			map[0][0]= temp[2];

			break;


		case 'R':

			temp[0] = map[2][8];
			temp[1] = map[2][5];
			temp[2] = map[2][2];

			map[2][8] = map[5][8];
			map[2][5] = map[5][5];
			map[2][2] = map[5][2];

			map[5][8] = map[4][0];
			map[5][5] = map[4][3];
			map[5][2] = map[4][6];

			map[4][0] = map[0][8];
			map[4][3] = map[0][5];
			map[4][6] = map[0][2];

			map[0][8]= temp[0];
			map[0][5]= temp[1];
			map[0][2]= temp[2];

			break;

		case 'L':

			temp[0] = map[4][8];
			temp[1] = map[4][5];
			temp[2] = map[4][2];

			map[4][8] = map[5][0];
			map[4][5] = map[5][3];
			map[4][2] = map[5][6];

			map[5][0] = map[2][0];
			map[5][3] = map[2][3];
			map[5][6] = map[2][6];

			map[2][0] = map[0][0];
			map[2][3] = map[0][3];
			map[2][6] = map[0][6];

			map[0][0]= temp[0];
			map[0][3]= temp[1];
			map[0][6]= temp[2];

			break;
		}
	}

	public static void initCube(){

		map = new char[6][9];

		char myColor = ' ';

		for(int i=0; i<=5; i++){
			switch(i){
			case 0:
				myColor = 'w';
				break;
			case 1:
				myColor = 'g';
				break;
			case 2:
				myColor = 'r';
				break;
			case 3:
				myColor = 'b';
				break;
			case 4:
				myColor = 'o';
				break;
			case 5:
				myColor = 'y';
				break;
			}


			for(int j=0; j<9; j++){
				map[i][j] = myColor;
			}
		}
	}

	public static void printUp(){

		for(int i=0; i<9; i++){
			System.out.print(map[0][i]);
			if(i%3 == 2){
				System.out.println();
			}
		}
	}
}