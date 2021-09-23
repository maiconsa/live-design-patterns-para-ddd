package ddd.respository.impl;

import java.util.ArrayList;
import java.util.List;

import ddd.entity.Account;
import ddd.respository.AccountRepository;

public class AccountRepositoryMemory implements AccountRepository {
	private List<Account> accounts;
	public AccountRepositoryMemory() {
		this.accounts = new ArrayList<>();
	}
	public void save(Account account) {
		this.accounts.add(account);
	}
	@Override
	public Account get(String document) throws Exception {
		return this.accounts.stream().filter(acc -> acc.getDocument().equals(document))
				.findFirst().orElseThrow(  () -> new Exception("Account not find"));
	}
	
	
}
