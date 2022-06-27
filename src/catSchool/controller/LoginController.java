package catSchool.controller;

import catSchool.model.Admin;

public class LoginController {
	
	public static boolean validarLogin(String user, String password) {
		if(user.equals(Admin.getLogin()) && password.equals(Admin.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
		
	
}
