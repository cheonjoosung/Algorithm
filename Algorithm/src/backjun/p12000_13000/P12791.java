package backjun.p12000_13000;

import java.util.ArrayList;
import java.util.Scanner;

public class P12791 {
	static int [] a = {1967,1969 , 1970 ,1971 ,1972 ,1973 ,1973 ,1974 ,
			1975 ,1976 ,1977 ,1977 ,1979 ,1980 ,1983 ,1984 ,1987 ,1993 ,
			1995 ,1997 ,1999 ,2002 ,2003 ,2013 ,2016 ,};

	static String [] s = { "DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory", "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"
			, "AladdinSane", "PinUps", "DiamondDogs", "YoungAmericans", "StationToStation", "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps",
			"LetsDance", "Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling", "Hours", "Heathen", "Reality", "TheNextDay", "BlackStar"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<L12791> list = new ArrayList<>();

		for(int i=0 ; i<a.length ; i++) {
			int year = a[i];
			String name = s[i];
			list.add(new L12791(year, name));
		}

		int n = sc.nextInt();

		for(int i=0 ; i<n ; i++) {
			int from = sc.nextInt();
			int end = sc.nextInt();
			
			ArrayList<L12791> temp = new ArrayList<>();

			for(int j=from ; j<=end ; j++) {
				for(int k=0 ; k<list.size() ; k++) {
					if(list.get(k).year == j) {
						temp.add(new L12791(j, list.get(k).name));
					}
				}
			}
			
			System.out.println(temp.size());
			for(L12791 v : temp) System.out.println(v.year + " " + v.name);
		}


		sc.close();
	}
}

class L12791 {
	int year;
	String name;
	public L12791(int year, String name) {
		this.year = year;
		this.name = name;
	}
}
