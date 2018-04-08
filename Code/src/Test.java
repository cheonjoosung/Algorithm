import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		int a = 1, b = 1;
		if(a++ == 1 & b++ == 1) System.out.println("1");
		System.out.println(a + " " + b);
		if(a == 1 && b++ == 2) System.out.println("2");
		
		System.out.println(a + " " + b);

		String temp = "HI";
		System.out.println(temp);
		stringTest(temp);
		System.out.println(temp);
		
		Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        String s1 = new String("one");
        String s2 = new String("one");

        StringBuffer sf1 = new StringBuffer("one");
        StringBuffer sf2 = new StringBuffer("one");
        

        System.out.println(i1.equals(i2));
        System.out.println(s1.equals(s2));
        System.out.println(sf1.equals(sf2));
        
        if(i1 == 1) System.out.println("good");
        if(a == 2) System.out.println("bad");
        if(s1 == "one") System.out.println("good1");
        if(s1.equals("one")) System.out.println("good12");
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(new Integer(1));
        System.out.println(list.remove(new Integer(2)));
        int [] arr = new int[4];
//        System.out.println();
	}
	
	public static void stringTest(String temp) {
		temp = "KKK";
		
	}
}