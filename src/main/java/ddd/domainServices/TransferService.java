package ddd.domainServices;

import ddd.entity.Account;

public class TransferService {

	public void transfer(Account accountFrom, Account accountTo, double ammount) {
		accountFrom.debit(ammount);
		accountTo.credit(ammount);
	}

}
