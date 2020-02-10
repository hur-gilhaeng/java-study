package prob5;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println( this.getAccountNo() + " 계좌가 개설되었습니다.");
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int deposit) {
		balance-= deposit;
		System.out.println( this.getAccountNo() + " 계좌에 " + deposit + "만원이 출금되었습니다." );
	}

	public void save(int save) {
		balance+=save;
		System.out.println( this.getAccountNo() + " 계좌에 " + save + "만원이 입금되었습니다." );
	}
	
	
}