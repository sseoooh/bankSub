package service;

import java.util.ArrayList;

import domain.AdminBean;

public interface AdminService {
	public void createAdmin(String name, String pass, String auth);
	public ArrayList<AdminBean> list();
	public ArrayList<AdminBean> findByAuth(String auth);
	/*
	 * adminNum이유?
	 */
	public AdminBean findById(String adminNum);
	public int countAdmin();
	public boolean loginAuth(String adminNum, String pass);
	public void modifyPass(String adminNum, String pass, String newPass);
	public void modifyAuth(String adminNum, String auth);
	public void deleteAdmin(String adminNum, String pass);
	
}
