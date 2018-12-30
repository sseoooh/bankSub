package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import domain.AccountBean;
public class AccountServiceImpl implements AccountService{
	private ArrayList<AccountBean> list;
	//String accountNum;
	
	
	
	
	public AccountServiceImpl() {
		list = new ArrayList<>();
		//this.accountNum = "";
		
	}
/*
 * 	1.입금하기
 */
	@Override
	public void createAccount(int money) {
		AccountBean accountBean = new AccountBean();
		accountBean.setAccountNum(createAccountNum());
		accountBean.setMoney(money);
		accountBean.setToday(findDate());
		list.add(accountBean);
	}
	
	/*
	 * 	2.계좌생성
	 */
	@Override
	public String createAccountNum() {
		Random random = new Random();
		String accountNum = "";
		for(int i=0;i<10;i++) {
			if(i==1 || i==6) {
				accountNum += random.nextInt(10)+"-";
			}else {
				accountNum += random.nextInt(10)+"";
			}
		}
		return "회원님의 계좌번호는 : " + accountNum + "입니다.";
	}
	
	/*@Override
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
	}*/

	/*
	 * 	3.계좌정보보기
	 */
	@Override
	public ArrayList<AccountBean> findByAll() {
		return list;
	}

	
	
	/*
	 * 	4.계좌번호보기
	 */
	
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
	/*
	 * 	5.계좌소유숫자
	 */
	@Override
	public int countNum() {
		return list.size();
	}
	/*
	 * 	6.날짜보기
	 */
	@Override
	public String findDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일 \n HH:mm:ss");
		return sdf.format(date);
	}
	/*********************************************
	 * size는 list의 개수를 반환하는데 왜 계좌번호를 알수있는것인가?
	 * list.get(i).setMoney(list.get(i).getMoney()+money);???????????
	 *********************************************/
	/*
	 * 	7.입금하기
	 */
	/****************************************************
	 * 입금안되는이유?????????????
	 ****************************************************/
	@Override
	public void depositMoney(String accountNum, int money) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney()+money);
				break;
			}
		}
		
	}
	/*
	 * 	8.출금하기
	 */
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
	/*
	 * 	9.계좌삭제하기
	 */
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
