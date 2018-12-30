package service;

import domain.MemberBean;

public interface MemberService {

	/*
	 * CREATE
	 */
	public void createInfo(String id, String name, String ssn, String pass);
	/*
	 * READ
	 */
	public MemberBean[] findAll();
	public MemberBean[] findName(String name);
	public MemberBean findId(String id);
	
	public int countMember();
	
	public boolean login(String id, String pass);
	/*
	 * UPDATE
	 */
	public void modifyPass(String id, String pass, String newPass);
	/*
	 * DELETE
	 */
	public void deleteMember(String id, String pass);
}
