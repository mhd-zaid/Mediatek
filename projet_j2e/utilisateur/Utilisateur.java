package utilisateur;

public class Utilisateur implements mediatek2021.Utilisateur {

	private static String login;
	private static String password;
	private Object[] data;
	
	
	public Utilisateur(String login, String password) {
		this.login = login;
		this.password = password;
	}
	public static String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String login() {
		
		return login;
	}

	@Override
	public String password() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public Object[] data() {
		// TODO Auto-generated method stub
		return data;
	}

}
