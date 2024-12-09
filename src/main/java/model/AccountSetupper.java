package model;

import dao.AccountDAO;
import jakarta.servlet.http.HttpServletRequest;

public class AccountSetupper {
	private String name;
	private String pass;
	private HttpServletRequest request;
	private AccountDAO adad;

	public AccountSetupper(HttpServletRequest request) {
		this.request = request;
		this.name = request.getParameter("name");
		this.pass = request.getParameter("pass");
		adad = new AccountDAO(name, pass);

	}

	public void exe() {
		if (adad.AccountCheck()) {
			if (login()) {
				System.out.println("ログイン成功");
			} else {
				System.out.println("ログイン失敗");
			}
		} else {
			register();
			System.out.println("アカウント登録完了");

		}
	}

	public boolean login() {
		if (pass.equals(adad.getPass(name))) {
			return true;
		}
		return false;
	}

	public void register() {
		adad.register();

		Account ac = new Account(name);


	}

}
