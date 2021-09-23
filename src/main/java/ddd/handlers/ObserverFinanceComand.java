package ddd.handlers;

import ddd.comands.FinanceComand;
import ddd.entity.FinanceOperation;

public interface ObserverFinanceComand< C extends FinanceComand> {
	FinanceOperation operation();
	 void  listen(C comand);
}
