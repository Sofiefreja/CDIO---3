package game;

public class Account {
	
	private int balance;
	
	public Account() {
		balance = 0;
	}
	
	public void deposit(int value) {
		balance += value;
	}
	
	public void pay(int value) {
		balance -= value;
	}
	
	public int getBalance() {
		return balance;
	}

}
