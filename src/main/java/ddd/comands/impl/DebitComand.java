package ddd.comands.impl;

import ddd.comands.FinanceComand;
import ddd.entity.FinanceOperation;

public class DebitComand implements FinanceComand {

	private String document;
	
	private double ammount;
	
	public DebitComand(String document ,double ammount) {
		this.document = document;
		this.ammount  = ammount;
	}
	
	
	@Override
	public FinanceOperation operation() {
		return FinanceOperation.DEBIT;
	}


	@Override
	public double ammount() {
	
		return this.ammount;
	}

	
	@Override
	public String documentAccountFrom() {
		throw new RuntimeException("Forbiden method");
	}


	@Override
	public String documentAccountTo() {
		return document;
	}
}
