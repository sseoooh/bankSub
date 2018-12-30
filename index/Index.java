package index;

import javax.swing.JOptionPane;
import controller.*;



public class Index {
	public static void main(String[] args) {
		AccountController accountController = new AccountController();
		AdminController adminController = new AdminController();
		ArticleController articleController = new ArticleController();
		MemberController memberController = new MemberController();
		while(true) {
			switch(JOptionPane.showInputDialog("[관리자메뉴]\n0.종료\n"
					+ "1.계좌관리\n"
					+ "2.관리자\n"
					+ "3.게시판\n"
					+ "4.회원관리\n")) {
			case "0" :
				JOptionPane.showMessageDialog(null,"종료");
				return;
			case "1" :
				accountController.start();
				break;
			case "2" :
				adminController.start();
				break;
			case "3" :
				articleController.start();
				break;
			case "4" :
				memberController.start();
				break;
			}
		}
}
}
