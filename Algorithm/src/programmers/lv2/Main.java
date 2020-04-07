package programmers.lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
	public static void main(String [] args) {
		NewsCluster nc = new NewsCluster();
		System.out.println(nc.solution("FRANCE", "french"));
		System.out.println(nc.solution("handshake", "shake hands"));
		System.out.println(nc.solution("aa1+aa2", "AAAA12"));
		System.out.println(nc.solution("E=M*C^2", "e=M*c^2"));
	}
}