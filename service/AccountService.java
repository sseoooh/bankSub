package service;

import java.util.ArrayList;

import domain.AccountBean;

public interface AccountService {

	//CREATE
	public void createAccount(int money); //계좌번호생성
	public String createAccountNum();
	//READ
	public ArrayList<AccountBean> findByAll(); //회원정보목록
	public AccountBean findByAccountNum(String accountNum);
	public int countNum();	//회원수보기
	public String findDate(); //날짜 가져오기
	//UPDATE
	public void depositMoney(String accountNum, int money);
	public void withdrawMoney(String accountNum, int money);
	//DELETE
	public void deleteAccount(String accountNum);
}
