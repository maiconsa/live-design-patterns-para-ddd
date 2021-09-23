package ddd.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String bank;

	private String branch;
	private String account;

	private String document;

	private List<Transaction> transactions;

	Account(AccountBuilder accountBuilder) {
		this.account = accountBuilder.getAccount();
		this.bank = accountBuilder.getBank();
		this.branch = accountBuilder.getBranch();
		this.document = accountBuilder.getDocument();

		this.transactions = new ArrayList<Transaction>();

	}

	public void credit(double credit) {

		this.transactions.add(new Transaction("credit", credit));
	}

	public double getBalance() {
		return this.transactions.stream().mapToDouble(transaction -> {
			double ammount = transaction.getAmmount();
			return transaction.getType() == "debit" ? ammount * -1 : ammount;

		}).sum();
	}

	public String getDocument() {
		return this.document;
	}

	public void debit(double debit) {

		this.transactions.add(new Transaction("debit", debit));
	}

}
