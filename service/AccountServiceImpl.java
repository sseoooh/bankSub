package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import domain.AccountBean;
public class AccountServiceImpl implements AccountService{
	private ArrayList<AccountBean> list;
	
	public AccountServiceImpl() {
		list = new ArrayList<>();
	}
	
	@Override
	public String createAccountNum() {
		Random random = new Random();
		String accountNum ="";
		for(int i=0;i<10;i++) {
			if(i==1 || i==6) {
				accountNum += random.nextInt(10)+"-";
			}else {
				accountNum += random.nextInt(10)+"";
			}
		}
		return "회원님의 계좌번호는 : " + accountNum + "입니다.";
	}

	@Override
	public ArrayList<AccountBean> findByAll() {
		return list;
	}

	/*********************************************
	 * size는 list의 개수를 반환하는데 왜 계좌번호를 알수있는것인가?
	 *********************************************/
	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean accountBean = new AccountBean();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				accountBean = list.get(i);
				break;
			}
		}
		return accountBean;
	}

	@Override
	public int countNum(int count) {
		return list.size();
	}

	@Override
	public String findDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/*********************************************
	 * size는 list의 개수를 반환하는데 왜 계좌번호를 알수있는것인가?
	 * list.get(i).setMoney(list.get(i).getMoney()+money);???????????
	 *********************************************/
	@Override
	public void depositMoney(String accountNum, int money) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney()+money);
				break;
			}
		}
		
	}

	@Override
	public void withdrawMoney(String accountNum, int money) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney()-money);
				break;
	}
		}
		}
	/*********************************************
	 * .dot 다음 remove자체가 삭제명령어인가?
	 *********************************************/
	@Override
	public void deleteAccount(String accountNum) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAccountNum().equals(accountNum)) {
				list.remove(i);
				break;
			}
		}
	}

	

}
