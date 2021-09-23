package ddd.handlers.impl;

import ddd.comands.FinanceComand;
import ddd.entity.Account;
import ddd.entity.FinanceOperation;
import ddd.handlers.ObserverFinanceComand;
import ddd.respository.AccountRepository;

public class DebitHandler implements ObserverFinanceComand<FinanceComand> {
	private AccountRepository accountRepository;
	public DebitHandler(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public FinanceOperation operation() {
	
		return FinanceOperation.DEBIT;
	}

	@Override
	public void listen(FinanceComand comand) {
	
		try {
			Account account = this.accountRepository.get(comand.documentAccountTo());
			account.debit(comand.ammount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
