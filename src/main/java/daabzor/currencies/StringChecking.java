package daabzor.currencies;

public class StringChecking {
	
	enum Currency { 
		
		USD("dolara merykañski"), AUD("dolar australijski"), CAD("dolar kanadyjski"), EUR("euro"), HUF("forint"), CHF("frank szwajcarski"), GBP("funt szterling"), JPY("jen"), CZK("korona czeska"), DKK("korona duñska"), NOK("korona norweska"), SEK("korona szwedzka"), XDR("SDR");
		
		Currency (String name) {
			this.name = name;
		}
		
		private String name;
		
		public String getName() {
			return name;
		}
		
	}
	
	public static void printEnum() {
		for (Currency n : Currency.values()) {
			System.out.print(n + " ");
		}
	}
	
	public static boolean isValidBudget(String budget) {
		int count = 0;
		
		if (budget.equals("") || budget == null) {
			return false;
		}
		for (int i = 0; i < budget.length(); i++) {
			if (Character.isDigit((budget.charAt(i)))) {
				count++;
			}
		}
		if (count == budget.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidCurrencyName(String name) {
		for (Currency n : Currency.values()) {
			if (n.name().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidTransaction(String transaction) {
		if (transaction.equalsIgnoreCase("buy") || transaction.equalsIgnoreCase("sell")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidStringCurrency(String currency) {
		int count = 0;
		
		if (currency == null || !currency.contains(" ")) {
			return false;
		}
		for (int i = 0; i < currency.length(); i++) {
			if (currency.charAt(i) == ' ') {
				count++;
			}
		}
		if (count != 1 || count == currency.length()) {
			return false;
		}
		count = 0;
		
		String[] pairs = currency.split(" ");
		for (int i = 0; i < pairs[0].length(); i++) {
			if (Character.isDigit((pairs[0].charAt(i)))) {
				count++;
			}
		}
		if (count != pairs[0].length() || pairs[0].equals("0")) {
			return false;
		}
		count = 0;
		
		for (int i = 0; i < pairs[1].length(); i++) {
			if (Character.isLetter((pairs[1].charAt(i)))) {
				count++;
			}
		}
		if (count == pairs[1].length() && pairs[1].length() == 3) {
			return true;
		} else {
			return false;
		}	
	}

}
