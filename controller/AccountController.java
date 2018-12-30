package controller;

import javax.swing.JOptionPane;

import service.AccountService;
import service.AccountServiceImpl;

public class AccountController {
	public void start() {
		AccountService accountservice = new AccountServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴]\n0.종료\n"
					+ "1.입금하기"
					+ "2.계좌생성"
					+ "3.계좌정보보기"
					+ "4.계좌번호보기"
					+ "5.계좌소유숫자"
					+ "6.날짜보기"
					+ "7.입금하기"
					+ "8.출금하기"
					+ "9.계좌삭제하기")) {
			case"0":
				JOptionPane.showMessageDialog(null, "이전단계로");
				return;
			case "1" :
				accountservice.createAccount(
						Integer.parseInt(JOptionPane.showInputDialog("입금금액")));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, accountservice.createAccountNum());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null, accountservice.findByAll());
				break;
			case "4" :
				JOptionPane.showMessageDialog(null, accountservice.countNum()+"개를 보유하고 계십니다");
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, accountservice.findDate());
				break;
			case "6" :
				accountservice.depositMoney(
						JOptionPane.showInputDialog("계좌번호를 입력하세요"),
						Integer.parseInt(JOptionPane.showInputDialog("입금하실 금액을 입력하세요")));
				break;
			case "7" :
				accountservice.withdrawMoney(
						JOptionPane.showInputDialog("계좌번호를 입력하세요"),
						Integer.parseInt(JOptionPane.showInputDialog("출금하실 금액을 입력하세요")));
			case "8" :
				accountservice.deleteAccount(
						JOptionPane.showInputDialog("삭제할 계좌번호를 입력하세요"));
			}
		}
		
		
	}
}
