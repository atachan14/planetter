package test;

import dao.AccountDAO;

public class AccountCheckTest {

	public static void main(String[] args) {
		String name = "totakeke";
		String pass = "1234";
		AccountDAO acdao = new AccountDAO(name, pass);

		System.out.println(acdao.AccountCheck());
	}

	
}
