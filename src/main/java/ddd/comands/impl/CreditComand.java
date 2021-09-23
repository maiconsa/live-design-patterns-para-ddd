package ddd.comands.impl;

import ddd.comands.FinanceComand;
import ddd.entity.FinanceOperation;

public class CreditComand implements FinanceComand {

	private String accountDocument ;
	
	private double ammount;
	
	public CreditComand(String accountDocument ,double ammount) {
		this.accountDocument = accountDocument;
		this.ammount  = ammount;
	}
	
	
	@Override
	public FinanceOperation operation() {
		return FinanceOperation.CREDIT;
	}

	@Override
	public double ammount() {
		return ammount;
	}


	@Override
	public String documentAccountFrom() {
		throw new RuntimeException("Forbiden method");
	}
	
	@Override
	public String documentAccountTo() {
		return accountDocument;
	}

}
