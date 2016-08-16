package daabzor.currencies;

import java.text.NumberFormat;

class CurrencyCalculator {
	private double ratio;
	private int currency;
	private int budget;
	private String transaction;
	private double changedCurrency;
	
	CurrencyCalculator(double ratio, int currency, int budget, String transaction) {
		this.ratio = ratio;
		this.currency = currency;
		this.budget = budget;
		this.transaction = transaction;
	}
	
	private void setChangedCurrency() {
		this.changedCurrency =  currency * ratio;
	}
	
	private void sellCurrency() {
		setChangedCurrency();
		NumberFormat moneyFormater = NumberFormat.getCurrencyInstance();
		System.out.println("You will have: " + moneyFormater.format(changedCurrency + budget));
	}
	
	private void buyCurrency() {
		setChangedCurrency();
		NumberFormat moneyFormater = NumberFormat.getCurrencyInstance();
		if (changedCurrency <= budget){
			System.out.println("You need to buy currency: " + moneyFormater.format(changedCurrency));
		} else {
			System.out.println("It's impossible. You don't have enought money. You need: " + moneyFormater.format(changedCurrency));
		}
	}
	
	void result(){
		if (transaction.equals("sell")) {
			sellCurrency();
		} else {
			buyCurrency();
		}
	}
	
}
