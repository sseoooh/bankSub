package controller;

import javax.swing.JOptionPane;

import service.AdminService;
import service.AdminServiceImpl;


public class AdminController {
	public void start() {
		AdminService adminservice = new AdminServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴]\n0.이전단계로\n"
					+ "1.관리자정보입력\n"
					+ "2.관리자정보보기\n"
					+ "3.권한찾기\n"
					+ "4.관리자번호찾기\n"
					+ "5.관리자수 보기\n"
					+ "6.관리자로그인\n"
					+ "7.관리자비밀번호변경\n"
					+ "8.관리자권한수정\n"
					+ "9.관리자삭제\n")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "이전단계로");
				return;
			case "1" :
				adminservice.createAdmin(
						JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("비밀번호"),
						JOptionPane.showInputDialog("직급"));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, adminservice.list());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null, adminservice.findByAuth(
						JOptionPane.showInputDialog("권한입력")));
				break;
			case "4" :
				JOptionPane.showMessageDialog(null, adminservice.findById(
						JOptionPane.showInputDialog("관리자번호입력")));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, adminservice.countAdmin()+"명 입니다");
				break;
			case "6" :
				if(adminservice.loginAuth(
						JOptionPane.showInputDialog("관리자번호를 입력하세요"),
						JOptionPane.showInputDialog("비밀번호를 입력하세요"))) {
					JOptionPane.showMessageDialog(null, "관리자 로그인에 성공하였습니다");
				}else {
					JOptionPane.showMessageDialog(null, "관리자권한에 접근할수없습니다");
					
				}
				break;
			case "7" :
				adminservice.modifyPass(
						JOptionPane.showInputDialog("관리자번호를 입력하세요"),
						JOptionPane.showInputDialog("비밀번호를 입력하세요"),
						JOptionPane.showInputDialog("바꿀비밀번호를 입력하세요"));
				break;
			case "8" :
				
				break;
			case "9" :
				adminservice.deleteAdmin(
						JOptionPane.showInputDialog("삭제시킬 관리자번호를 입력하세요"),
						JOptionPane.showInputDialog("비밀번호를 입력하세요"));
				break;
			}
		}
	}
}
