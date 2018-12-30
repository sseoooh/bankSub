package controller;

import javax.swing.JOptionPane;
import service.*;



public class MemberController {
	public void start() {
		MemberService memberService = new MemberServiceImpl();
		/*
		 * Impl로 쓰는이유
		 */
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴]\n0.이전단계로\n"
					+ "1.회원가입\n"
					+ "2.내정보보기\n"
					+ "3.이름찾기\n"
					+ "4.아이디찾기\n"
					+ "5.회원수보기\n"
					+ "6.로그인하기\n"
					+ "7.비밀번호수정\n"
					+ "8.회원탈퇴\n")){
				case "0" :
					JOptionPane.showMessageDialog(null, "이전단계로");
					return;
				case "1" :
					
					memberService.createInfo(
							JOptionPane.showInputDialog("아이디"),
							JOptionPane.showInputDialog("이름"),
							JOptionPane.showInputDialog("비밀번호"),
							JOptionPane.showInputDialog("주민등록번호"));
					break;
				case "2" :
					JOptionPane.showMessageDialog(null, memberService.findAll());
					break;
				case "3" :
					break;
				case "4" :
					JOptionPane.showMessageDialog(null, memberService.findId(
							JOptionPane.showInputDialog("검색하실 아이디를 입력하세요")));
					break;
				case "5" :
					JOptionPane.showMessageDialog(null, "회원님과함께 가입한 인원은" + memberService.countMember()
							+"명 입니다");
					break;
				case "6" :
					if(memberService.login(
							JOptionPane.showInputDialog("아이디를 입력하세요"),
							JOptionPane.showInputDialog("비밀번호를 입력하세요"))) {
						JOptionPane.showMessageDialog(null, "로그인성공");
					}else {
						JOptionPane.showMessageDialog(null, "로그인실패");
					}
					break;
				case "7" :
					memberService.modifyPass(JOptionPane.showInputDialog("아이디를 입력하세요"),
							JOptionPane.showInputDialog("비밀번호를 입력하세요"),
							JOptionPane.showInputDialog("새로운 비밀번호를 입력하세요")
							);
				case "8" :
					memberService.deleteMember(
							JOptionPane.showInputDialog("아이디를 입력하세요"),
							JOptionPane.showInputDialog("비밀번호를 입력하세요"));
					
			}
		}
		
	}
}
