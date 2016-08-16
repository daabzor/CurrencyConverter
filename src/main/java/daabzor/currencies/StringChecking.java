package daabzor.currencies;

public class StringChecking {
	
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
