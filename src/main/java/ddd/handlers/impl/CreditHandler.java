package ddd.handlers.impl;

import ddd.comands.FinanceComand;
import ddd.entity.Account;
import ddd.entity.FinanceOperation;
import ddd.handlers.ObserverFinanceComand;
import ddd.respository.AccountRepository;

public class CreditHandler implements ObserverFinanceComand<FinanceComand> {
	private AccountRepository accountRespotory;
	public CreditHandler(AccountRepository accountRepository ) {
		this.accountRespotory = accountRepository;
	}
	
	@Override
	public FinanceOperation operation() {
		return FinanceOperation.CREDIT;
	}

	@Override
	public void listen(FinanceComand comand) {
		try {
			Account account = this.accountRespotory.get(comand.documentAccountTo());
			account.credit(comand.ammount());
		} catch (Exception e) {
			
		}
		
	}

}
