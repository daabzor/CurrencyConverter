package daabzor.currencies;
import java.io.IOException;

 class Currencies {
	private String transaction;
	private int budget;
	private String currency;
	
	private String currencyName;
	private int currencyValue;
	private double ratio;
	
	Currencies(String transaction, int budget, String currency) {
		this.transaction = transaction;
		this.budget = budget;
		this.currency = currency;
	}
	
	void setCurrency() {
		String[] pairs = currency.split(" ");
		currencyValue = Integer.parseInt(pairs[0].toString());
		currencyName = pairs[1].toString();
	}
	
	void setRatio() throws IOException {
		Nbp currencyRatio = new Nbp(getTransaction(), getCurrencyName());
		currencyRatio.setRatio();
		ratio = Double.parseDouble(currencyRatio.getRatio().replace(",", "."));
	}
	
	private String getTransaction() {
		return transaction;
	}
	
	private int getBudget() {
		return budget;
	}
	
	private String getCurrencyName() {
		return currencyName;
	}
	
	private int getCurrencyValue() {
		return currencyValue;
	}
	
	private double getRatio() {
		return ratio;
	}
	
	void result() {
		CurrencyCalculator result = new CurrencyCalculator(getRatio(), getCurrencyValue(), getBudget(), getTransaction());
		result.result();
	}	
}
