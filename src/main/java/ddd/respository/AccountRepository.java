package ddd.respository;

import ddd.entity.Account;

public interface AccountRepository {
	public void save(Account account);
	public Account get(String document) throws Exception ;
}