package ddd.handlers.impl;

import ddd.comands.FinanceComand;
import ddd.domainServices.TransferService;
import ddd.entity.Account;
import ddd.entity.FinanceOperation;
import ddd.handlers.ObserverFinanceComand;
import ddd.respository.AccountRepository;

public class TransferHandler implements ObserverFinanceComand<FinanceComand>{
	private AccountRepository accountRepository;
	public TransferHandler(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public FinanceOperation operation() {
		return FinanceOperation.TRANSFER;
	}
	
	@Override
	public void listen(FinanceComand comand) {
		try {
			Account accountFrom = this.accountRepository.get(comand.documentAccountFrom());
			Account accountTo = this.accountRepository.get(comand.documentAccountTo());
			
			TransferService transferService = new TransferService();
			transferService.transfer(accountFrom, accountTo, comand.ammount());
		}catch (Exception e) {
			
		}

	}



}
