package service;

import domain.MemberBean;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] members;
	private int count;

	public MemberServiceImpl() {
		this.members = new MemberBean[10];
		this.count = 0;
	}
/*
 *1번 회원가입
 */
	@Override
	public void createInfo(String id, String name, String ssn, String pass) {
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);
		memberBean.setName(name);
		memberBean.setPass(pass);
		memberBean.setSsn(ssn);
		members[count] = memberBean;
		count++;
		// 값을 돌려받지않는이유는 단순히 저장만하기때문?
	}

/*
 *2번 회원정보목록
 */
	@Override
	public MemberBean[] findAll() {
		return members;

	}
/*
 *3번 이름으로 내정보찾기
 */
	/**************************************************
	 * 질문하자!!!!!!!!!!!!!!!!!
	 **************************************************/
	@Override
	public MemberBean[] findName(String name) {
		 return null;
		 
/*
 *4번 아이디로 내정보찾기
 */ 
		

	}

	@Override
	public MemberBean findId(String id) {
		MemberBean memberBean = new MemberBean();
		for (int i = 0; i < count; i++) {
			if (members[i].getId().equals(id)) {
				memberBean = members[i];
				break;
			}
		}
		return memberBean;
	}
	/*
	 *5번 가입한 회원수 보기
	 */ 
	@Override
	public int countMember() {
		return count;
	}
	/*
	 *6번 로그인하기
	 */ 
	@Override
	public boolean login(String id, String pass) {
		boolean button = false;
		for(int i=0;i<count;i++) {
			if(members[i].getId().equals(id) && 
					members[i].getPass().equals(pass)) {
				button = true;
			}
		}
		return button;
	}
	/*
	 *7번 비밀번호수정하기
	 */ 
	/**************************************************
	 * 비밀번호변경질문 하단 members[i].setPass(newPass);
	 **************************************************/
	@Override
	public void modifyPass(String id, String pass, String newPass) {
		for(int i=0;i<count;i++) {
			if(login(id,pass)) {
				members[i].setPass(newPass);
				break;
			}
				
			}
		}
	/*
	 *8번 회원탈퇴하기
	 */ 
	/**************************************************
	 * 회원탈퇴질문 아예 이해불가, 삭제안돼요
	 **************************************************/

	@Override
	public void deleteMember(String id, String pass) {
		for(int i=0; i<count; i++) {
			if(login(id, pass)) {
				members[i] = members[count];
				members[count] = null;
				count--;
				break;
			
		}
	}

	}
}
