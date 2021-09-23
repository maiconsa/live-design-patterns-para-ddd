package ddd.comands.impl;

import ddd.comands.FinanceComand;
import ddd.entity.FinanceOperation;

public class TransferComand implements   FinanceComand {
	private String documentFrom;	
	private String documentTo;
	private double ammount;
	public TransferComand(String documentFrom, String documentTo, double ammount) {
		this.documentFrom = documentFrom;
		this.documentTo = documentTo;
		this.ammount = ammount;
		
	}
	
	@Override
	public FinanceOperation operation() {
		return FinanceOperation.TRANSFER;
	}

	@Override
	public double ammount() {
		return this.ammount;
	}
	
	@Override
	public String documentAccountFrom() {
		return documentFrom;
	}

	@Override
	public String documentAccountTo() {
		return documentTo;
	}

}
