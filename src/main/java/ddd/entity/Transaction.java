package ddd.entity;

public class Transaction {
	private String type;
	private double ammount;
	public Transaction(String type , double ammount) {
		this.ammount = ammount;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public double getAmmount() {
		return this.ammount;
	} 
	
}
