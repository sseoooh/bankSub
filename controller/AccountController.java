package controller;

import javax.swing.JOptionPane;

import service.AccountService;
import service.AccountServiceImpl;

public class AccountController {
	public void start() {
		AccountService accountservice = new AccountServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴]\n0.종료\n"
					+ "1. 계좌생성"
					+ "2.")) {
			case"0":
				JOptionPane.showMessageDialog(null, "이전단계로");
				return;
			case "1" :
				JOptionPane.showMessageDialog(null, accountservice.createAccountNum());
			case "2" :
				JOptionPane.showMessageDialog(null, accountservice.findByAll());
			}
		}
		
		
	}
}
