package test;

import dao.AccountDAO;

public class AccountCheckTest {

	public static void main(String[] args) {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String name = "neko";
		String pass = "1234";
		AccountDAO acdao = new AccountDAO(name, pass);
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		System.out.println(acdao.getPlanet());
	}

	
}
