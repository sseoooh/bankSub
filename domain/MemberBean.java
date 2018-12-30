package domain;

public class MemberBean {
	private String id,name,ssn,pass;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return " [아이디 : " + id + ", 이름 : " + name + ", 주민등록번호 : " + ssn + ", 비밀번호 : " + pass+ "]";
		
	
	}
}
