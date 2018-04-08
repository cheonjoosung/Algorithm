package pattern.templatemethod;

public class GameImpl extends Game{

	@Override
	public String doSecurity(String string) {
		System.out.println("decode");
		return string;
	}

	@Override
	public boolean authentication(String id, String password) {
		return true;
	}

	@Override
	public int authorization(String userName) {
		return 1;
	}

	@Override
	public String connection(String info) {
		return "good";
	}
}
