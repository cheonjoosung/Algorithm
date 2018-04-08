package pattern;

import pattern.adapter.Adapter;
import pattern.adapter.AdapterImpl;
import pattern.templatemethod.Game;
import pattern.templatemethod.GameImpl;

public class Main {
	public static void main(String [] args) {
		Adapter adapter = new AdapterImpl();
		
		System.out.println(adapter.twiceOf(100f));
		System.out.println(adapter.halfOf(100f));
		
		Game g = new GameImpl();
		g.requestConnection("hi");
	}
}
