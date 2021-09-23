package ddd;

import java.util.ArrayList;
import java.util.List;

import ddd.comands.FinanceComand;
import ddd.handlers.ObserverFinanceComand;

public class FinancialPublisher {
	private List<ObserverFinanceComand< FinanceComand   >> observers;
	
	public FinancialPublisher() {
		this.observers = new ArrayList< >();
	}
	
	public  void register(ObserverFinanceComand<FinanceComand> observer) {
		this.observers.add(observer);
	}
	
	public  void publish( FinanceComand comand) {
		this.observers.parallelStream().forEach(observer -> {
			if(	observer.operation() == comand.operation()) {
				observer.listen(comand);
			}
		});
	}
}
