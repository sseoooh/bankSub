package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import domain.AdminBean;

public class AdminServiceImpl implements AdminService {
	private HashMap<String, AdminBean> map;
	private int seq;
	
	public AdminServiceImpl() {
		/*
		 * HashMap map = new Hashmap<>();쓰면 안되는이유?
		 */
		map = new HashMap<>();
		seq = 1000;
	}
/*
 *1.관리자정보입력 
 */
	@Override
	public void createAdmin(String name, String pass, String auth) {
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminNum(String.valueOf(seq));
		adminBean.setAuth(auth);
		adminBean.setName(name);
		adminBean.setPass(pass);
		map.put(adminBean.getAdminNum(), adminBean);
		seq++;
		/*
		 * adminBean객체를 adminBean.getAdminNum()에 연결하여 저장한다는뜻???
		 * 그리고왜 set이 아닌 get을 쓰는가?
		 */
	}

	/*
	 *1.관리자정보보기 
	 */
	@Override
	public ArrayList<AdminBean> list() {
		ArrayList<AdminBean> list = new ArrayList<>();
		list.addAll(map.values());
		return list;
		/* 형태
		 * addAll은  boolean인데 왜사용가능?
		 * 그리고 형태가 ex)int index, object element아니고 map.values()이렇게써도되는이유는?
		 */
	}
	
	
	/*
	 *3.권한찾기?????????????
	 */
	/*
	 * set<key> set?map느낌?
	 * Set<String> set = map.keySet();이뜻은
	 * map에 저장된 모든 String객체를 set으로 반환한다는 말?
	 */
	@Override
	public ArrayList<AdminBean> findByAuth(String auth) {
		ArrayList<AdminBean> list = new ArrayList<>();
		Set<String> set = map.keySet();
		/**
		 * for each loop 이라고 합니다.
		 * Set은 인덱스가 없어요...
		 * 그래서 int i=0 이런식으로 못돌립니다.
		 * 그래서 아래처럼 for를 돌립니다. 
		 * */
		for(String key : set) {
			if(auth.equals(map.get(key).getAuth())) {
				list.add(map.get(key));
			}
		}
		return list;
	}
	/*
	 *4.관리자번호찾기
	 */
/*************************************************
 * 결과안나오는이유
 *************************************************/
	@Override
	public AdminBean findById(String adminNum) {
		return map.get(adminNum);
		/*
		 * String adminNum의 대응하는 즉 회원정보를 찾아서 map에 넣는다?
		 * adminNum을 찾으면 모든정보가 나올텐데 어떻게 id만 return할수있나?
		 * jopt에서 id입력할때 파라미터로 받기때문?
		 */
	}

	/*
	 *5.관리자수보기 
	 */
	@Override
	public int countAdmin() {
		return seq;
		/*
		 * seq로 받으면 안되는건가?
		 * map.size();로 무조건?
		 */
	}
	
	/*
	 *6.관리자로그인 
	 */
	@Override
	public boolean loginAuth(String adminNum, String pass) {
		boolean button = false;
		if(map.containsKey(adminNum) && map.get(adminNum).getPass().equals(pass)) {
			button = true;
		}
		/*
		 * adminNum와 일치하는 map의 key객체를 찾고 map안에 adminNum의 값 패스워드의 값이 동일하다면??
		 * ?????????????
		 */
		return button;
	}
	/*
	 *7.관리자비밀번호변경 
	 */
	@Override
	public void modifyPass(String adminNum, String pass, String newPass) {
		/*
		 * for를 안돌려도되는이유??????	
		 */
		if(map.containsKey(adminNum) && map.get(adminNum).getPass().equals(pass)) {
				map.get(adminNum).setPass(newPass);
			}
		}
	
	/*
	 *8.관리자권한수정 
	 */
	@Override
	public void modifyAuth(String adminNum, String auth) {
		/*
		 * 정확히 auth는 무엇을 말하는가?
		 *두개만 입력하는데 뭐가 업데이트될수있는가?/
		if(map.containsKey(adminNum)) {
			map.get(adminNum).setAuth(auth);
		}
	}
	/*
	 *9.관리자삭제
	 */
	}
	@Override
	public void deleteAdmin(String adminNum, String pass) {
		map.remove(adminNum);
	}

}
