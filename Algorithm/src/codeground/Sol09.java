package codeground;
import java.util.ArrayList;
import java.util.Scanner;

// 9번 화학자의 문장
public class Sol09 {

	static int Answer;
	
	static ArrayList<String> list = new ArrayList<>();
	
	static String [] temp = { 
			"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
			"Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
			"Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr",
			"Y","Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
			"Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au",
			"Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg",
			"Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La", "Ce", "Pr", "Nd",
			"Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac",
			"Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
			"No", "Lr"
	};

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		listInit();
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			String line = sc.next();
			line.toLowerCase();
			
			boolean [] check = new boolean[line.length()+1];
			
			check[0] = true;
			check[1] = wordCheck(line.charAt(0)+"");
			
			for(int i=2 ; i <= line.length() ; i++) {
				check[i] = 
						(check[i-1] && wordCheck(line.charAt(i-1)+""))
								|| (check[i-2] && wordCheck(line.substring(i-2, i)));
			}
			
			System.out.println("Case #"+(test_case+1));
			if(check[line.length()]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
	}
	
	public static void listInit() {
		for(String val : temp) {
			val = val.toLowerCase();
			list.add(val);
		}
	}
	
	public static boolean wordCheck(String val) {
		if(list.contains(val)) return true;
		else return false;
	}

}
