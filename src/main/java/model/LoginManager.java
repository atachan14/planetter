package model;

import dao.AccountDAO;
import model.data.AccountData;

public class LoginManager {
	private String name;
	private String pass;
	private AccountDAO acdao;

	public LoginManager(String name,String pass) {
//		this.session = request.getSession();
		this.name = name;
		this.pass = pass;
		this.acdao = new AccountDAO(name, pass);
	}

	public boolean loginCheck() {
		if (!acdao.AccountCheck()) {
			register();
		}

		if (pass.equals(acdao.getPass(name))) {
			System.out.println("ログイン成功");
			return true;
		} else {
			System.out.println("ログイン失敗");
			return false;
		}
	}
	
	public void register() {
		if (acdao.register()) {
			System.out.println("アカウント登録成功");
		} else {
			System.out.println("アカウント登録失敗");
		}
	}
	
	public AccountData getAccountData() {
		return acdao.getAll();
	}
}
