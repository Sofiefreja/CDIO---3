package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Account;

public class TestAccount {

	@Test
	public void test() {
		
		Account balance = new Account();
		
		balance.deposit(30000);
		
		assertEquals(balance.getBalance(),30000);
		
		balance.pay(10000);
		
		assertEquals(balance.getBalance(),20000);
		
	}

}
