package test;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("HI 000");
			throw(new Exception());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("HI 111");
		}
		System.out.println("HI 222");
	}
	
}
