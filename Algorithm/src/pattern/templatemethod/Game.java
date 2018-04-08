package pattern.templatemethod;

public abstract class Game {
	protected abstract String doSecurity(String string);
	protected abstract boolean authentication(String id, String password);
	protected abstract int authorization(String userName);
	protected abstract String connection(String info);

	public String requestConnection(String str) {
		String decodedInfo = doSecurity(str);
		String id = decodedInfo;
		String password = decodedInfo;
		String userName = decodedInfo;

		if(false == authentication(id, password)) {
			throw new Error("불일치");
		}

		int res = authorization(userName);

		switch(res) {
		case 0:
			System.out.println("매니져");
			break;
		case 1:
			System.out.println("회원");
			break;
		default :
			System.out.println("권한 없");
		}

		return connection(str);
	}
}
