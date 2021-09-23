package ddd.comands;

import ddd.entity.FinanceOperation;

public interface FinanceComand {
	public FinanceOperation operation();
	public double ammount(); 
	public String documentAccountFrom();
	public String documentAccountTo();
}
