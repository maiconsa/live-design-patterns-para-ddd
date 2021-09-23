package ddd.entity;

import java.math.BigDecimal;

public class AccountBuilder {
	private String bank;
	
	private String branch;
	private  String account;

	private String document;
	public AccountBuilder(String document) {
		
		this.document = document;
	}
	
	public AccountBuilder  bank(String bank) {
		this.bank = bank;
		return this;
	}
	
	public AccountBuilder  branch(String branch) {
		this.branch = branch;
		return this;
	}
	
	
	public AccountBuilder  account(String account) {
		this.account = account;
		return this;
	}
	
	
	public Account build(){
		Account account = new Account(this);
		return account;
	}

	public String getBank() {
		return bank;
	}

	public String getBranch() {
		return branch;
	}

	public String getAccount() {
		return account;
	}

	public String getDocument() {
		return document;
	}
	
}
