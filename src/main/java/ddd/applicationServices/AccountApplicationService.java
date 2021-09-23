package ddd.applicationServices;

import ddd.FinancialPublisher;
import ddd.comands.impl.CreditComand;
import ddd.comands.impl.DebitComand;
import ddd.comands.impl.TransferComand;
import ddd.entity.Account;
import ddd.entity.AccountBuilder;
import ddd.respository.AccountRepository;

public class AccountApplicationService {
	private AccountRepository accountRepository;
	private FinancialPublisher publisher;
	public AccountApplicationService(AccountRepository accountRepository, FinancialPublisher publisher) {
		this.accountRepository = accountRepository;
		this.publisher = publisher;
	}
	
	public void  create(String document) {
		Account account = new AccountBuilder(document).build();
		this.accountRepository.save(account);
	}
	
	public void  credit(String accountDocument, double ammount) {
		CreditComand creditComand = new CreditComand(accountDocument, ammount);
		this.publisher.publish(creditComand);
	}
	
	public void debit(String accountDocument, double ammount) {
		DebitComand debitComand = new DebitComand(accountDocument, ammount);
		this.publisher.publish(debitComand);
	}
	
	public Account get(String document) throws Exception {
		return this.accountRepository.get(document);
	}
	
	public void transfer(String documentFrom,String documentTo, double ammount) {
		TransferComand transferComand = new TransferComand(documentFrom, documentTo, ammount);
		this.publisher.publish(transferComand);
		
	}
	
}
