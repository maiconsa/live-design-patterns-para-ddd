package ddd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import ddd.applicationServices.AccountApplicationService;
import ddd.comands.impl.TransferComand;
import ddd.entity.Account;
import ddd.entity.AccountBuilder;
import ddd.handlers.impl.CreditHandler;
import ddd.handlers.impl.DebitHandler;
import ddd.handlers.impl.TransferHandler;
import ddd.respository.AccountRepository;
import ddd.respository.impl.AccountRepositoryMemory;

@ExtendWith(MockitoExtension.class)
public class AccountTest {
	AccountApplicationService accountApplicationService ;
	
	private static final String DOCUMENT_FROM = "000.000.000-00";
	private static final String DOCUMENT_TO = "000.000.000-01";

	
	
	@BeforeEach
	public void setup() {
		AccountRepository accountRepository = new AccountRepositoryMemory();
		FinancialPublisher publisher = new FinancialPublisher();
		
		publisher.register(new CreditHandler(accountRepository));
		publisher.register(new DebitHandler(accountRepository));
		publisher.register( new TransferHandler(accountRepository));
		
		 accountApplicationService = new AccountApplicationService(accountRepository,publisher);
	}
	
	@Test
	public void deveCriarUmaContaComSucesso() {
		Account account = 
				new AccountBuilder(DOCUMENT_FROM)
				.bank("001")
				.account("11112-9")
				.branch("001")
				.build();
		
		assertEquals(account.getBalance(),0 );
	}
	
	@Test
	public void deveCriarUmaContaSeguidoDeDepositoComSucesso() throws Exception {
		accountApplicationService.create(DOCUMENT_FROM);
		
		accountApplicationService.credit(DOCUMENT_FROM, 100.50);
		
		Account account = accountApplicationService.get(DOCUMENT_FROM);
		assertEquals(account.getBalance(),100.50);
	}
	
	@Test
	public void deveDebitarComSucesso() throws Exception {
		accountApplicationService.create(DOCUMENT_FROM);

		accountApplicationService.credit(DOCUMENT_FROM, 1000.0);
		accountApplicationService.debit(DOCUMENT_FROM, 500.0);

		Account account = accountApplicationService.get(DOCUMENT_FROM);
		assertEquals(account.getBalance(), 500.0);
	}
	
	

 @Test public void deveCriarDuasContasSeguidaDeTransferencia() throws Exception { 
	 
	 this.accountApplicationService.create(DOCUMENT_FROM);
 this.accountApplicationService.create(DOCUMENT_TO);

 
 this.accountApplicationService.credit(DOCUMENT_FROM, 1000);
 this.accountApplicationService.credit(DOCUMENT_TO, 500);

 this.accountApplicationService.transfer(DOCUMENT_FROM, DOCUMENT_TO, 700);
 
 Account accountFrom = this.accountApplicationService.get(DOCUMENT_FROM);
 Account accountTo = this.accountApplicationService.get(DOCUMENT_TO);

 
 assertEquals(accountFrom.getBalance(), 300);
 assertEquals(accountTo.getBalance(), 1200);

 }

	
}
